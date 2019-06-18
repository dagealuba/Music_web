package daoImpl;

import dao.BaseDao;
import dao.PlayListDao;
import entity.PlayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayListDaoImpl extends BaseDao implements PlayListDao {
    private ResultSet resultSet = null;

    @Override
    public List<PlayList> getPlayList(String userId) {
        String sql = "select * from playlist where userid=? order by num";
        Object[] params = {userId};

        List<PlayList> playLists = new ArrayList<>();
        this.resultSet = this.ExecuteQuery(sql,params);
        try {
            while(resultSet.next()){
                PlayList playList = new PlayList(resultSet.getString("userid"),resultSet.getString("musicid"),resultSet.getInt("num"));

                playLists.add(playList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return playLists;
    }

    @Override
    public boolean add(PlayList playList) {
        String sql = "insert into playlist values(?,?,?)";
        Object[] params = {playList.getUserId(),playList.getMusicId(),playList.getNum()};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean update(PlayList playList) {
        String sql = "update playlist set num=? where userid=? and musicid=?";
        Object[] params = {playList.getNum(),playList.getUserId(),playList.getMusicId()};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean delete(PlayList playList) {
        String sql = "delete from playlist where userid=? and musicid=?";
        Object[] params = {playList.getUserId(),playList.getMusicId()};

        return this.executeUpdate(sql,params) > 0;
    }
}
