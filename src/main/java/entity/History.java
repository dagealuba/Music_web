package entity;

import java.sql.Timestamp;

public class History {
    private String historyId;
    private String userId;
    private String musicId;
    private Timestamp time;

    public History(String historyId, String userId, String musicId, Timestamp time) {
        this.historyId = historyId;
        this.userId = userId;
        this.musicId = musicId;
        this.time = time;
    }

    public History(String historyId, String userId, String musicId){
        this.historyId = historyId;
        this.userId = userId;
        this.musicId = musicId;
    }

    public History() {

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
