package entity;

import factory.DaoFactory;

public class Music_a {
    private String musicId;
    private String musicName;
    private String singer;
    private String album;
    private String lyricSrc;
    private String musicSrc;
    private String picSrc;

    public Music_a(Music music){
        musicId = music.getMusicId();
        musicName = music.getMusicName();
        singer = music.getSinger();
        lyricSrc = music.getLyricSrc();
        musicSrc = music.getMusicSrc();
        picSrc = music.getPicSrc();

        if (DaoFactory.getAlbumDaoImpl().getAlbumById(music.getAlbumId())!= null){
            album = DaoFactory.getAlbumDaoImpl().getAlbumById(music.getAlbumId()).getAlbumName();
        }
        else album = null;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLyricSrc() {
        return lyricSrc;
    }

    public void setLyricSrc(String lyricSrc) {
        this.lyricSrc = lyricSrc;
    }

    public String getMusicSrc() {
        return musicSrc;
    }

    public void setMusicSrc(String musicSrc) {
        this.musicSrc = musicSrc;
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
    }
}
