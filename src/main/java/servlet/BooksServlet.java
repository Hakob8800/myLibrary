package servlet;

import manager.BookManager;
import model.Book;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = null;
        User user = (User) req.getSession().getAttribute("user");

        String keyword = req.getParameter("keyword");
        if (keyword == null || keyword.equals("")) {
            if (user.getUserType() == UserType.USER) {
                books = bookManager.getByUserId(user.getId());
            } else {
                books = bookManager.getAll();
            }
        } else {
            books = bookManager.searchByKeyword(keyword);
        }
        req.setAttribute("books", books);
        req.getRequestDispatcher("WEB-INF/books.jsp").forward(req, resp);
    }
}
