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

@WebServlet(name = "UpdateMusicServlet")
public class UpdateMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String musicId = "";
        String fileName="";

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServleFileUpload upload = new ServletFileUpload(factory);

        upload.setHeaderEncoding("UTF-8");

        PrintWriter printWriter = response.getWriter();

        HashMap<String,String>flag = new HashMap<>();
        int i =1;
        try{
            List<FileItem>files  = upload.parseRequest(request);
            String path = request.getSession().getServletContext().getRealPath("/");
            String host = "http://47.107.238.107/Music";

            for(FileItem item:files){
                if(item.isFormField()){
                    musicId = item.getString("UTF-8");
                }
            }

            for(FileItem item:files){
                if(item.isFormField()){
                    continue;
                }else {
//                    重新上传音乐到服务器
                    fileName = path + "music/" + item.getName();
                }


                    InputStream in = item.getInputStream();

                    byte[] buffer = new byte[1024];
                    int len = 0;

                    OutputStream outputStream = new FileOutputStream(fileName);
                    while ((len = in.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }

                    outputStream.close();
                    in.close();

                //重新获取音乐信息并修改数据库
                Music music =  new Music();
                File file = new File(fileName);

                //获取对应的musicName,singer,albumName
                String singer = Mp3Util.getString(file);
                String songName = Mp3Util.getSongName(file);
                String albumName = Mp3Util.getAlbum(file);

                List<Music> musicList = ServiceFactory.getMusicService().getMusicsByName(songName);
                String albumId = "";
                List<Album> albums = ServiceFactory.getAlbumService().getAlbumsByName(albumName);
                if(albums.size()>0){
                    for(Album album:albums){
                        if(album.getSinger().equals(singer)){
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
                String type = Mp3Util.uploadPic(file,path+"/"+item.getName()+".jpg",true);
                if(type!=null){
                    if(!type.equals("other")){
                        picSrc = host+"pic/"+item.getName()+"."+type;
                    }
                }
                //歌曲地址
                String musicSrc = host+"music/"+item.getName();

                music.setMusicId(musicId);
                music.setSigner(singer);
                music.setMusicName(songName);
                music.setPicSrc(picSrc);
                music.setMusicSrc(musicSrc);
                music.setAlbumId(albumId);
                music.setLyricSrc("");

                //更新至数据库
                if(ServiceFactory.getMusicService().updateMusic(music)){
                    flag.put("flag",true);
                }else{
                    flag.put("error"+1,item.getName());
                }
                i++;
            }
        }catch (FileUploadException e){
            e.printStackTrce();
        }

        String res = JSON.toJSONString(flag);
        printWriter.write(res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
