package service;

import entity.Music;

import java.util.List;

public interface MusicService {
    public boolean deleteMusic(Music music);

    public Music findMusicByNameAndSinger(String musicname,String singer);

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


    /**
     * 功能描述:
     * @param:
     * @return:
     */
    public boolean updateMusic(Music music);
}
