package servlet;

import manager.BookManager;
import model.Book;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strForSearch = req.getParameter("strForSearch");
        List<Book> books = bookManager.searchByTitle(strForSearch);
        req.setAttribute("books", books);
        req.getRequestDispatcher("WEB-INF/searchedBooks.jsp").forward(req, resp);
    }
}
