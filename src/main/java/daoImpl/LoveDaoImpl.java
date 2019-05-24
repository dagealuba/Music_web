package daoImpl;

import dao.BaseDao;
import dao.LoveDao;
import entity.Love;
import entity.Music;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoveDaoImpl extends BaseDao implements LoveDao {
    private ResultSet resultSet = null;


    @Override
    public List<Love> getAllLove(String userId) {
        List<Love> loves = new ArrayList<Love>();


        String sql = "select * from love where userid = ?";
        Object[] params = {userId};

        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
              String loveid = resultSet.getString("loveid");
              String lovename = resultSet.getString("lovename");
              String userid = resultSet.getString("userid");
              String musicid = resultSet.getString("musicid");

                Love love = new Love(loveid,lovename,userid,musicid);
                loves.add(love);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return  loves;
    }

    @Override
    public Love getLoveByLoveId(String loveId) {
        Love love = new Love();

        String sql = "select * from love where loveid = ?";
        Object[] params = {loveId};

        resultSet = this.ExecuteQuery(sql, params);

        try {
            while (resultSet.next()) {
                love.setMusicId(resultSet.getString("loveid"));
                love.setLoveName(resultSet.getString("lovename"));
                love.setUserId(resultSet.getString("userid"));
                love.setMusicId(resultSet.getString("musicid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return love;
    }

    @Override
    public List<Music> getMusicInLove(Love love) {
        List<Music> musics = new ArrayList<Music>();
        String sql = "select * from love where lovename=? and userid=?";
        Object[] params = {love.getLoveName(),love.getUserId()};
        MusicDaoImpl m = new MusicDaoImpl();

        resultSet = this.ExecuteQuery(sql,params);
        try {
            while (resultSet.next()) {
                String musicid = resultSet.getString("musicid");
                Music music = m.getMusicById(musicid);

                musics.add(music);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
         return musics;
    }

    @Override
    public boolean addLove(Love love) {
        String sql = "insert into love values(?,?,?,?)";
        Object[] params = {love.getLoveId(),love.getLoveName(),love.getUserId(),love.getMusicId()};

        int row = this.executeUpdate(sql,params);
        if(row>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateLove(Love love) {
        String sql = "update love set lovename = ?";
        String lovename = love.getLoveName();
        Object[] params = {lovename};

        return this.executeUpdate(sql,params)>0;
    }


    @Override
    public boolean deleteLove(Love love) {
        String sql = "delete from love where loveid = ?";
        String loveId = love.getLoveId();
        Object[] params = {loveId};

        return this.executeUpdate(sql,params)>0;
    }
}
