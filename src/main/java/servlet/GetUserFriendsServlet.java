package servlet;

import com.alibaba.fastjson.JSONArray;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetUserFriendsServlet")
public class GetUserFriendsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");

        PrintWriter out = response.getWriter();

        out.write(JSONArray.toJSONString(ServiceFactory.getFriendServiceImpl().getFriends(userId)));
    }
}
