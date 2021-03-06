package daoImpl;

import dao.BaseDao;
import dao.MusicDao;
import entity.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDaoImpl extends BaseDao implements MusicDao {
    private ResultSet resultSet = null;

    @Override
    public List<Music> getMusics(String str) {
        return null;
    }

    @Override
    public List<Music> getMusics() {
        List<Music> musics = new ArrayList<>();

        String sql = "select * from music";
        Object[] params = {};

        this.resultSet = this.ExecuteQuery(sql, params);

        try {
            while (resultSet.next()){
                String musicId = resultSet.getString("musicid");
                String musicName = resultSet.getString("musicname");
                String singer = resultSet.getString("singer");
                String albumId = resultSet.getString("albumid");
                String lyricSrc = resultSet.getString("lyricsrc");
                String musicSrc = resultSet.getString("musicsrc");
                String picSrc = resultSet.getString("picsrc");

                Music music = new Music(musicId, musicName, singer, albumId, lyricSrc, musicSrc, picSrc);

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
    public List<Music> getMusicsByAlbum(String albumid) {
        List<Music> musics = new ArrayList<>();

        String sql = "select * from music where albumid=?";
        Object[] params = {albumid};

        this.resultSet = this.ExecuteQuery(sql, params);

        try {
            while (resultSet.next()){
                String musicId = resultSet.getString("musicid");
                String musicName = resultSet.getString("musicname");
                String singer = resultSet.getString("singer");
                String albumId = resultSet.getString("albumid");
                String lyricSrc = resultSet.getString("lyricsrc");
                String musicSrc = resultSet.getString("musicsrc");
                String picSrc = resultSet.getString("picsrc");

                Music music = new Music(musicId, musicName, singer, albumId, lyricSrc, musicSrc, picSrc);

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
    public List<Music> getMusicsBySongName(String songName) {
        List<Music> musics = new ArrayList<Music>();

        String sql = "select * from music where musicname like ?";

        Object[] params = {songName+"%"};
        resultSet = this.ExecuteQuery(sql, params);

        try {
            while (resultSet.next()){
                String musicId = resultSet.getString("musicid");
                String musicName = resultSet.getString("musicname");
                String singer = resultSet.getString("singer");
                String albumId = resultSet.getString("albumid");
                String lyricSrc = resultSet.getString("lyricsrc");
                String musicSrc = resultSet.getString("musicsrc");
                String picSrc = resultSet.getString("picsrc");

                Music music = new Music(musicId, musicName, singer, albumId, lyricSrc, musicSrc, picSrc);

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
    public boolean addMusic(Music music) {
        String sql = "insert into music values(?,?,?,?,?,?,?)";
        Object[] params = {music.getMusicId(),music.getMusicName(),music.getSinger(),music.getAlbumId(),music.getLyricSrc(),music.getMusicSrc(),music.getPicSrc()};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean updateMusic(Music music) {
        return false;
    }

    @Override
    public boolean deleteMusic(Music music) {
        String sql = "delete from music where musicid = ?";
        Object[] params = {music.getMusicId()};

        return this.executeUpdate(sql, params) > 0;
    }


    public Music getMusicById(String musicid) {
        Music music = new Music();

        String sql = "select * from music where musicid = ?";
        Object[] params = {musicid};

        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("musicname"));
                music.setSinger(resultSet.getString("singer"));
                music.setAlbumId(resultSet.getString("albumid"));
                music.setLyricSrc(resultSet.getString("lyricsrc"));
                music.setMusicSrc(resultSet.getString("musicsrc"));
                music.setPicSrc(resultSet.getString("picsrc"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return music;
    }
}
