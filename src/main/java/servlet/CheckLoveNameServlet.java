package servlet;

import entity.Love;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/CheckLoveNameServlet")
public class CheckLoveNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String loveName = request.getParameter("loveName");
        String userId = request.getParameter("userId");

        Love love = new Love();
        love.setUserId(userId);
        love.setLoveName(loveName);


        if (ServiceFactory.getLoveServiceImpl().checkLoveName(love)){
            out.write("true");//没有存在
        }else {
            out.write("false");//已经存在
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
