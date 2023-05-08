package servlet;

import manager.AuthorManager;
import manager.BookManager;
import manager.UserManager;
import model.Author;
import model.Book;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/createBook")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 8,
        maxRequestSize = 1024 * 1024 * 24,
        fileSizeThreshold = 1024 * 1024
)
public class CreateBookServlet extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();
    private BookManager bookManager = new BookManager();
    private final String UPLOAD = "C:\\Java\\myLibrary\\Upload\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> author = authorManager.getAll();
        req.setAttribute("authors", author);
        req.getRequestDispatcher("WEB-INF/createBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        String imgName = null;
        User user = (User) req.getSession().getAttribute("user");
        Part imagePart = req.getPart("coverPic");
        if (imagePart != null && imagePart.getSize() > 0) {
            imgName = System.nanoTime() + "_" + imagePart.getSubmittedFileName();
            imagePart.write(UPLOAD + imgName);
        }
        book.setTitle(req.getParameter("title"));
        book.setDescription(req.getParameter("description"));
        book.setPrice(Integer.parseInt(req.getParameter("price")));
        book.setImagePath(imgName);
        book.setAuthor(authorManager.getById(Integer.parseInt(req.getParameter("author"))));
        book.setUser(user);
        bookManager.save(book);
        resp.sendRedirect("/books");
    }
}
