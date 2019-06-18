package daoImpl;

import dao.BaseDao;
import dao.FriendDao;
import entity.Friend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendDaoImpl extends BaseDao implements FriendDao {
    private ResultSet resultSet = null;

    @Override
    public List<Friend> getFriend(String userId) {
        List<Friend> friends = new ArrayList<>();
        String sql = "select * from friend where userId=?";
        Object[] params = {userId};

        this.resultSet = this.ExecuteQuery(sql,params);

        try{
            while (resultSet.next()){
                Friend friend = new Friend(resultSet.getString("userId"),resultSet.getString("friendId"));
                friends.add(friend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return friends;
    }

    @Override
    public boolean insert(Friend friend) {
        String sql = "insert into friend values(?,?)";
        Object[] params = {friend.getUserId(),friend.getFriendId()};

        return this.executeUpdate(sql,params) > 0;
    }

    @Override
    public boolean delete(Friend friend) {
        String sql = "delete from friend where userId=? and friendId=?";
        Object[] params = {friend.getUserId(),friend.getFriendId()};

        return this.executeUpdate(sql,params) > 0;
    }
}
