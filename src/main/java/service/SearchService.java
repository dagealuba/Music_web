package service;


import entity.Album;
import util.Album_m;
import util.Music_a;

import java.util.List;

public interface SearchService {
    /**
     * 根据歌手姓名查询歌曲，返回的是歌曲在服务器上的地址
     * @param singer
     * @return String MusicSrc
     */
    public List<Music_a> FindSinger(String singer);

    /**
     * 根据歌曲的歌曲名查询歌曲，返回的是歌曲在服务器上的地址
     * @param musicName
     * @return String musicSrc
     */
    public List<Music_a> FindMusicName(String musicName);

    /**
     * 根据专辑名查询专辑，返回的是一个专辑列表
     * @param albumName
     * @return List<Album>
     */
    public List<Album> FindAlbumName(String albumName);

    /**
     * @param musicId
     * @return music
     */
    public Music_a FindMusicById(String musicId);

    public List<Album_m> FindMusicByAlbum(String albumName);



}
