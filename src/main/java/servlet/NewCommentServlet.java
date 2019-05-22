package servlet;

import entity.Comment;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/NewCommentServlet")
public class NewCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String commentId = UUID.randomUUID().toString();
        String commentToComment = request.getParameter("commentToComment");
        String userId = request.getParameter("userId");
        String musicId=request.getParameter("musicId");
        String comment=request.getParameter("comment");//评论的内容

        System.out.println(musicId);

        Comment comments = new Comment();
        comments.setCommentId(commentId);
        comments.setMusicId(musicId);
        comments.setComment(comment);
        comments.setCommentToComment(commentToComment);
        comments.setUserId(userId);

        PrintWriter out = response.getWriter();
        if (ServiceFactory.getCommentServiceImpl().newComment(comments)){
            out.write("true");
        }
        else {
            out.write("false");
        }
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
