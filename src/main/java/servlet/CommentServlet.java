package servlet;

import com.alibaba.fastjson.JSON;
import entity.Comment;
import factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CommentServlet")
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
        String commentId=request.getParameter("commentId");
        Comment comments=new Comment();
        comments.setCommentId(commentId);

        PrintWriter out=response.getWriter();
        if(ServiceFactory.getCommentServiceImpl().DeleteCommentByCommentId(commentId))
            out.write("true");
        else
            out.write("false");
    }
}
