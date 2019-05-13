package dao;

import entity.Love;
import entity.Music;

import java.util.List;

public interface LoveDao {
    public List<Love> getAllLove(String userId);

    public Love getLoveByLoveId(String loveId);

    public boolean addLove(Love love);

    public boolean updateLove(Love love);

    public boolean deleteLove(Love love);



}
