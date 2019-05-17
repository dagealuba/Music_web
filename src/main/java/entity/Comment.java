package entity;

import java.sql.Timestamp;

public class Comment {
    private String commentId;
    private String musicId;
    private String comment;
    private String commentToComment;
    private int likeNumber;
    private Timestamp commentTime;
    private String userId;

    public Comment(String commentId, String musicId, String comment, String commentToComment, int likeNumber, Timestamp commentTime, String userId) {
        this.commentId = commentId;
        this.musicId = musicId;
        this.comment = comment;
        this.commentToComment = commentToComment;
        this.likeNumber = likeNumber;
        this.commentTime = commentTime;
        this.userId = userId;
    }

    public Comment()
    {

    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentToComment() {
        return commentToComment;
    }

    public void setCommentToComment(String commentToComment) {
        this.commentToComment = commentToComment;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
