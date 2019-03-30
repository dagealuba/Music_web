package service;


import entity.Album;

import java.util.List;

public interface SearchService {
    /**
     * 根据歌手姓名查询歌曲，返回的是歌曲在服务器上的地址
     * @param singer
     * @return String MusicSrc
     */
    public String FindSinger(String singer);

    /**
     * 根据歌曲的歌曲名查询歌曲，返回的是歌曲在服务器上的地址
     * @param musicName
     * @return String musicSrc
     */
    public String FindMusicName(String musicName);

    /**
     * 根据专辑名查询专辑，返回的是一个专辑列表
     * @param albumName
     * @return List<Album>
     */
    public List<Album> FindAlbumName(String albumName);

}
