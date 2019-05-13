package dao;

import entity.Comment;

import java.util.List;

public interface CommentDao {
    /**
     * 查看歌曲评论
     * @return List<Comment>()
     */
    public List<Comment> getAllComment();

    /**
     * 通过音乐Id评论歌曲
     * @return  List<Comment>
     */
    public List<Comment> CommentByMusicId(String musicId);

    /**
     * 根据评论Id回复评论
     * @return List<Comment>
     */
    public Comment CommentByCommentId(String commentId);

    /**
     * 根据音乐Id删除评论
     * @return boolean
     */
    public boolean DeleteCommentByMusicId(String musicId);

    /**
     * 根据评论Id删除评论
     * @return boolean
     */
    public boolean DeleteCommentByCommentId(String commmentId);

    /**
     * 在音乐中插入评论
     * @return boolean
     */
    public boolean InsertComment(Comment comments);

    /**
     * 更新
     * @return boolean
     */
    public boolean updateComment(Comment comments);


}
