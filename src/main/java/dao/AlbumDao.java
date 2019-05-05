package dao;

import entity.Album;

import java.util.List;

public interface AlbumDao {

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

    public Album getAlbumById(String albumId);

    /**
     * @param album
     * @return
     */
    public boolean addAlbum(Album album);

    /**
     * @param album
     * @return
     */
    public boolean updateAlbum(Album album);

    /**
     * @param album
     * @return
     */
    public boolean deleteAlbum(Album album);
}
