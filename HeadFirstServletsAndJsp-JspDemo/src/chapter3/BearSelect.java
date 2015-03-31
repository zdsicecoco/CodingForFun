package chapter3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wyzhangdongsheng1 on 2014/9/5.
 */
public class BearSelect extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        out.println("Beer Selection Advice<Br>");
        String c = request.getParameter("color");
//        out.println("Got beer color " + c);
        List bears = new BearExpert().getBrands(c);
//        for(int i = 0; i < bears.size(); i++)
//            out.println(bears.get(i));
        request.setAttribute("styles", bears);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
