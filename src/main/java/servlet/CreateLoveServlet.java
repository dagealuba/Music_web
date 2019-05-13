package servlet;

import entity.Love;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "CreateLoveServlet")
public class CreateLoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");
        String loveName = request.getParameter("loveName");
        boolean flag = false;
        PrintWriter out = response.getWriter();

        List<Love> loves = ServiceFactory.getLoveService().findLovesByUserId(userId);
        for (Love l : loves) {
            if (l.getLoveName().equals(loveName)) {
                out.write("love exists");
                flag = true;
                break;
            }
        }
        if (!flag) {
            Love love = new Love(UUID.randomUUID().toString(), loveName, userId, null);
            if (ServiceFactory.getLoveService().addlove(love)) {
                out.write("creation successful");
            } else {
                out.write("creation failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
