package entity;

public class LikeComment {
    private String userId;
    private String commentId;
    private int likestatus;

    public LikeComment(String userId, String commentId, int likestatus) {
        this.userId = userId;
        this.commentId = commentId;
        this.likestatus = likestatus;
    }

    public LikeComment() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public int getLikestatus() {
        return likestatus;
    }

    public void setLikestatus(int likestatus) {
        this.likestatus = likestatus;
    }
}
