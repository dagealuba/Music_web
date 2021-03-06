package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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

@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");

        List<User> users = ServiceFactory.getUserService().findUserByName(userName);

        PrintWriter out = response.getWriter();

        out.write(JSONArray.toJSONString(users));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");

        User user = ServiceFactory.getUserService().findUserById(userId);

        user.setUserPassword("");
        PrintWriter out = response.getWriter();

        String user_json = JSON.toJSONString(user);

        out.write(user_json);
        out.flush();
        out.close();
    }
}
