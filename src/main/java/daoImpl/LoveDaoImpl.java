package daoImpl;

import dao.BaseDao;
import dao.LoveDao;
import entity.Love;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoveDaoImpl extends BaseDao implements LoveDao {
    private ResultSet resultSet = null;

    @Override
    public List<String> getUesrLoveName(String userId) {
        List<String> loveNames = new ArrayList<String>();
        String sql = "select lovename from love where userid=? group by lovename";
        Object[] params = {userId};

        this.resultSet = this.ExecuteQuery(sql,params);
        try {
            while (resultSet.next()){
                String loveName = resultSet.getString("lovename");
                loveNames.add(loveName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return loveNames;
    }

    @Override
    public List<Love> getUserLove(String userId) {
        List<Love> loves = new ArrayList<Love>();

        String sql = "select * from love where userId=?";
        Object[] params = {userId};

        this.resultSet = this.ExecuteQuery(sql,params);
        try {
            while (resultSet.next()){
                Love love = new Love(resultSet.getString("loveid"),resultSet.getString("lovename"),resultSet.getString("userid"),resultSet.getString("musicid"));
                loves.add(love);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource();
        }

        return loves;
    }

    @Override
    public boolean addLove(Love love) {
        String sql = "insert into love values(?,?,?,?)";
        Object[] params = {love.getLoveId(),love.getLoveName(),love.getUserId(),love.getMusicId()};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean deleteLove(String loveId) {
        String sql = "delete from love where loveid=?";
        Object[] params = {loveId};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean deleteUerLove(String userId, String loveName) {
        String sql = "delete from love where userid=? and lovename=?";
        Object[] params = {userId,loveName};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean updateLove(String loveId) {
        String sql = "update love set musicid=null where loveid=?";
        Object[] params = {loveId};

        return this.executeUpdate(sql,params) > 0;
    }
}
