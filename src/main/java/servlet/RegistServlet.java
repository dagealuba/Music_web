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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    private  static final long serialVersionUID=1L;

    public RegistServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("charset=UTF-8");

        String userName=request.getParameter("userName");
        String userPassword=request.getParameter("userPassword");
        String userEmail=request.getParameter("userEmail");
        String userId=request.getParameter("userId");
        String avatarSrc=request.getParameter("avatarSrc");
        System.out.println("注册：");
        User user = new User(userId,userName,userPassword,userEmail,avatarSrc);
        List<User> users=new ArrayList<>();
        users.add(user);
        PrintWriter out=response.getWriter();
        if(ServiceFactory.getUserService().findUserById(userId)==null){
            System.out.println("无重复用户id");
            if(ServiceFactory.getUserService().insert(users)){
                System.out.println("注册成功");
                request.getSession().setAttribute("user",user);
                out.write("true");
            }
            else out.write("false");
        }
        else out.write("id-error");
        out.flush();
        out.close();
    }
}
