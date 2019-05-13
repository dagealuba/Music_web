package service;

import entity.Love;

import java.util.List;

public interface LoveService {

    public List<Love> findLovesByUserId(String userid);

    public boolean addlove(Love love);


}
