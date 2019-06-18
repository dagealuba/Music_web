package util;

import java.util.List;

public class Album_m {
    private String albumId;
    private String albumName;
    private String singer;
    private List<Music_a> musics;

    public Album_m(String albumId, String albumName, String singer, List<Music_a> musics) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.singer = singer;
        this.musics = musics;
    }

    public List<Music_a> getMusics() {
        return musics;
    }

    public void setMusics(List<Music_a> musics) {
        this.musics = musics;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
}
