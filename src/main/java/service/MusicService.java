package service;

import entity.Music;

import java.util.List;

public interface MusicService {
    public boolean deleteMusic(Music music);

    public Music findMusicByNameAndSinger(String musicname,String singer);
}
