package dao;

import entity.Love;

import java.util.List;

public interface LoveDao{
    /**
     * 获取用户收藏夹的名字
     * @param userId
     * @return
     */
    public List<String> getUesrLoveName(String userId);

    /**
     * @param userId
     * @return userLoveList
     */
    public List<Love> getUserLove(String userId);

    /**
     * @param love
     * @return
     */
    public boolean addLove(Love love);

    /**
     * 删除一首收藏的歌曲
     * @param loveId
     * @return
     */
    public boolean deleteLove(String loveId);

    /**
     * 删除一个收藏夹
     * @param userId
     * @param loveName
     * @return
     */
    public boolean deleteUerLove(String userId, String loveName);


    public boolean updateLove(String loveId);
}
