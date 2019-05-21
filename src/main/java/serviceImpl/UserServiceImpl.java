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

    @Override
    public User findUserByEmail(String userEmail) {
        return DaoFactory.getUserDaoImpl().getUserByEmail(userEmail);
    }

    @Override
    public List<User> findUserById(List<String> userIds) {
        return null;
    }

    @Override
    public List<User> findUserByName(String userName) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public boolean insert(User user) {
        return DaoFactory.getUserDaoImpl().addUser(user);
    }

    @Override
    public boolean insert(List<User> users) {
        return false;
    }

    @Override
    public boolean update(List<User> users) {
        return false;
    }

    @Override
    public boolean delete(List<User> users) {
        return false;
    }

    @Override
    public Boolean updateUserAvatar(String url, String userId) {
        User user = findUserById(userId);
        user.setAvatarSrc(url);
        return DaoFactory.getUserDaoImpl().updateUser(user);
    }

}
