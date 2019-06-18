package util;

import java.util.List;

public class LoveList {
    private String loveName;
    private List<Music_a> musics;

    public LoveList(String loveName, List<Music_a> musics) {
        this.loveName = loveName;
        this.musics = musics;
    }

    public String getLoveName() {
        return loveName;
    }

    public void setLoveName(String loveName) {
        this.loveName = loveName;
    }

    public List<Music_a> getMusics() {
        return musics;
    }

    public void setMusics(List<Music_a> musics) {
        this.musics = musics;
    }
}
