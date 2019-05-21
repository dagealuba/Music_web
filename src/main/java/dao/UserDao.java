package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 返回所有用户
     * @return List<User>
     */
    public List<User> getAllUsers();


    /**
     * 根据id查询某个用户的信息
     * @param userId
     * @return User
     */
    public User getUserById(String userId);

    /**
     * @param userEmail
     * @return
     */
    public User getUserByEmail(String userEmail);
    /**
     * 根据用户名查找用户
     * @param userName
     * @return List<User>
     */
    public List<User> getUsersByName(String userName);

    /**
     * 增加用户
     * @param user
     * @return boolean
     */
    public boolean addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return boolean
     */
    public boolean deleteUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return boolean
     */
    public boolean updateUser(User user);
}
