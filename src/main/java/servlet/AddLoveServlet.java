package servlet;

import com.alibaba.fastjson.JSON;
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

@WebServlet("/AddLoveServlet")
public class AddLoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");
        String musicId = request.getParameter("musicId");
        String loveName = request.getParameter("loveName");
        String loveId = UUID.randomUUID().toString();

        Love love = new Love(loveId,loveName,userId,musicId);

        PrintWriter out = response.getWriter();

        if (ServiceFactory.getLoveServiceImpl().addLove(love)){
            out.write("true");
        }
        else out.write("false");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
