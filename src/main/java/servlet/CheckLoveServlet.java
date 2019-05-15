package servlet;

import com.alibaba.fastjson.JSON;
import  com.alibaba.fastjson.JSONArray;
import entity.Love;
import entity.Music;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CheckLoveServlet")
public class CheckLoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String loveName = request.getParameter("loveName");
        String userId = request.getParameter("userId");
        List<Love> loves = ServiceFactory.getLoveService().findLovesByUserId(userId);
        List<Music>musics = new ArrayList<Music>();
        for(Love l:loves)
        {
            if(l.getLoveName().equals(loveName))
            {
                musics = ServiceFactory.getLoveService().findMusicsInLove(l);
            }
        }

        PrintWriter out = response.getWriter();

        String jsonArray = JSONArray.toJSONString(musics);
        System.out.println(jsonArray);
        out.write(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
