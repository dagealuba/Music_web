package service;

import entity.Album;

import java.util.List;

public interface AlbumService {
    /**
     * @param albumName
     * @return
     */
    public List<Album> getAlbumsByName(String albumName);

    /**
     * @param singer
     * @return
     */
    public List<Album> getAlbumsBySinger(String singer);


    /**
     * @param album
     * @return
     */
    public boolean addAlbum(Album album);
}
