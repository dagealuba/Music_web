package serviceImpl;

import entity.Love;
import util.LoveList;
import util.Music_a;
import factory.DaoFactory;
import service.LoveService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class LoveServiceImpl implements LoveService {
    @Override
    public List<String> getLoveNames(String userId) {
        return DaoFactory.getLoveDaoImpl().getUesrLoveName(userId);
    }

    @Override
    public String getLoveId(String userId, String loveName, String musicId) {
        List<Love> loves = DaoFactory.getLoveDaoImpl().getUserLove(userId);

        for (Love love:loves){
            if (love.getMusicId()==null){
                continue;
            }
            if (love.getMusicId().equals(musicId)){
                if (love.getLoveName().equals(loveName)){
                    return love.getLoveId();
                }
            }
        }
        return null;
    }

    @Override
    public List<LoveList> getUserLove(String userId) {
        List<LoveList> loveLists = new ArrayList<>();

        List<Love> loves = DaoFactory.getLoveDaoImpl().getUserLove(userId);

        System.out.println(loves.size());
        for (Love love: loves){
            boolean flag = false;
            for (LoveList loveList: loveLists){
                if (loveList.getLoveName().equals(love.getLoveName())){
                    List<Music_a> music_as = loveList.getMusics();
                    if (love.getMusicId() != null){
//                    System.out.println(love.getMusicId());
                        music_as.add(new Music_a(DaoFactory.getMusicDaoImpl().getMusicById(love.getMusicId())));
                    }
                    flag = true;
                    break;
                }
            }

            if (!flag){
                List<Music_a> music_as = new ArrayList<>();
                if (love.getMusicId() != null){
//                    System.out.println(love.getMusicId());
                    music_as.add(new Music_a(DaoFactory.getMusicDaoImpl().getMusicById(love.getMusicId())));
                }
                loveLists.add(new LoveList(love.getLoveName(),music_as));
            }
        }

        return loveLists;
    }

    @Override
    public boolean addLove(Love love) {
        if (!checkLoved(love)){
            return false;
        }

        if (love.getMusicId()==null){
            Love l = new Love();
            l.setMusicId(null);
            l.setLoveId(UUID.randomUUID().toString());
            l.setUserId(love.getUserId());
            l.setLoveName(love.getLoveName());

            return DaoFactory.getLoveDaoImpl().addLove(l);
        }



        if (checkLoveName(love)){
            Love l = new Love();
            l.setMusicId(null);
            l.setLoveId(UUID.randomUUID().toString());
            l.setUserId(love.getUserId());
            l.setLoveName(love.getLoveName());

            return DaoFactory.getLoveDaoImpl().addLove(love) && DaoFactory.getLoveDaoImpl().addLove(l);
        }

        return DaoFactory.getLoveDaoImpl().addLove(love);
    }

    @Override
    public boolean deleteLove(String userId, String loveId) {
        List<Love> loves = DaoFactory.getLoveDaoImpl().getUserLove(userId);
        if (loves.size()==1){
            System.out.println("test");
            return DaoFactory.getLoveDaoImpl().updateLove(loveId);
        }
        return DaoFactory.getLoveDaoImpl().deleteLove(loveId);
    }

    @Override
    public boolean deleteUserLove(String userId, String loveName) {
        return DaoFactory.getLoveDaoImpl().deleteUerLove(userId,loveName);
    }

    @Override
    public boolean checkLoved(Love love) {
        if (!(love.getMusicId()==null)){
            List<LoveList> loveLists = getUserLove(love.getUserId());
            for (LoveList loveList:loveLists){
                if (love.getLoveName().equals(loveList.getLoveName())){
                    for (Music_a music_a: loveList.getMusics()){
//                        System.out.println(love.getMusicId().equals(music_a.getMusicId()));
                        if (love.getMusicId().equals(music_a.getMusicId())){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean checkLoveName(Love love) {
        String name = love.getLoveName();
        String id = love.getUserId();

        List<Love> loves = DaoFactory.getLoveDaoImpl().getUserLove(id);

        for (Love l:loves){
            if (l.getLoveName().equals(name)){
                return false;
            }
        }

        return true;
    }
}
