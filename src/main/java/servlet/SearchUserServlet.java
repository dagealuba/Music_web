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

@WebServlet(name = "SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String userName = request.getParameter("userName");


        PrintWriter out = response.getWriter();

        List<User> users= ServiceFactory.getUserService().findUserByName(userName);

        if (users != null)
        { out.write("search_success");        }
        else  {out.write("search_nothing_or_failt");  }



        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
