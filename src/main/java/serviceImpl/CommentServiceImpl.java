package serviceImpl;

import entity.Comment;
import factory.DaoFactory;
import service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Override
    public List<Comment> AllComment() {
        return DaoFactory.getCommentDaoImpl().getAllComment();
    }

    @Override
    public List<Comment> getCommentByMusicId(String musicId) {
        return DaoFactory.getCommentDaoImpl().CommentByMusicId(musicId);
    }

    @Override
    public Comment getCommentByCommentId(String commentId) {
        return DaoFactory.getCommentDaoImpl().CommentByCommentId(commentId);
    }

    @Override
    public boolean newComment(Comment comments) {
        return DaoFactory.getCommentDaoImpl().InsertComment(comments);
    }

    @Override
    public boolean DeleteCommentByMusicId(String musicId) {
        return DaoFactory.getCommentDaoImpl().DeleteCommentByMusicId(musicId);
    }

    @Override
    public boolean DeleteCommentByCommentId(String commentId) {
        return DaoFactory.getCommentDaoImpl().DeleteCommentByCommentId(commentId);
    }

    @Override
    public boolean updateComment(Comment comments) {
        return DaoFactory.getCommentDaoImpl().updateComment(comments);
    }

    @Override
    public boolean likeComment(String userId, String commentId) {
        return DaoFactory.getLikeCommentDaoImpl().addLikeComment(commentId,userId);
    }

    @Override
    public boolean disLikeComment(String userId, String commentId) {
        return DaoFactory.getLikeCommentDaoImpl().deleteLikeComment(commentId,userId);
    }

    @Override
    public int likeNum(String commentId) {
        return DaoFactory.getLikeCommentDaoImpl().getLikeNum(commentId);
    }

    @Override
    public boolean checkLiked(String commentId, String userId) {
        return DaoFactory.getLikeCommentDaoImpl().getLikeComment(commentId,userId) != null;
    }
}
