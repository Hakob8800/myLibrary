package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAuthor")
public class UpdateAuthorServlet extends HttpServlet {
    private final AuthorManager AUTHOR_MANAGER = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Author author = AUTHOR_MANAGER.getById(id);
        req.setAttribute("author", author);
        req.getRequestDispatcher("WEB-INF/updateAuthor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author author = new Author();
        author.setId(Integer.parseInt(req.getParameter("id")));
        author.setName(req.getParameter("name"));
        author.setSurname(req.getParameter("surname"));
        author.setEmail(req.getParameter("email"));
        author.setAge(Integer.parseInt(req.getParameter("age")));
        AUTHOR_MANAGER.update(author);
        resp.sendRedirect("/authors");
    }
}
