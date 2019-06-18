package dao;

import entity.Friend;

import java.util.List;

public interface FriendDao {
    public List<Friend> getFriend(String userId);

    public boolean insert(Friend friend);

    public boolean delete(Friend friend);
}
