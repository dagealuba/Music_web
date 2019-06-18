package dao;

import entity.PlayList;

import java.util.List;

public interface PlayListDao {
    public List<PlayList> getPlayList(String userId);

    public boolean add(PlayList playList);

    public boolean update(PlayList playList);

    public boolean delete(PlayList playList);
}
