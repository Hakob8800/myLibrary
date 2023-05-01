package servlet;

import manager.BookManager;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private final BookManager BOOK_MANAGER = new BookManager();
    private final String UPLOAD = "C:\\Java\\myLibrary\\Upload\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));
        Book book = BOOK_MANAGER.getById(bookId);
        if (book != null) {
            if (book.getImagePath() != null || book.getImagePath().equalsIgnoreCase("null")) {
                File file = new File(UPLOAD + book.getImagePath());
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        BOOK_MANAGER.removeById(bookId);
        resp.sendRedirect("/books");
    }
}
