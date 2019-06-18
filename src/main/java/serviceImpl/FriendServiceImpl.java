package serviceImpl;

import entity.Friend;
import entity.User;
import factory.DaoFactory;
import service.FriendService;

import java.util.ArrayList;
import java.util.List;

public class FriendServiceImpl implements FriendService {
    @Override
    public List<User> getFriends(String userId) {
        List<Friend> friends = DaoFactory.getFriendDaoImpl().getFriend(userId);

        List<User> users = new ArrayList<>();
        for (Friend friend:friends){
            User user = DaoFactory.getUserDaoImpl().getUserById(friend.getFriendId());
            user.setUserPassword("");
            users.add(user);
        }

        return users;
    }

    @Override
    public boolean add(String userId, String friendId) {
        Friend friend = new Friend(userId,friendId);
        return DaoFactory.getFriendDaoImpl().insert(friend);
    }

    @Override
    public boolean delete(String userId, String friendId) {
        Friend friend = new Friend(userId,friendId);
        return DaoFactory.getFriendDaoImpl().delete(friend);
    }
}
