package chapter5.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wyzhangdongsheng1 on 2014/9/11.
 */
public class ListenerTester extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();//字符
        printWriter.println("test context attributes set by listener<br>");
        Dog dog = (Dog) getServletContext().getAttribute("dog");
        ServletContext servletContext = getServletContext();
        synchronized (servletContext){
            servletContext.getAttributeNames();
        }
        printWriter.println(dog.getBreed());
        printWriter.close();
    }
}
