package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FormatarData;
import util.HibernateUtil;

import java.io.IOException;

@WebServlet(value = "/AddCliente")
public class AddClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("cadCliente.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Cliente cliente = new Cliente(
                    req.getParameter("nome"),
                    FormatarData.formatarData(req.getParameter("data")),
                    req.getParameter("cpf"),
                    req.getParameter("telefone")
            );

            Session session = HibernateUtil.getSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();

            session.persist(cliente);

            transaction.commit();

            resp.sendRedirect("ListarCliente");

    }
}
