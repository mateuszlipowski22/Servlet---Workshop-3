package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/show")
public class UserShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idShow=Integer.parseInt(req.getParameter("idShow"));
        UserDAO userDAO = new UserDAO();

        req.setAttribute("userShow", userDAO.read(idShow));

        req.setAttribute("showForm", "1");
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);
    }
}
