package dao;

import entity.History;

import java.util.List;

public interface HistoryDao {
    /**
     * 获取用户的播放历史
     * @param userId
     * @return
     */
    public List<History> getHistoryByUser(String userId);

    /**
     * 获取用户最后播放的歌曲
     * @param userId
     * @return
     */
    public History getUserLatestHistory(String userId);


    public int getNumOfMusic(String musicId);

    /**
     * 添加播放历史
     * @param history
     * @return
     */
    public boolean insertHistory(History history);


    /**
     * 删除历史
     * @param historyId
     * @return
     */
    public boolean deleteHistory(String historyId);

}
