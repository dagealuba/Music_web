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
import java.util.List;

@WebServlet("/CheckLovedServlet")
public class CheckLovedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String musicId = request.getParameter("musicId");
        String userId = request.getParameter("userId");

        List<String> loveNames = ServiceFactory.getLoveServiceImpl().getLoveNames(userId);

        String flag = "false";
        for (String loveName:loveNames){
            Love love = new Love(loveName,musicId,userId);

            if (!ServiceFactory.getLoveServiceImpl().checkLoved(love)){
                 flag = "true";
                 break;
            }
        }

        out.write(flag);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
