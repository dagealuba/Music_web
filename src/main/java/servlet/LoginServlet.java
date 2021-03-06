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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");

        PrintWriter out = response.getWriter();

        User user = ServiceFactory.getUserService().findUserByEmail(userEmail);

        if (user != null) {
            if (user.getUserPassword().equals(userPassword)){
                out.write(user.getUserId());
            }
            else {
                out.write("password_wrong");
            }
        }
        else out.write("email_wrong");

        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
