package servlet;

import entity.Love;
import entity.User;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String userId = UUID.randomUUID().toString();
        String loveId = UUID.randomUUID().toString();
        String avatarSrc = "http://47.107.238.107/Music/avatar/default.jpg";
        int type = 1;


        Love love = new Love();
        love.setLoveId(loveId);
        love.setLoveName("默认收藏夹");
        love.setMusicId(null);
        love.setUserId(userId);
        ServiceFactory.getLoveServiceImpl().addLove(love);

        User user = new User(userId,userName,userPassword,userEmail,avatarSrc,type);

        PrintWriter out = response.getWriter();
        if (ServiceFactory.getUserService().findUserByEmail(userEmail) != null){
            out.write("email_wrong");
        }
        else if (ServiceFactory.getUserService().insert(user)){
            out.write(userId);
        }
        else out.write("false");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
