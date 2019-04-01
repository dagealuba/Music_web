package serviceImpl;

import entity.User;
import factory.DaoFactory;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(String userId) {
        return DaoFactory.getUserDaoImpl().getUserById(userId);
    }

    //@Override
    public List<User> findUserByName(String userName)
        {
            return DaoFactory.getUserDaoImpl().getUsersByName(userName);
        }

    @Override
    public boolean logoutUser(User user) {
        if(DaoFactory.getUserDaoImpl().deleteUser(user)==true)
            return  true;
        else
        return false;
    }

    @Override
    public boolean updateUserInfo(User user) {
        if(DaoFactory.getUserDaoImpl().updateUser(user)==true)
            return  true;
        else
            return false;
    }

    //@Override

   /* public boolean logoutUser(User user){
            {
                return DaoFactory.getUserDaoImpl().deleteUser(user);
    }*/

    /*@Override
    public boolean updateUserInfo(User user) {
                {
                    return DaoFactory.getUserDaoImpl().getUserById(userId);
    }*/

}
