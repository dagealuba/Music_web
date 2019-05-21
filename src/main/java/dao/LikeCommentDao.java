package dao;

import entity.LikeComment;

public interface LikeCommentDao {
    /**
     * @param commentId
     * @return likeNumber
     */
    public int getLikeNum(String commentId);

    /**
     * @param commentId
     * @param userId
     * @return boolean
     */
    public boolean addLikeComment(String commentId,String userId);

    /**
     * @param commentId
     * @param userId
     * @return
     */
    public boolean deleteLikeComment(String commentId,String userId);

    /**
     * @param commentId
     * @param userId
     * @return
     */
    public LikeComment getLikeComment(String commentId, String userId);
}
