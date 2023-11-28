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
import java.util.Collections;
import java.util.List;

@WebServlet(value = "/DetalharCliente")
public class DetalhesClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("detalhesCliente.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            int id = Integer.parseInt(req.getParameter("id"));

            Session session = HibernateUtil.getSessionFactory().openSession();

            List<Cliente> clientes = session.createQuery("from Cliente", Cliente.class).list();

            Cliente cliente = null;

            for (Cliente cada : clientes) {
                if (cada.getId() == id) {
                    cliente = cada;
                }
            }

            req.setAttribute("cliente", cliente);

            RequestDispatcher dispatcher = req.getRequestDispatcher("detalhesCliente.jsp");
            dispatcher.forward(req, resp);

    }
}
