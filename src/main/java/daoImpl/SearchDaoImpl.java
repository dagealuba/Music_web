package daoImpl;

import dao.BaseDao;
import dao.SearchDao;
import entity.Album;
import entity.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchDaoImpl extends BaseDao implements SearchDao {

    private ResultSet resultSet=null;

    @Override
    public String SearchSinger(String singer) {

        String sql="select * from Music where signer like ?";
        Object params[]={singer};

        resultSet=this.ExecuteQuery(sql,params);
        Music music=new Music();
        try{
            while(resultSet.next()){
                music.setSigner(singer);
                music.getMusicSrc(resultSet.getString("musicSrc"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return music.getMusicSrc();

        //return BaseDao.ExecuteQuery(sql,params);
    }

    @Override
    public String SearchMusicName(String musicName) {

        String sql="select * from Music where musicName like ?";
        Object params[]={musicName};
        resultSet=this.ExecuteQuery(sql,params);
        Music music =new Music();
        try{
            while(resultSet.next()){
                music.setMusicName(musicName);
                music.getMusicSrc(resultSet.getString("musicSrc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return music.getMusicSrc();
    }

    @Override
    public List<Album> SearchAlbum(String albumName) {
        List<Album> albums=new ArrayList<>();
        String sql="select * from Album where albumName like ?";
        Object[] params={albumName};
        resultSet=this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                Album album=new Album();
                album.setAlbumName(albumName);
                album.setAlbumId(resultSet.getString("albumId"));
                album.setSinger(resultSet.getString("singer"));
                albums.add(album);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return albums;
    }
}
