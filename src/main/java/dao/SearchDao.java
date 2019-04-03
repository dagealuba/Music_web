package dao;


import entity.Album;

import java.util.List;

public interface SearchDao {
    /**
     * 搜索歌曲演唱者
     * @return String musicSrc
     */
    public String SearchSinger(String singer);

    /**
     * 搜索歌曲名字
     * @return String musicSrc
     */
    public String SearchMusicName(String musicName);

    /**
     * 搜索音乐专辑
     * @return List<Album>
     */

    public List<Album> SearchAlbum(String albumName);


}
