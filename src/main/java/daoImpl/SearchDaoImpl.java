package daoImpl;

import dao.BaseDao;
import dao.SearchDao;
import entity.Album;
import entity.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDaoImpl extends BaseDao implements SearchDao {

    private ResultSet resultSet=null;

    @Override
    public List<Music> SearchSinger(String signer) {
        List<Music> musics=new ArrayList<>();
        String sql="select * from Music where signer like ?";
        Object params[]={signer};
        resultSet=this.ExecuteQuery(sql,params);
        Music music=new Music();
        try{
            while(resultSet.next()){
                music.setMusicId(resultSet.getString("musicId"));
                music.setMusicName(resultSet.getString("musicName"));
                music.setSigner(resultSet.getString("signer"));
                music.setAlbumId(resultSet.getString("albumId"));
                music.setLyricSrc(resultSet.getString("lyricSrc"));
                music.setMusicSrc(resultSet.getString("musicSrc"));
                music.setPicSrc(resultSet.getString("picSrc"));
                musics.add(music);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return musics;

        //return BaseDao.ExecuteQuery(sql,params);
    }

    @Override
    public List<Music> SearchMusicName(String musicName) {
        List<Music> musics=new ArrayList<>();
        String sql="select * from Music where musicName like ?";
        Object params[]={musicName};
        resultSet=this.ExecuteQuery(sql,params);
        Music music =new Music();
        try{
            while(resultSet.next()){
                music.setMusicId(resultSet.getString("musicId"));
                music.setMusicName(resultSet.getString("musicName"));
                music.setSigner(resultSet.getString("signer"));
                music.setAlbumId(resultSet.getString("albumId"));
                music.setLyricSrc(resultSet.getString("lyricSrc"));
                music.setMusicSrc(resultSet.getString("musicSrc"));
                music.setPicSrc(resultSet.getString("picSrc"));
                musics.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return musics;
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
