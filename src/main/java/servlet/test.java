package servlet;

import daoImpl.UserDaoImpl;
import entity.User;
import util.Mp3Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/test")
public class test extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getSession().getServletContext().getRealPath("/");
        File mp3 = new File(path+"music/青木カレン ハセガワダイスケ - Great Days.mp3");

        if ( Mp3Util.getType(mp3) != null ){
            System.out.println(Mp3Util.getType(mp3));
        }
        else System.out.println("nmsl");
    }
}
