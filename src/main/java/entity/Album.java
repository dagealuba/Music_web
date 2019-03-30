package entity;

public class Album {
    private String albumId;
    private String albumName;
    private String singer;

    Album(String id,String name,String singer){
        this.singer = singer;
        albumId = id;
        albumName = name;
    }

    public Album(){

    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
