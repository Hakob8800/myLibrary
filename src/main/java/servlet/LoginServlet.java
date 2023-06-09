package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String invalidLogOrPasMsg = "Wrong user name or password.";
        User user = userManager.getByEmailAndPassword(email, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            req.getSession().setAttribute("msg",invalidLogOrPasMsg);
            resp.sendRedirect("/");
        }
    }

}
