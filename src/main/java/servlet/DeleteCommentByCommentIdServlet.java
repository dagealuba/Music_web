package servlet;

import entity.Comment;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteCommentByCommentIdServlet")
public class DeleteCommentByCommentIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String commentId=request.getParameter("commentId");
        String musicId=request.getParameter("musicId");
        String comment=request.getParameter("comment");//评论的内容

        Comment comments = new Comment();
        comments.setCommentId(commentId);
        comments.setMusicId(musicId);
        comments.setComment(comment);

        PrintWriter out = response.getWriter();
        if (ServiceFactory.getCommentServiceImpl().DeleteCommentByCommentId(commentId)){
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
