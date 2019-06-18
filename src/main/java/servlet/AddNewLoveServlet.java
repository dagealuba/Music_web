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

@WebServlet("/AddNewLoveServlet")
public class AddNewLoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String loveName = request.getParameter("loveName");
        String musicId = request.getParameter("musicId");
        String userId = request.getParameter("userId");
        String id = UUID.randomUUID().toString();

        if (musicId.equals("null")){
            musicId = null;
        }
        Love love = new Love();
        love.setLoveId(id);
        love.setMusicId(musicId);
        love.setUserId(userId);
        love.setLoveName(loveName);

        if (ServiceFactory.getLoveServiceImpl().addLove(love)){
            out.write("true");
        }
        else out.write("false");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
