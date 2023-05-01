package filter;

import manager.BookManager;
import model.Book;
import model.User;
import model.UserType;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/deleteBook", "/updateBook"})
public class UserIdFilter extends HttpFilter {
    private final BookManager BOOK_MANAGER = new BookManager();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        int bookId = Integer.parseInt(req.getParameter("id"));
        Book book = BOOK_MANAGER.getById(bookId);
        User user = (User) session.getAttribute("user");
        if (user.getId() != book.getUserId()&&user.getUserType()!= UserType.ADMIN) {
            response.sendRedirect("/");
        } else {
            chain.doFilter(request,response);
        }
    }
}
