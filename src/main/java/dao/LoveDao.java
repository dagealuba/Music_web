package dao;

import entity.Love;

import java.util.List;

public interface LoveDao {
    public List<Love> getAllLove();

    public Love getLoveByLoveId(String loveId);

}
