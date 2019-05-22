package servlet;

import com.alibaba.fastjson.JSON;
import entity.History;
import entity.Music;
import entity.Music_a;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetLatestHistoryServlet")
public class GetLatestHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");
        History history = ServiceFactory.getHistoryServiceImpl().getUserLatestHistory(userId);

        PrintWriter out = response.getWriter();

        if (history == null){
            out.write("{\"flag\":false}");
        }
        else {
            Music_a music = ServiceFactory.getSearchServiceImpl().FindMusicById(history.getMusicId());

            out.write(JSON.toJSONString(music));
        }
    }
}
