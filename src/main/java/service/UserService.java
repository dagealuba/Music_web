package service;

import entity.User;

public interface UserService {
    /**
     * 根据id查找用户，返回一个用户实体类
     * @param userId
     * @return User
     */
    public User findUserById(String userId);
}
