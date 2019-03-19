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
        List<User> users = new ArrayList<>();

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
           e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return users;
    }

    @Override
    public User getUserById(String userId){
        User user = new User();

        String sql = "select * from user where userid = ? ";

        Object[] params = {userId};
        resultSet = this.ExecuteQuery(sql,params);

        try{
            while(resultSet.next()){
                user.setUserId(resultSet.getString("uderid"));
                user.setUserName(resultSet.getString("udername"));
                user.setUserPassword(resultSet.getString("usermail"));
                user.setUserEmail(resultSet.getString("avatarsrc"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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
        return false;
    }
}
