package entity;


/**
 * 用户实体类
 */
public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String avatarSrc;
    private int userType;

    public User(String id, String name, String password, String email, String avatar, int userType) {
        userId = id;
        userName = name;
        userPassword = password;
        userEmail = email;
        avatarSrc = avatar;
        this.userType = userType;
    }

    public User() {

    }

    /**
     * 还有要用的构造函数可以自己加
     *
     */

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAvatarSrc() {
        return avatarSrc;
    }

    public void setAvatarSrc(String avatarSrc) {
        this.avatarSrc = avatarSrc;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
