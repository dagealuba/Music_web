package daoImpl;

import dao.BaseDao;
import dao.LikeCommentDao;
import entity.LikeComment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeCommentDaoImpl extends BaseDao implements LikeCommentDao {
    public ResultSet resultSet=null;

    @Override
    public int getLikeNum(String commentId) {
        String sql = "select count(*) from likecomment where commentid=?";
        Object[] params = {commentId};

        int likeNum = 0;
        resultSet = this.ExecuteQuery(sql,params);
        try {
            while (resultSet.next()){
                likeNum = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return likeNum;
    }

    @Override
    public boolean addLikeComment(String commentId, String userId) {
        String sql = "insert into likecomment(userid,commentid) values (?,?)";
        Object[] params = {userId,commentId};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean deleteLikeComment(String commentId, String userId) {
        String sql = "delete from likecomment where commentid=? and userid=?";
        Object[] params = {commentId,userId};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public LikeComment getLikeComment(String commentId, String userId) {
        String sql = "select * from likecomment where commentid=? and userid=?";
        Object[] params = {commentId,userId};

        LikeComment likeComment = null;
        resultSet = this.ExecuteQuery(sql, params);
        try{
            while (resultSet.next()){
                likeComment = new LikeComment();
                likeComment.setCommentId(commentId);
                likeComment.setUserId(userId);
                likeComment.setLikestatus(resultSet.getInt("likestatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likeComment;
    }
}
