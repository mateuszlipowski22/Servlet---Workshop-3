package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/user/add")
public class UserAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("addForm", "1");
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        UserDAO userDAO = new UserDAO();

        boolean userVerified = true;

        if(userName.equals("") || password.equals("") || email.equals("")){
            req.setAttribute("emptyField", 1);
            userVerified = false;
        }


        if(!userDAO.verifyEmail(email)) {
            req.setAttribute("incorrectEmail", 1);
            userVerified = false;
        }

        if(!userDAO.isUsernameAvailable(userName)){
            req.setAttribute("usernameTaken", 1);
            userVerified = false;

        }

        if(!userDAO.isEmailAvailable(email)) {
            req.setAttribute("emailTaken", 1);
            userVerified = false;
        }

        if(userVerified){
            User user = new User();
            user.setUserName(userName);
            user.setEmail(email);
            user.setPassword(password);
            userDAO.create(user);

            req.setAttribute("addForm", 0);
            req.setAttribute("showList", "1");
        }else{
            req.setAttribute("addForm", 1);
        }

        getServletContext().getRequestDispatcher("/user/list").forward(req, resp);
    }
}
