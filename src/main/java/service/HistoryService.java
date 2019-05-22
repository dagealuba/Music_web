package service;

import entity.History;

import java.util.List;

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
