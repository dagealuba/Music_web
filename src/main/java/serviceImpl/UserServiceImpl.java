package serviceImpl;

import entity.User;
import factory.DaoFactory;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(String userId) {

        return DaoFactory.getUserDaoImpl().getUserById(userId);
    }

    @Override
    public List<User> findUserById(List<String> userIds) {
        List<User> users=new ArrayList<>();

        for(String userId:userIds){
            User user=null;
            user= (User) DaoFactory.getUserDaoImpl().getUserById(userId);
            if(user!=null){
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public List<User> findUserByName(String userName) {
        return DaoFactory.getUserDaoImpl().getUsersByName(userName);
    }

    @Override
    public List<User> findAllUsers() {
        return DaoFactory.getUserDaoImpl().getAllUsers();
    }

    @Override
    public boolean insert(List<User> users) {
        int i=0;
        int n=users.size();
        for(User user:users){
            if(DaoFactory.getUserDaoImpl().getUserById(user.getUserId())==null) {
                if (DaoFactory.getUserDaoImpl().addUser(user)) {
                    i++;
                }
            }
        }
        return i==n;
    }

    @Override
    public boolean update(List<User> users) {
        int i=0;
        int n=users.size();
        for(User user:users){
            if(DaoFactory.getUserDaoImpl().getUserById(user.getUserId())!=null){
                if(DaoFactory.getUserDaoImpl().updateUser(user)){
                    i++;
                }
            }
        }
        return i==n;
    }

    @Override
    public boolean delete(List<User> users) {
        int i=0;
        int n=users.size();
        for(User user:users){
            if(DaoFactory.getUserDaoImpl().getUserById(user.getUserId())!=null){
                if(DaoFactory.getUserDaoImpl().deleteUser(user)){
                    i++;
                }
            }
        }
        return i==n;
    }
}
