package servlet;

import com.alibaba.fastjson.JSON;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SearchMusicByIdServlet")
public class SearchMusicByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String musicId = request.getParameter("musicId");

        PrintWriter out = response.getWriter();

        String music = JSON.toJSONString(ServiceFactory.getSearchServiceImpl().FindMusicById(musicId));

        out.write(music);

    }
}
