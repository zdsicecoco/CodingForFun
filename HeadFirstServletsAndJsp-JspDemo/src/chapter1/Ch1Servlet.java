package chapter1;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by wyzhangdongsheng1 on 2014/9/3.
 */
public class Ch1Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Date today = new Date();
        out.println("<html> " + "<body>" + "<h1 align=center>HF\'s Chapter1 Servlet</h1>" + "<br>" + today + "<br>");
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            out.println(cookies[i] + "<br>");
        }
        String client = request.getHeader("User-Agent");
        out.println(client + "<br>");
        String con = getServletConfig().getInitParameter("emailAddress");
        out.println(con);
        System.out.println("zds:" + con);

        ServletContext context = getServletContext();
        out.println(context.getInitParameter("zdsname"));

        out.println("</body>" + "</html>");
        out.close();
    }



}
