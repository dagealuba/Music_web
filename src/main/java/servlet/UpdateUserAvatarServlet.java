package servlet;

import factory.DaoFactory;
import factory.ServiceFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/UpdateUserAvatarServlet")
public class UpdateUserAvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setHeaderEncoding("UTF-8");

        try {
            List<FileItem> files = upload.parseRequest(request);

            String path = request.getSession().getServletContext().getRealPath("/");
            String host = "http://47.107.238.107/Music/";
            String userId = "";
            PrintWriter outWrite = response.getWriter();

            String flag = "false";
            for (FileItem item:files){
                if (item.isFormField()){
                    userId = item.getString("UTF-8");
                }
            }

            for (FileItem item: files){
                if (item.isFormField()){
                    continue;
                }
                else {
                    String fileName = item.getName();

                    String type = item.getContentType();

                    if (type.equals("image/jpeg")) {
                        fileName = path + "avatar/" + userId + ".jpg";
                    }
                    else fileName = path + "avatar/" + userId + ".png";
                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;

                    OutputStream out = new FileOutputStream(fileName);

                    while ((len = in.read(buffer)) != -1){
                        out.write(buffer,0,len);
                    }

                    out.close();
                    in.close();

                    if (type.equals("image/jpeg")) {
                        fileName = host + "avatar/" + userId + ".jpg";
                    }
                    else fileName = host + "avatar/" + userId + ".png";
                    if ( ServiceFactory.getUserService().updateUserAvatar(fileName,userId) ) {
                        flag = "true";
                    }
                }
            }

            outWrite.write(flag);
            outWrite.flush();
            outWrite.close();

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
