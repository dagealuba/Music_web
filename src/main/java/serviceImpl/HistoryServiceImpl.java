package serviceImpl;

import entity.History;
import factory.DaoFactory;
import service.HistoryService;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    @Override
    public History getUserLatestHistory(String userId) {
        return DaoFactory.getHistoryDaoImpl().getUserLatestHistory(userId);
    }

    @Override
    public List<History> getUserHistory(String userId) {
        return DaoFactory.getHistoryDaoImpl().getHistoryByUser(userId);
    }

    @Override
    public boolean addHistory(History history) {
        return DaoFactory.getHistoryDaoImpl().insertHistory(history);
    }

    @Override
    public boolean deleteHistory(String historyId) {
        return DaoFactory.getHistoryDaoImpl().deleteHistory(historyId);
    }
}
