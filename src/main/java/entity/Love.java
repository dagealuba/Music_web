package entity;

public class Love {
    private String loveId;
    private String loveName;
    private String userId;
    private String musicId;

    public Love(String loveId, String loveName, String userId, String musicId) {
        this.loveId = loveId;
        this.loveName = loveName;
        this.userId = userId;
        this.musicId = musicId;
    }

    public String getLoveId() {
        return loveId;
    }

    public void setLoveId(String loveId) {
        this.loveId = loveId;
    }

    public String getLoveName() {
        return loveName;
    }

    public void setLoveName(String loveName) {
        this.loveName = loveName;
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
}
