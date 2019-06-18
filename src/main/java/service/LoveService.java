package service;

import entity.Love;
import util.LoveList;

import java.util.List;

public interface LoveService {
    /**
     * @param userId
     * @return
     */
    public List<String> getLoveNames(String userId);

    public String getLoveId(String userId, String loveName, String musicId);

    /**
     * @param userId
     * @return
     */
    public List<LoveList> getUserLove(String userId);

    /**
     * @param love
     * @return
     */
    public boolean addLove(Love love);

    /**
     * @param loveId
     * @return
     */
    public boolean deleteLove(String userId, String loveId);

    /**
     * @param userId
     * @param loveName
     * @return
     */
    public boolean deleteUserLove(String userId,String loveName);

    /**
     * @param love
     * @return
     */
    public boolean checkLoved(Love love);

    public boolean checkLoveName(Love love);
}
