package daoImpl;

import dao.BaseDao;
import dao.SearchDao;
import entity.Album;
import entity.Music;
import entity.Music_a;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDaoImpl extends BaseDao implements SearchDao {

    private ResultSet resultSet=null;

    @Override
    public List<Music> SearchSinger(String singer) {
        List<Music> musics=new ArrayList<>();
        String sql="select * from music where singer like ?";
        Object params[]={"%"+singer+"%"};
        resultSet=this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                Music music=new Music();
                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("musicname"));
                music.setSinger(resultSet.getString("singer"));
                music.setAlbumId(resultSet.getString("albumid"));
                music.setLyricSrc(resultSet.getString("lyricsrc"));
                music.setMusicSrc(resultSet.getString("musicsrc"));
                music.setPicSrc(resultSet.getString("picsrc"));
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
    public List<Music> SearchMusicName(String musicName) {
        List<Music> musics=new ArrayList<>();
        String sql="select * from music where musicname like ?";
        Object params[]={"%"+musicName+"%"};
        resultSet=this.ExecuteQuery(sql,params);
        try{
            while(resultSet.next()){
                Music music =new Music();
                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("musicname"));
                music.setSinger(resultSet.getString("singer"));
                music.setAlbumId(resultSet.getString("albumid"));
                music.setLyricSrc(resultSet.getString("lyricsrc"));
                music.setMusicSrc(resultSet.getString("musicsrc"));
                music.setPicSrc(resultSet.getString("picsrc"));
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
        String sql="select * from album where albumname like ?";
        Object[] params={"%"+albumName+"%"};
        resultSet=this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                Album album=new Album();
                album.setAlbumName(albumName);
                album.setAlbumId(resultSet.getString("albumid"));
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

    @Override
    public Music SearchMusicId(String musicId) {
        Music music = null;
        String sql = "select * from music where musicId = ?";

        Object[] params = {musicId};

        resultSet = this.ExecuteQuery(sql,params);

        try {
            while (resultSet.next()){
                music = new Music(musicId,resultSet.getString("musicname"),resultSet.getString("singer"),resultSet.getString("albumid"), resultSet.getString("lyricsrc"), resultSet.getString("musicsrc"),resultSet.getString("picsrc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return music;
    }


}
