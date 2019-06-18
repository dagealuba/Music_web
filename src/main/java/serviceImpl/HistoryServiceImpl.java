package serviceImpl;

import entity.History;
import entity.Music;
import factory.DaoFactory;
import service.HistoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Integer> getHotMusic() {
        List<Music> musicList = DaoFactory.getMusicDaoImpl().getMusics();

        Map<String, Integer> hot = new HashMap<>();
        for (Music music:musicList){
            hot.put(music.getMusicId(),DaoFactory.getHistoryDaoImpl().getNumOfMusic(music.getMusicId()));
        }

        return hot;
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
