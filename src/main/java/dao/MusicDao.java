package dao;

import entity.Music;

import java.util.List;

public interface MusicDao {

    /**
     * @param str
     * @return List<Music>
     */
    public List<Music> getMusics(String str);


    /**
     * @param songName
     * @return List<Music>
     */
    public List<Music> getMusicsBySongName(String songName);

    /**
     * @param music
     * @return true or false
     */
    public boolean addMusic(Music music);


    /**
     * @param music
     * @return true or false
     */
    public boolean updateMusic(Music music);


    /**
     * @param music
     * @return true or false
     */
    public boolean deleteMusic(Music music);

    public Music getMusicById(String musicid);

}
