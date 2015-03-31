package chapter5.cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wyzhangdongsheng1 on 2014/9/16.
 */
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("username");
        Cookie cookie = new Cookie("username", name);
        cookie.setMaxAge(60 * 30);
        resp.addCookie(cookie);

        RequestDispatcher view = req.getRequestDispatcher("cookieresult.jsp");
        view.forward(req,resp);
    }
}
