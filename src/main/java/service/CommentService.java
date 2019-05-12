package service;

import entity.Comment;

import java.util.List;

public interface CommentService {
    //查看所有的评论
    public List<Comment> AllComment();
    //通过音乐id 查询评论
    public List<Comment> getCommentByMusicId(String musicId);
    //通过评论的id查询评论
    public Comment getCommentByCommentId(String commentId);
    //插入评论
    public boolean InserComment(Comment comments);
    //通过音乐Id删除评论
    public boolean DeleteCommentByMusicId(String musicId);
    //通过评论Id删除评论
    public boolean DeleteCommentByCommentId(String commentId);

    public boolean updateComment(Comment comments);
}
