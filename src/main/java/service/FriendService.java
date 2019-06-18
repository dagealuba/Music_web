package service;

import entity.User;

import java.util.List;

public interface FriendService {
    public List<User> getFriends(String userId);

    public boolean add(String userId, String friendId);

    public boolean delete(String userId, String friendId);
}
