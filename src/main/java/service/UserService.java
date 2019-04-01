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
    /**
     * 根据用户名称中的一段查找到可能的用户信息，返回一个用户实体类列
     * @param userName
     * @return List<User>
     */
    public List<User> findUserByName(String userName);
    /**
     * 注销用户
     * @param user
     * @return boolean
     */
    public boolean logoutUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return boolean
     */
    public boolean updateUserInfo(User user);

}
