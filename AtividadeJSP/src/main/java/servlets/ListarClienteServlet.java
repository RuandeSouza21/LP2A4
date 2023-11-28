package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import org.hibernate.Session;
import util.HibernateUtil;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/ListarCliente")
public class ListarClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Cliente> clientes = session.createQuery("from Cliente", Cliente.class).list();

        req.setAttribute("clientes", clientes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("listarCliente.jsp");
        dispatcher.forward(req, resp);
    }
}
