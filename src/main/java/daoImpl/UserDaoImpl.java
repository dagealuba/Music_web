package daoImpl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    private ResultSet resultSet = null;
    //测试数据库连接
    public static void main(String[] args) {
        UserDao bdi = new UserDaoImpl();
        System.out.println(bdi.getAllUsers());
        System.out.println("测试getall函数");
        System.out.println(bdi.getUserById("3"));
        System.out.println("测试getbyid");
       // System.out.println(bdi.getUsersByName("张安"));
        //System.out.println("测试getbyName");
        User u=new User("3","heng","22","33","44");
       System.out.println(bdi.updateUser(u));
        //System.out.println("测试updateUser");
        System.out.println(bdi.getUserById("3"));
       // System.out.println("测试getall函数");
        //System.out.println(bdi.addUser(u));

    }


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
    //实现根据间接得到的id得到ID的用户信息
    public User getUserById(String userId) {
        User user = new User();

        String sql = "select * from user where userId="+userId;
        System.out.println(sql);

        Object[] params = {};
        resultSet = this.ExecuteQuery(sql,params);

        try {
            while(resultSet.next()){
               // User user = new User();

                user.setUserId(resultSet.getString("userid"));
                user.setUserName(resultSet.getString("username"));
                user.setUserPassword(resultSet.getString("userpassword"));
                user.setUserEmail(resultSet.getString("useremail"));
                user.setAvatarSrc(resultSet.getString("avatarsrc"));

               // users.add(user);
            }
        }catch (SQLException e){

        }finally {
            this.closeResource();
        }

        return user;
    }

    @Override
    public List<User> getUsersByName(String userName)
    {
        List<User> users = new ArrayList<User>();
        String sql="select * from user where userName like ?";
        userName = "%"+userName+"%";
        Object[] params={userName};
        resultSet=this.ExecuteQuery(sql,params);
        try{
            while(resultSet.next()){
                User user=new User();
                user.setUserId(resultSet.getString("userid"));
                user.setUserName(resultSet.getString("username"));
                user.setUserPassword(resultSet.getString("userpassword"));
                user.setUserEmail(resultSet.getString("useremail"));
                user.setAvatarSrc(resultSet.getString("avatarsrc"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return users;


    }

    @Override
    public boolean addUser(User user) {

        String sql = "insert into user values(?,?,?,?,?)";
        String userId=user.getUserId();
        String userName=user.getUserName();
        String userPassword=user.getUserPassword();
        String userEmail=user.getUserEmail();
        String AvatarSrc=user.getAvatarSrc();
        System.out.println(userName);
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
        String sql = "update user set userName = ?,userPassword = ?,userEmail = ?,avatarSrc=? where userId = ?";
        String userId=user.getUserId();
        String userName=user.getUserName();
        String userPassword=user.getUserPassword();
        String userEmail=user.getUserEmail();
        String avatarSrc=user.getAvatarSrc();
        Object[] params={userName,userPassword,userEmail,avatarSrc,userId};
        return this.executeUpdate(sql,params)>0;
    }

}
