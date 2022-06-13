package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/list")
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session = req.getSession();
        UserDAO userDao = new UserDAO();

//        if(Objects.isNull(session.getAttribute("userList"))){
//            User[] userList = new User[0];
//            session.setAttribute("userList", userList);
//        }

//        User[] userList = userDao.findAll();
//
//        for (User u : userList) {
//            System.out.println(u);
//        }

//        session.setAttribute("userList", userList);

        req.setAttribute("userList", userDao.findAllArray());

        userDao.printAll();

        getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
