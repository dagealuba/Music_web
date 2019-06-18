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

@WebServlet("/CheckFriendServlet")
public class CheckFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");
        String friendId = request.getParameter("friendId");

        PrintWriter out = response.getWriter();

        List<User> users = ServiceFactory.getFriendServiceImpl().getFriends(userId);

        String flag = "false";
        for (User user:users){
            if (user.getUserId().equals(friendId)){
                flag="true";
                break;
            }
        }

        out.write(flag);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
