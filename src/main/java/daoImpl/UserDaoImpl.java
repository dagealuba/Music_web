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
            getUsers(users);
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
                user = new User(userId,resultSet.getString("username"),resultSet.getString("userpassword"),resultSet.getString("useremail"),resultSet.getString("avatarsrc"), resultSet.getInt("usertype"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return user;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        User user = null;
        String sql = "select * from user where useremail=?";
        Object[] params = {userEmail};

        resultSet=this.ExecuteQuery(sql,params);
        try {
            while (resultSet.next()){
                user = new User(resultSet.getString("userid"),resultSet.getString("username"),resultSet.getString("userpassword"),resultSet.getString("useremail"),resultSet.getString("avatarsrc"), resultSet.getInt("usertype"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

        return user;
    }

    @Override
    public List<User> getUsersByName(String userName) {
        List<User> users = new ArrayList<User>();
        String sql="select * from user where userName like ?";
        userName = "%"+userName+"%";
        Object[] params={userName};
        resultSet=this.ExecuteQuery(sql,params);
        try{
            getUsers(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return users;
    }

    //查找用户的重复代码
    private void getUsers(List<User> users) throws SQLException {
        while(resultSet.next()){
            User user=new User();
            user.setUserId(resultSet.getString("userid"));
            user.setUserName(resultSet.getString("username"));
            user.setUserPassword(resultSet.getString("userpassword"));
            user.setUserEmail(resultSet.getString("useremail"));
            user.setAvatarSrc(resultSet.getString("avatarsrc"));
            user.setUserType(resultSet.getInt("usertype"));
            users.add(user);
        }
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into user(userid,username,userpassword,useremail,avatarsrc) values(?,?,?,?,?)";
        String userId=user.getUserId();
        String userName=user.getUserName();
        String userPassword=user.getUserPassword();
        String userEmail=user.getUserEmail();
        String AvatarSrc=user.getAvatarSrc();
        Object[] params={userId,userName,userPassword,userEmail,AvatarSrc};

        return this.executeUpdate(sql,params)>0;
    }

    @Override
    public boolean deleteUser(User user) {
        String sql = "delete from user where userId = ?";
        String userId=user.getUserId();
        Object[] params={userId};
        return this.executeUpdate(sql,params)>0;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set username = ?,userpassword = ?,useremail = ?,avatarsrc=?,usertype=? where userid = ?";

        String userId=user.getUserId();
        String userName=user.getUserName();
        String userPassword=user.getUserPassword();
        String userEmail=user.getUserEmail();
        String AvatarSrc=user.getAvatarSrc();
        int userType = user.getUserType();
        Object[] params={userName,userPassword,userEmail,AvatarSrc,userType,userId};


        return this.executeUpdate(sql,params)>0;
    }
}
