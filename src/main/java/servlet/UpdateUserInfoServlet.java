package servlet;

import entity.User;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("userId");




        User user = ServiceFactory.getUserService().findUserById(userId);

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userEmail = request.getParameter("userEmail");
        String avatarSrc = user.getAvatarSrc();
        User newuser = new User(userId,userName,userPassword,userEmail,avatarSrc);
        if(ServiceFactory.getUserService().updateUserInfo(user)==true)
        {

            out.write("update_success");
        }
        else  {out.write("update_failt");  }
        out.flush();
        out.close();




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
