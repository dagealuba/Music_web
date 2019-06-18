package servlet;

import com.alibaba.fastjson.JSONArray;
import factory.ServiceFactory;
import util.LoveList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetUserLoveServlet")
public class GetUserLoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");

        PrintWriter out = response.getWriter();

        List<LoveList> loves = ServiceFactory.getLoveServiceImpl().getUserLove(userId);

        out.write(JSONArray.toJSONString(loves));
    }
}
