package entity;

public class PlayList {
    private String userId;
    private String musicId;
    private int num;

    public PlayList(String userId, String musicId, int num) {
        this.userId = userId;
        this.musicId = musicId;
        this.num = num;
    }

    public PlayList(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
