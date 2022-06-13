package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/edit")
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idEdit=Integer.parseInt(req.getParameter("idEdit"));
        UserDAO userDAO = new UserDAO();

        req.setAttribute("userEdit", userDAO.read(idEdit));

        req.setAttribute("editForm", "1");
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userEditName");
        String password = req.getParameter("emailEdit");
        String email = req.getParameter("passwordEdit");
        int idEdit=Integer.parseInt(req.getParameter("idEdit"));

        UserDAO userDAO = new UserDAO();

        User user = userDAO.read(idEdit);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        userDAO.update(user);

        req.setAttribute("editForm", 0);
        req.setAttribute("showList", "1");
        getServletContext().getRequestDispatcher("/user/list").forward(req, resp);
    }
}
