package servlet;

import com.alibaba.fastjson.JSONObject;
import entity.Music;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteMusicServlet")
public class DeleteMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String musicname = request.getParameter("musicname");
        String singer = request.getParameter("singer");

        Music music = ServiceFactory.getMusicService().findMusicByNameAndSinger(musicname,singer);

        PrintWriter out = response.getWriter();
        if(music!=null){
           boolean m = ServiceFactory.getMusicService().deleteMusic(music);
           if(m){
               out.write("歌曲删除成功");
           }
           else{
               out.write("歌曲删除失败");
           }

        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
