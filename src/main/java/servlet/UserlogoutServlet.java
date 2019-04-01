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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserlogoutServlet")
public class UserlogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String userId = request.getParameter("userId");
        User user = ServiceFactory.getUserService().findUserById(userId);
        if(ServiceFactory.getUserService().logoutUser(user)==true)
        {

            out.write("logout_success");
        }
        else  {out.write("logout_nothing_or_failt");  }






        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
