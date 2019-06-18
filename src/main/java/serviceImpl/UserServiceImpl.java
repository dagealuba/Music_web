package serviceImpl;

import entity.Love;
import entity.User;
import factory.DaoFactory;
import service.UserService;

import java.util.List;
import java.util.UUID;

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
        return DaoFactory.getUserDaoImpl().getUsersByName(userName);
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public boolean insert(User user) {
        Love _default = new Love();
        _default.setLoveId(UUID.randomUUID().toString());
        _default.setUserId(user.getUserId());
        _default.setLoveName("默认收藏夹");
        _default.setMusicId(null);
        return DaoFactory.getUserDaoImpl().addUser(user) && DaoFactory.getLoveDaoImpl().addLove(_default);
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
