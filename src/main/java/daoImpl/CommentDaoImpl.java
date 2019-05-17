package daoImpl;

import dao.BaseDao;
import dao.CommentDao;
import entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDaoImpl extends BaseDao implements CommentDao {
    public ResultSet resultSet=null;
    public Connection connection=null;
    public PreparedStatement preparedStatement=null;

    @Override
    public List<Comment> getAllComment() {
        List<Comment> comments=new ArrayList<Comment>();
        String sql="select * from comment";
        Object[] params={};
        resultSet=this.ExecuteQuery(sql,params);
        Comment  comment=new Comment();
        try{
            while (resultSet.next())
            {
                comment.setComment(resultSet.getString("comment"));
                comment.setCommentId(resultSet.getString("commentid"));
                comment.setCommentTime(resultSet.getTimestamp("commenttime"));
                comment.setLikeNumber(resultSet.getInt("likenumber"));
                comment.setMusicId(resultSet.getString("musicid"));
                comment.setCommentToComment(resultSet.getString("commenttocomment"));
                comment.setUserId(resultSet.getString("userid"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return comments;
    }

    @Override
    public List<Comment> CommentByMusicId(String musicId) {
        List<Comment> comments=new ArrayList<Comment>();
        String sql="select * from comment where musicId=?";
        Object[] params={musicId};
        resultSet=this.ExecuteQuery(sql,params);
        try{
            while(resultSet.next())
            {
                Comment comment=new Comment();
                comment.setMusicId(musicId);
                comment.setComment(resultSet.getString("comment"));
                comment.setCommentId(resultSet.getString("commentid"));
                comment.setCommentToComment(resultSet.getString("commenttocomment"));
                comment.setLikeNumber(resultSet.getInt("likenumber"));
                comment.setCommentTime(resultSet.getTimestamp("commenttime"));
                comment.setUserId(resultSet.getString("userid"));
                comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.closeResource();
        }
        return comments;
    }

    @Override
    public Comment CommentByCommentId(String commentId) {
        String sql="select * from comment where commentid=?";
        Object[] params={commentId};

        resultSet=this.ExecuteQuery(sql,params);
        Comment comment=new Comment();
        try{
            while(resultSet.next()) {
                comment.setCommentId(commentId);
                comment.setComment(resultSet.getString("comment"));
                comment.setMusicId(resultSet.getString("musicid"));
                comment.setCommentToComment(resultSet.getString("commenttocomment"));
                comment.setCommentTime(resultSet.getTimestamp("commenttime"));
                comment.setLikeNumber(resultSet.getInt("likenumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.closeResource();
        }
        return comment;
    }

    @Override
    public boolean DeleteCommentByMusicId(String musicId) {
        String sql="delete * from comment where musicId=?";
        Object[] params={musicId};
        return this.executeUpdate(sql,params) > 0;

    }

    @Override
    public boolean DeleteCommentByCommentId(String commentId) {
        String sql="delete * from comment where commentid=?";
        Object[] params={commentId};
        return this.executeUpdate(sql,params) > 0;

    }

    @Override
    public boolean InsertComment(Comment comments) {
        String sql="insert into comment(commentid,musicid,comment,commenttime,commenttocomment,userid) values(?,?,?,now(),?,?)";
        String commentId=comments.getCommentId();
        String musicId=comments.getMusicId();
        String comment=comments.getComment();

        Object[] params={commentId,musicId,comment,comments.getCommentToComment(),comments.getUserId()};
        return this.executeUpdate(sql,params)>0;
    }

    @Override
    public boolean updateComment(Comment comments) {
        String sql = "update comment set comment = ?,time = now() where commentid = ?";
        String commentId=comments.getCommentId();
        String comment=comments.getComment();

        Object[] params={commentId,comment};
        return this.executeUpdate(sql,params)>0;

    }

}
