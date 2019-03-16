package serviceImpl;

import entity.User;
import factory.DaoFactory;
import service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(String userId) {
        return DaoFactory.getUserDaoImpl().getUserById(userId);
    }
}
