package servlet;

import com.alibaba.fastjson.JSONArray;
import entity.PlayList;
import factory.ServiceFactory;
import util.Music_a;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetPlayListServlet")
public class GetPlayListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");

        List<Music_a> music_as = ServiceFactory.getPlayListServiceImpl().getUserPlayList(userId);

        PrintWriter out = response.getWriter();
        out.write(JSONArray.toJSONString(music_as));
    }
}
