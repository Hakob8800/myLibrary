package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        if (userManager.getByEmail(req.getParameter("email")) == null) {
            user.setName(req.getParameter("name"));
            user.setSurname(req.getParameter("surname"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            userManager.save(user);
        }
        resp.sendRedirect("/");
    }
}
