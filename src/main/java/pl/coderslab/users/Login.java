package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    private final static String USER = "admin";
    private final static String PASSWORD = "admin";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("loginForm", "1");
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        UserDAO userDAO = new UserDAO();

        if (user.equals(USER) && pass.equals(PASSWORD)) {

            HttpSession session = req.getSession();
            session.setAttribute("username","admin");
            req.setAttribute("loginAuthentication", "1");
            getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);

        } else if(userDAO.isPasswordValid(user, pass)){

            HttpSession session = req.getSession();
            session.setAttribute("username","user");
            req.setAttribute("loginAuthentication", "1");
            getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);

        }else{
            req.setAttribute("incorrectLogin", "1");
            getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);
        }

    }
}
