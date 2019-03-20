package daoImpl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    private ResultSet resultSet = null;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();

        String sql = "select * from user";

        Object[] params = {};
        resultSet = this.ExecuteQuery(sql,params);

        try {
            while(resultSet.next()){
                User user = new User();

                user.setUserId(resultSet.getString("userid"));
                user.setUserName(resultSet.getString("username"));
                user.setUserPassword(resultSet.getString("userpassword"));
                user.setUserEmail(resultSet.getString("useremail"));
                user.setAvatarSrc(resultSet.getString("avatarsrc"));

                users.add(user);
            }
        }catch (SQLException e){

        }finally {
            this.closeResource();
        }

        return users;
    }

    @Override
    public User getUserById(String userId) {
        String sql = "select * from user where userid=?";

        Object[] params = {userId};
        resultSet = this.ExecuteQuery(sql,params);

        User user = null;
        try {
            while (resultSet.next()){
                user = new User(userId,resultSet.getString("username"),resultSet.getString("userpassword"),resultSet.getString("useremail"),resultSet.getString("avatarsrc"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return user;
    }

    @Override
    public List<User> getUsersByName(String userName) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set userid=?,username=?,userpassword=?,useremail=?,avatarsrc=? where userid="+user.getUserId();
        Object[] params = {user.getUserId(),user.getUserName(),user.getUserPassword(),user.getUserEmail(),user.getAvatarSrc()};

        return this.executeUpdate(sql,params)>0;
    }
}
