package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/SearchByMusicNameServlet")
public class SearchByMusicNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String musicName=request.getParameter("musicName");
        List<Music_a> musics=new ArrayList<Music_a>();
        musics= ServiceFactory.getSearchServiceImpl().FindMusicName(musicName);
        Map result=new HashMap();
        result.put("musics",musics);

        String json= JSON.toJSONString(result);
        PrintWriter out=response.getWriter();

        out.write(json);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String musicName=request.getParameter("musicName");
        String musicId=request.getParameter("musicId");
        String singer=request.getParameter("singer");
        String albumId=request.getParameter("albumId");
        String lyricSrc=request.getParameter("lyricSrc");
        String musicSrc=request.getParameter("musicSrc");
        String picSrc=request.getParameter("picSrc");

        Music music =new Music();
        music.setMusicId(musicId);
        music.setMusicName(musicName);
        music.setSinger(singer);
        music.setAlbumId(albumId);
        music.setLyricSrc(lyricSrc);
        music.setMusicSrc(musicSrc);
        music.setPicSrc(picSrc);
        List<Music_a> musics=new ArrayList<Music_a>();

        musics= ServiceFactory.getSearchServiceImpl().FindMusicName(musicName);
        System.out.println(musics.size());
        PrintWriter out=response.getWriter();

        String jsonArray= JSONArray.toJSONString(musics);
        System.out.println(jsonArray);
        out.write(jsonArray);
        out.flush();
        out.close();
    }
}
