package daoImpl;

import dao.BaseDao;
import dao.HistoryDao;
import entity.History;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDaoImpl extends BaseDao implements HistoryDao {
    private ResultSet resultSet = null;

    @Override
    public List<History> getHistoryByUser(String userId) {
        List<History> histories = new ArrayList<History>();

        String sql = "select * from history where userid=? and time in (select max(time) from history group by musicid)";
        Object[] params = {userId};

        resultSet = this.ExecuteQuery(sql,params);

        try {
            while (resultSet.next()){
                History history = new History();
                history.setHistoryId(resultSet.getString("historyid"));
                history.setMusicId(resultSet.getString("musicid"));
                history.setUserId(userId);
                history.setTime(resultSet.getTimestamp("time"));
                histories.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }

        return histories;
    }

    @Override
    public History getUserLatestHistory(String userId) {
        History history = null;

        String sql = "select * from history where userId=? order by time desc limit 1";
        Object[] params = {userId};

        resultSet=this.ExecuteQuery(sql,params);
        try {
            while (resultSet.next()){
                history = new History();
                history.setHistoryId(resultSet.getString("historyid"));
                history.setMusicId(resultSet.getString("musicid"));
                history.setUserId(userId);
                history.setTime(resultSet.getTimestamp("time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }

        return history;
    }

    @Override
    public int getNumOfMusic(String musicId) {
        String sql = "select count(*) from history where musicId=?";
        Object[] params = {musicId};

        int n = -1;
        this.resultSet = this.ExecuteQuery(sql,params);

        try {
            while (resultSet.next()){
                n = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return n;
    }

    @Override
    public boolean insertHistory(History history) {
        String sql = "insert into history(historyid,userid,musicid) values (?,?,?)";
        Object[] params = {history.getHistoryId(),history.getUserId(),history.getMusicId()};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean deleteHistory(String historyId) {
        String sql = "delete from history where historyid=?";
        Object[] params = {historyId};

        return this.executeUpdate(sql, params) > 0;
    }
}
