package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.repository.OrderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import mk.finki.ukim.mk.lab.repository.OrderRepository;

@WebServlet(name = "logout-servlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //End session of user

        req.getSession().invalidate();
        //Redirect user to initial view /
        resp.sendRedirect("/");
    }
}
