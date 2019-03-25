package daoImpl;

import dao.AlbumDao;
import dao.BaseDao;
import entity.Album;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDaoImpl extends BaseDao implements AlbumDao {
    private  ResultSet resultSet = null;
    @Override
    public List<Album> getAllAlbum() {
        List<Album> albums = new ArrayList<Album>();

        String sql = "select * from album";

        Object[] params = {};
        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                Album album = new Album();

                album.setAlbumId(resultSet.getString("albumid"));
                album.setAlbumName(resultSet.getString("albumname"));
                album.setAlbumName(resultSet.getString("singer"));

                albums.add(album);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeResource();
        }

        return albums;
    }

    @Override
    public Album getAlbumById(String albumid) {

        Album album =  new Album();

        String sql = "select * from album where albumid = ?";
        Object[] params = {albumid};

        resultSet = this.ExecuteQuery(sql,params);
        try{
            while(resultSet.next()){
                album .setAlbumId(resultSet.getString("albumid"));
                album .setAlbumName(resultSet.getString("albumname"));
                album .setSinger(resultSet.getString("singer"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            this.closeResource();
        }
        return album;
    }

    @Override
    public Album getAlbumByName(String albumname) {
        Album album = new Album();

        String sql = "select * from album where albumname = ?";
        Object[] params = {albumname};

        resultSet = this.ExecuteQuery(sql,params);
        try{
            while(resultSet.next()){
                album.setAlbumId(resultSet.getString("albumid"));
                album .setAlbumName(resultSet.getString("albumname"));
                album .setSinger(resultSet.getString("singer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return album;
    }

    @Override
    public Album getAlbumBySinger(String singer) {
        Album album = new Album();

        String sql = "select * from album where singer = ?";
        Object[] params = {singer};

        resultSet = this.ExecuteQuery(sql,params);
        try{
            while(resultSet.next()){
                album.setAlbumId(resultSet.getString("albumid"));
                album .setAlbumName(resultSet.getString("albumname"));
                album .setSinger(resultSet.getString("singer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return album;
    }

    @Override
    public boolean addAlbum(Album album) {
        String sql = "insert into album value (?,?,?)";
        Object[] params = {album.getAlbumId(),album.getAlbumName(),album.getSinger()};

        int row = this.executeUpdate(sql,params);
        if(row!=0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteAlbum(Album album) {

        String sql = "delete from album where albumid = ?";
        Object[] params ={album.getAlbumId()};

        int row = this.executeUpdate(sql,params);
        if(row!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateAlbum(Album album) {

        String sql = "update album set albumname = ?,singer = ? where albumid = ?";
        Object[] params = {album.getAlbumName(),album.getSinger()};

        int row = this.executeUpdate(sql,params);
        if(row!=0)
            return true;
        else
            return false;
    }
}
