package daoImpl;

import dao.AlbumDao;
import dao.BaseDao;
import entity.Album;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDaoImpl extends BaseDao implements AlbumDao {
    private ResultSet resultSet = null;

    @Override
    public List<Album> getAlbumsByName(String albumName) {
        List<Album> albums = new ArrayList<Album>();

        String sql = "select * from album where albumname like ?";
        return getAlbums(albumName, albums, sql);
    }

    @Override
    public List<Album> getAlbumsBySinger(String singer) {
        List<Album> albums = new ArrayList<Album>();

        String sql = "select * from album where singer like ?";
        return getAlbums(singer, albums, sql);
    }

    @Override
    public Album getAlbumById(String albumId) {
        Album album = null;

        String sql = "select * from album where albumId = ?";

        Object[] params = {albumId};

        resultSet = this.ExecuteQuery(sql, params);

        try{
            while(resultSet.next()){
                String albumName = resultSet.getString("albumName");
                String singer = resultSet.getString("singer");

                album = new Album(albumId,albumName,singer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return album;
    }


    /**
     * @param str 专辑名或歌手
     * @param albums
     * @param sql
     * @return
     */
    private List<Album> getAlbums(String str, List<Album> albums, String sql) {
        Object[] params = {"%"+str+"%"};

        resultSet = this.ExecuteQuery(sql, params);

        try {
            while (resultSet.next()){
                String albumId = resultSet.getString("albumid");
                String albumName = resultSet.getString("albumname");
                String _singer = resultSet.getString("singer");

                Album album = new Album(albumId, albumName, _singer);

                albums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return albums;
    }

    @Override
    public boolean addAlbum(Album album) {
        String sql = "insert into album values(?,?,?)";

        Object[] params = {album.getAlbumId(),album.getAlbumName(),album.getSinger()};

        return this.executeUpdate(sql, params) > 0;
    }

    @Override
    public boolean updateAlbum(Album album) {
        return false;
    }

    @Override
    public boolean deleteAlbum(Album album) {
        return false;
    }
}
