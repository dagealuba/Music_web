package servlet;

import com.alibaba.fastjson.JSON;
import entity.Comment;
import entity.CommentWithAuthor;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String commentId=request.getParameter("commentId");
        String comment=request.getParameter("comment");//评论的内容

        Comment comments=new Comment();
        comments.setCommentId(commentId);
        comments.setComment(comment);

        PrintWriter out=response.getWriter();
        Map res=new HashMap();

        if(ServiceFactory.getCommentServiceImpl().updateComment(comments)){
            res.put("falg","true");
            String musicId=ServiceFactory.getCommentServiceImpl().getCommentByCommentId(commentId).getMusicId();
            res.put("musicId",musicId);
        }
        else{
            res.put("flag","false");
        }
        String resJson= JSON.toJSONString(res);
        out.write(resJson);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String musicId=request.getParameter("musicId");
        List<Comment> comments = new ArrayList<Comment>();
        comments = ServiceFactory.getCommentServiceImpl().getCommentByMusicId(musicId);

        List<CommentWithAuthor> commentWithAuthors = new ArrayList<CommentWithAuthor>();
        for (Comment comment:comments){
            comment.setLikeNumber(ServiceFactory.getCommentServiceImpl().likeNum(comment.getCommentId()));
            commentWithAuthors.add(new CommentWithAuthor(comment));
        }
//        System.out.println(JSON.toJSONString(commentWithAuthors));
        PrintWriter out=response.getWriter();
        out.write(JSON.toJSONString(commentWithAuthors));
    }
}
