package entity;

public class Music {
    private String musicId;
    private String musicName;
    private String singer;
    private String albumId;
    private String lyricSrc;
    private String musicSrc;
    private String picSrc;

    public Music(String id, String name, String singer, String albumid, String lyricsrc, String musicsrc, String picsrc){
        musicId = id;
        musicName = name;
        this.singer = singer;
        albumId = albumid;
        lyricSrc = lyricsrc;
        musicSrc = musicsrc;
        picSrc = picsrc;
    }

    /**
     *  还有需要的构造函数自己加
     */

    public Music() {

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

    public String getLyricSrc() {
        return lyricSrc;
    }

    public void setLyricSrc(String lyricSrc) {
        this.lyricSrc = lyricSrc;
    }

    public String getMusicSrc(String musicSrc) {
        return this.musicSrc;
    }

    public String getMusicSrc() {return musicSrc;}

    public void setMusicSrc(String musicSrc) {
        this.musicSrc = musicSrc;
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
}
