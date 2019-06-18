package service;

import entity.History;
import util.Music_a;

import java.util.List;
import java.util.Map;

public interface HistoryService {
    /**
     * @param userId
     * @return
     */
    public History getUserLatestHistory(String userId);

    /**
     * @param userId
     * @return
     */
    public List<History> getUserHistory(String userId);

    public Map<String, Integer> getHotMusic();

    /**
     * @param history
     * @return
     */
    public boolean addHistory(History history);

    /**
     * @param historyId
     * @return
     */
    public boolean deleteHistory(String historyId);

}
