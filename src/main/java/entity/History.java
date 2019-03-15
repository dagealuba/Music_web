package entity;

public class History {
    private String historyId;
    private String userId;
    private String musicId;

    public History(String historyId, String userId, String musicId) {
        this.historyId = historyId;
        this.userId = userId;
        this.musicId = musicId;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
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
