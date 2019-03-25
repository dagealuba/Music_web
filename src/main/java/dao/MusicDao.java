package dao;

import entity.Music;

import java.util.List;

public interface MusicDao {
    public List<Music> getAllMusic();

    public Music getMusicById(String musicid);

    public List<Music> getMusicByName(String musicname);

    public List<Music> getMusicBysinger(String singer);

    public boolean addMusic(Music music);

    public boolean deleteMusic(Music music);

    public boolean updateMusic(Music music);
}
