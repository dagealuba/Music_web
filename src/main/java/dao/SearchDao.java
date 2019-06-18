package dao;


import entity.Album;
import entity.Music;

import java.util.List;

public interface SearchDao {
    /**
     * 搜索歌曲演唱者
     * @return String musicSrc
     */
    public List<Music> SearchSinger(String signer);

    /**
     * 搜索歌曲名字
     * @return String musicSrc
     */
    public List<Music> SearchMusicName(String musicName);

    /**
     * 搜索音乐专辑
     * @return List<Album>
     */

    public List<Album> SearchAlbum(String albumName);


    /**
     * @param musicId
     * @return music
     */
    public Music SearchMusicId(String musicId);

}
