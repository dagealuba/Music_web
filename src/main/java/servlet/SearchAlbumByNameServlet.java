package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import entity.Album;
import factory.ServiceFactory;
import util.Album_m;

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

@WebServlet("/SearchAlbumByNameServlet")
public class SearchAlbumByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String albumName=request.getParameter("albumName");
        List<Album> albums= new ArrayList<Album>();
        albums= ServiceFactory.getSearchServiceImpl().FindAlbumName(albumName);
        Map result=new HashMap();
        result.put("albums",albums);

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
//        String albumId=request.getParameter("albumId");
        String albumName=request.getParameter("musicName");
//        String singer=request.getParameter("singer");

        System.out.println("专辑名："+albumName);
        Album album=new Album();
//        album.setSinger(singer);
//        album.setAlbumId(albumId);
        album.setAlbumName(albumName);

        List<Album_m> albums= new ArrayList<>();

        albums= ServiceFactory.getSearchServiceImpl().FindMusicByAlbum(albumName);
//        System.out.println(albums.size());
        PrintWriter out=response.getWriter();

        out.write(JSONArray.toJSONString(albums));
    }
}
