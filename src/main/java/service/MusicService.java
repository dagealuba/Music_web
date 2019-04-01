package service;

import entity.Music;
import factory.ServiceFactory;

import java.util.List;

public interface MusicService {
    /**
     * @param music
     * @return true or false
     */
    public boolean addMusic(Music music);

    /**
     * @param musicName
     * @return List<Music>
     */
    public List<Music> getMusicsByName(String musicName);

    /**
     * 查找是否已有有同名歌
     * @param music
     * @return
     */
    public boolean checkMusicName(Music music);
}
