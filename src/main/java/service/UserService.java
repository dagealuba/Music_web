package service;

import entity.User;

import java.util.List;

public interface UserService {
    /**
     * 根据id查找用户，返回一个用户实体类
     * @param userId
     * @return User
     */
    public User findUserById(String userId);

    List<User> findUserById(List<String> userIds);

    List<User> findUserByName(String userName);

    List<User> findAllUsers();

    boolean insert(List<User> users);

    boolean update(List<User> users);

    boolean delete(List<User> users);

    /**
     * @param url
     * @return 修改是否成功
     */
    public Boolean updateUserAvatar(String url,String userId);
}
