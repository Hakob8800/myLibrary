package servlet;

import manager.AuthorManager;
import manager.BookManager;
import model.Author;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    private final BookManager BOOK_MANAGER = new BookManager();
    private final AuthorManager AUTHOR_MANAGER = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = BOOK_MANAGER.getById(id);
        List<Author> authors = AUTHOR_MANAGER.getAll();
        req.setAttribute("book", book);
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("WEB-INF/updateBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setId(Integer.parseInt(req.getParameter("id")));
        book.setTitle(req.getParameter("title"));
        book.setDescription(req.getParameter("description"));
        book.setPrice(Integer.parseInt(req.getParameter("price")));
        book.setAuthor(AUTHOR_MANAGER.getById(Integer.parseInt(req.getParameter("author_id"))));
        BOOK_MANAGER.update(book);
        resp.sendRedirect("/books");
    }
}
