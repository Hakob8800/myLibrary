package servlet;

import manager.UserManager;
import model.User;
import model.UserType;
import util.EmailValidator;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String msg = "";
        if (name == null || name.trim().equals("")) {
            msg += "The name is required.<br>";
        }
        if (surname == null || surname.trim().equals("")) {
            msg += "The surname is required.<br>";
        }
        if (email == null || email.trim().equals("")) {
            msg += "The email is required.<br>";
        } else if (!EmailValidator.patternMatches(email)) {
            msg += "Email format is incorrect<br>";
        }
        if (password == null || password.trim().equals("")) {
            msg += "The password is required.<br>";
        } else if (password.length() < 6) {
            msg += "The password must be >= 6<br> ";
        }
        if(msg.equals("")){
            if (userManager.getByEmail(email) == null) {
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setPassword(password);
                user.setUserType(UserType.valueOf(req.getParameter("type")));
                userManager.save(user);
                resp.sendRedirect("/");
            }
        }
        else {
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }

    }
}
