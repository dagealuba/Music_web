package daoImpl;

import dao.BaseDao;
import dao.CommentDao;
import entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                comment.setCommentId(resultSet.getString("commentId"));
                comment.setCommentTime(resultSet.getTimestamp("commentTime"));
                comment.setLikeNumber(resultSet.getInt("likeNumber"));
                comment.setMusicId(resultSet.getString("musicId"));
                comment.setCommentToComment(resultSet.getString("commentToComment"));
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
        Comment comment=new Comment();
        try{
            while(resultSet.next())
            {
                comment.setMusicId(musicId);
                comment.setComment(resultSet.getString("comment"));
                comment.setCommentId(resultSet.getString("commentId"));
                comment.setCommentToComment(resultSet.getString("commentToComment"));
                comment.setLikeNumber(resultSet.getInt("likeNumber"));
                comment.setCommentTime(resultSet.getTimestamp("commentTime"));
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
        String sql="select * from comment where commentId=?";
        Object[] params={commentId};

        resultSet=this.ExecuteQuery(sql,params);
        Comment comment=new Comment();
        try{
            while(resultSet.next()) {
                comment.setCommentId(commentId);
                comment.setComment(resultSet.getString("comment"));
                comment.setMusicId(resultSet.getString("musicId"));
                comment.setCommentToComment(resultSet.getString("commentToComment"));
                comment.setCommentTime(resultSet.getTimestamp("commentTime"));
                comment.setLikeNumber(resultSet.getInt("likeNumber"));
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
        String sql="delete * from comment where commentId=?";
        Object[] params={commentId};
        return this.executeUpdate(sql,params) > 0;

    }

    @Override
    public boolean InsertComment(Comment comments) {
        String sql="insert into comment(commentId,musicId,comment) values(?,?,?)";
        String commentId=comments.getCommentId();
        String musicId=comments.getMusicId();
        String comment=comments.getComment();

        Object[] params={commentId,musicId,comment};
        return this.executeUpdate(sql,params)>0;
    }

    @Override
    public boolean updateComment(Comment comments) {
        String sql = "update comment set comment = ?,time = now() where commentId = ?";
        String commentId=comments.getCommentId();
        String comment=comments.getComment();

        Object[] params={commentId,comment};
        return this.executeUpdate(sql,params)>0;

    }

}
