package servlet;

import manager.AuthorManager;
import manager.BookManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAuthor")
public class DeleteAuthorServlet extends HttpServlet {
    private final BookManager BOOK_MANAGER = new BookManager();
    private final AuthorManager AUTHOR_MANAGER = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int author_id = Integer.parseInt(req.getParameter("id"));
        BOOK_MANAGER.removeByAuthorId(author_id);
        AUTHOR_MANAGER.removeById(author_id);
        resp.sendRedirect("/authors");
    }
}
