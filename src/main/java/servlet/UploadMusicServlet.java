package servlet;

import entity.Music;
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
import java.util.List;

@WebServlet("/UploadMusicServlet")
public class UploadMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setHeaderEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        try {
            List<FileItem> files = upload.parseRequest(request);
            String path = request.getSession().getServletContext().getRealPath("/");


            for (FileItem item: files){

                //存音乐到服务器
                String fileName = path+"music/"+item.getName();

                InputStream in = item.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;

                OutputStream outputStream = new FileOutputStream(fileName);

                while ((len = in.read(buffer)) != -1){
                    outputStream.write(buffer,0,len);
                }

                out.close();
                in.close();


                //获取音乐信息并写入数据库
                File file = new File(fileName);
                String singer = Mp3Util.getSinger(file);
                String songName = Mp3Util.getSongName(file);
                String albumName = Mp3Util.getAlbum(file);

                Mp3Util.uploadPic(file,path+"pic/"+songName+".jpg",true);

                file.renameTo(new File(path+"music/"+songName+".mp3"));


            }


            out.write("true");


        }catch (FileUploadException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
