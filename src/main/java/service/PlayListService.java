package service;

import entity.PlayList;
import util.Music_a;

import java.util.List;

public interface PlayListService {
    public List<PlayList> getPlayList(String userId);

    public List<Music_a> getUserPlayList(String userId);

    public boolean add(String userId, String musicId);

    public boolean delete(String userId, String musicId);
}
