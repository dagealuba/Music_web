package servlet;

import com.alibaba.fastjson.JSONArray;
import factory.ServiceFactory;
import util.Music_a;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetMusicServlet")
public class GetMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String s = request.getParameter("musicIds");

        String[] musicIds = s.split(",");

        List<Music_a> music_as = new ArrayList<>();
        for (String musicId:musicIds){
            Music_a music_a = ServiceFactory.getSearchServiceImpl().FindMusicById(musicId);
            music_as.add(music_a);
        }

        PrintWriter out = response.getWriter();

        out.write(JSONArray.toJSONString(music_as));
    }
}
