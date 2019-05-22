package servlet;

import entity.History;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/PlayMusicServlet")
public class PlayMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String musicId = request.getParameter("musicId");
        String historyId = UUID.randomUUID().toString();

        History history = new History(historyId,userId,musicId);

        PrintWriter out = response.getWriter();
        if (ServiceFactory.getHistoryServiceImpl().addHistory(history)){
            out.write("true");
        }
        else out.write("false");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
