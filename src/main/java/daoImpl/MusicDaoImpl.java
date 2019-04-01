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
    /**
     * 功能描述:获取所有歌曲
     * @param: []
     * @return: java.util.List<entity.Music>
     */
    public List<Music> getAllMusic() {
        List<Music> musics =  new ArrayList<Music>();

        String sql = "select * from music";

        Object[] params = {};
        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
               Music music = new Music();

                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("albumname"));
                music.setSigner(resultSet.getString("singer"));
                music.setLyricSrc(resultSet.getString("lyricsrc"));
                music.setMusicSrc(resultSet.getString("musicsrc"));
                music.setPicSrc(resultSet.getString("picsrc"));
                musics.add(music);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeResource();
        }

        return musics;

    }

    @Override
    /**
     * 功能描述:根据歌曲id获得歌曲
     * @param: [musicid]
     * @return: entity.Music
     */
    public Music getMusicById(String musicid) {
        Music music = new Music();

        String sql = "select * from music where musicid = ?";
        Object[] params = {musicid};

        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("musicname"));
                music.setSigner(resultSet.getString("singer"));
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

    @Override
    /**
     * 功能描述:根据歌曲名获取歌曲
     * @param: [musicname]
     * @return: java.util.List<entity.Music>
     */
    public List<Music> getMusicByName(String musicname) {
        List<Music> musics  = new ArrayList<Music>();
        String sql = "select * from music where musicname = ?";
        Object[] params = {musicname};

        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                Music music = new Music();

                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("musicname"));
                music.setSigner(resultSet.getString("singer"));
                music.setAlbumId(resultSet.getString("albumid"));
                music.setLyricSrc(resultSet.getString("lyricsrc"));
                music.setMusicSrc(resultSet.getString("musicsrc"));
                music.setPicSrc(resultSet.getString("picsrc"));

                musics.add(music);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return musics;
    }

    @Override
    /**
     * 功能描述:根据歌手获取歌曲
     * @param: [singer]
     * @return: java.util.List<entity.Music>
     */
    public List<Music> getMusicBySinger(String singer) {
        List<Music> musics  = new ArrayList<Music>();
        String sql = "select * from music where singer = ?";
        Object[] params = {singer};

        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                Music music = new Music();

                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("musicname"));
                music.setSigner(resultSet.getString("singer"));
                music.setAlbumId(resultSet.getString("albumid"));
                music.setLyricSrc(resultSet.getString("lyricsrc"));
                music.setMusicSrc(resultSet.getString("musicsrc"));
                music.setPicSrc(resultSet.getString("picsrc"));

                musics.add(music);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return musics;
    }

    @Override
    /**
     * 功能描述:根据歌曲名和歌手获取歌曲
     * @param: [musicname, singer]
     * @return: entity.Music
     */
    public Music getMusicByNameAndSinger(String musicname, String singer) {

        String sql = "select * from music where musicname=? and singer=?";
        Object[] params={musicname,singer};
        Music music = new Music();

        resultSet = this.ExecuteQuery(sql,params);
        try{
            while(resultSet.next()){
                music.setMusicId(resultSet.getString("musicid"));
                music.setMusicName(resultSet.getString("musicname"));
                music.setSigner(resultSet.getString("singer"));
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

    @Override
    /**
     * 功能描述:添加歌曲
     * @param: [music]
     * @return: boolean
     */
    public boolean addMusic(Music music) {

        String sql = "insert into music values(?,?,?,?,?,?,?)";
        Object[] params = {music.getMusicId(),music.getMusicName(),music.getAlbumId(),music.getSigner(),music.getLyricSrc(),music.getMusicSrc(),music.getPicSrc()};

        int row = this.executeUpdate(sql,params);
        if(row!=0) {
            this.closeResource();
            return true;
        }
        else {
            this.closeResource();
            return false;
        }
    }

    @Override
    public boolean deleteMusic(Music music) {

        String sql = "delete from music where musicid = ?";
        Object[] params = {music.getMusicId()};

        int row = this.executeUpdate(sql,params);
        if(row!=0) {
            this.closeResource();
            return true;
        }
        else {
            this.closeResource();
            return false;
        }
    }

    @Override
    /**
     * 功能描述:更新歌曲
     * @param: [music]
     * @return: boolean
     */
    public boolean updateMusic(Music music) {
        String sql = "update music musicname = ?,singer = ?,albumid = ?,lyrisrc = ?,musicsrc = ?,picsrc = ? where musicid = ?";
        Object[] params = {music.getMusicName(),music.getSigner(),music.getAlbumId(),music.getLyricSrc(),music.getMusicSrc(),music.getPicSrc(),music.getMusicId()};

        int row = this.executeUpdate(sql,params);
        if(row!=0) {
            this.closeResource();
            return true;
        }
        else {
            this.closeResource();
            return false;
        }

    }


}
