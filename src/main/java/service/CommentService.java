package service;

import entity.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 查看评论
     * @return List<Comment>
     */
    public List<Comment> AllComment();

    /**
     * 通过musicId查看评论
     * @return List<Comment>
     */
    public List<Comment> getCommentByMusicId(String musicId);

    /**
     * 通过commentId查看评论
     * @return Comment
     */
    public Comment getCommentByCommentId(String commentId);

    /**
     * 评论歌曲
     * @return boolean
     */
    public boolean newComment(Comment comments);

    /**
     * 通过musicId删除评论
     * @return boolean
     */
    public boolean DeleteCommentByMusicId(String musicId);

    /**
     * 通过commentId删除评论
     * @return boolean
     */
    public boolean DeleteCommentByCommentId(String commentId);

    /**
     * 更新
     * @return boolean
     */
    public boolean updateComment(Comment comments);
}
