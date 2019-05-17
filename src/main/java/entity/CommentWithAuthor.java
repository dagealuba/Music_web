package entity;

import factory.DaoFactory;

public class CommentWithAuthor{
    private User author;
    private Comment comment;

    public CommentWithAuthor(Comment comment) {
        this.comment = comment;
        this.author = DaoFactory.getUserDaoImpl().getUserById(comment.getUserId());
        this.author.setUserPassword("");
    }

    public User getUser() {
        return author;
    }

    public void setUser(User user) {
        this.author = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
