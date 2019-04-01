package servlet;

import com.alibaba.fastjson.JSON;
import entity.Album;
import entity.Music;
import factory.ServiceFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.Mp3Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@WebServlet("/UploadMusicServlet")
public class UploadMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

//        response.setHeader("Transfer-Encoding","chunked");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setHeaderEncoding("UTF-8");

        PrintWriter printWriter = response.getWriter();

        HashMap<String, String> flag = new HashMap<>();
        int i = 1;
        try {
            List<FileItem> files = upload.parseRequest(request);
            String path = request.getSession().getServletContext().getRealPath("/");
            String host = "http://47.107.238.107/Music/";

            for (FileItem item: files){
                if (item.isFormField()) {
                    continue;
                }

                //存音乐到服务器
                String fileName = path+"music/"+item.getName();

                InputStream in = item.getInputStream();

                byte[] buffer = new byte[1024];
                int len = 0;

                OutputStream outputStream = new FileOutputStream(fileName);

                while ((len = in.read(buffer)) != -1){
                    outputStream.write(buffer,0,len);
                }

                outputStream.close();
                in.close();


                //获取音乐信息并写入数据库
                Music music = new Music();

                File file = new File(fileName);

                //获取musicName,singer,albumName
                String singer = Mp3Util.getSinger(file);
                String songName = Mp3Util.getSongName(file);
                String albumName = Mp3Util.getAlbum(file);


                List<Music> musicList = ServiceFactory.getMusicService().getMusicsByName(songName);

                //获取专辑id，如果没有专辑则新建一个专辑
                String albumId = "";
                List<Album> albums = ServiceFactory.getAlbumService().getAlbumsByName(albumName);
                if (albums.size()>0){
                    for (Album album: albums){
                        if (album.getSinger().equals(singer)){
                            albumId = album.getAlbumId();
                            break;
                        }
                    }
                }

                if (albumId.equals("")){
                    Album album = new Album(UUID.randomUUID().toString(),albumName,singer);
                    if (ServiceFactory.getAlbumService().addAlbum(album)){
                        albumId = album.getAlbumId();
                    }
                }

                //获取封面图片
                String picSrc = "";
                String type = Mp3Util.uploadPic(file,path+"pic/"+item.getName()+".jpg",true);
                if ( null != type ){
                    if ( !type.equals("other") ){
                        picSrc = host + "pic/" + item.getName() + "." + type;
                    }
                }
                //歌曲地址
                String musicSrc = host + "music/" + item.getName();
                String musicId = UUID.randomUUID().toString();

                music.setMusicId(musicId);
                music.setSigner(singer);
                music.setMusicName(songName);
                music.setPicSrc(picSrc);
                music.setMusicSrc(musicSrc);
                music.setAlbumId(albumId);
                music.setLyricSrc("");

                //添加至数据库
                if (ServiceFactory.getMusicService().addMusic(music)){
                    flag.put("flag","true");
                }
                else {
                    flag.put("error" + i, item.getName());
                }
                i++;

            }

        }catch (FileUploadException e){
            e.printStackTrace();
        }

        String res = JSON.toJSONString(flag);

//        System.out.println(response.getHeader("Content-Length"));

//        response.setContentLength(res.length());
        printWriter.write(res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
