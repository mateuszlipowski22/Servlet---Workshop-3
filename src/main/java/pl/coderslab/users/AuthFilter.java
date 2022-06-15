package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/user/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        if(session.getAttribute("username").equals("admin")){
            request.setAttribute("loginAuthentication", "1");
        }else if(session.getAttribute("username").equals("user")){
            request.setAttribute("loginAuthentication", "1");
        }else{
            request.setAttribute("incorrectLogin", "1");
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
