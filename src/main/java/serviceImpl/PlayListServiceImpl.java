package serviceImpl;

import entity.PlayList;
import factory.DaoFactory;
import service.PlayListService;
import util.Music_a;

import java.util.ArrayList;
import java.util.List;

public class PlayListServiceImpl implements PlayListService {
    @Override
    public List<PlayList> getPlayList(String userId) {
        return DaoFactory.getPlayListDaoImpl().getPlayList(userId);
    }

    @Override
    public List<Music_a> getUserPlayList(String userId) {
        List<PlayList> playLists = getPlayList(userId);

        List<Music_a> music_as = new ArrayList<>();
        for (PlayList playList:playLists){
            Music_a music_a = new Music_a(DaoFactory.getMusicDaoImpl().getMusicById(playList.getMusicId()));
            music_as.add(music_a);
        }

        return music_as;
    }

    @Override
    public boolean add(String userId, String musicId) {
        List<PlayList> playLists = getPlayList(userId);

        int num = playLists.size();

        PlayList playList = new PlayList(userId,musicId,num);

        return DaoFactory.getPlayListDaoImpl().add(playList);
    }

    @Override
    public boolean delete(String userId, String musicId) {
        List<PlayList> playLists = getPlayList(userId);

        int num = -1;

        for (int i = 0;i<playLists.size();i++){
            PlayList playList = playLists.get(i);

//            System.out.println(playList.getUserId().equals(userId) && playList.getMusicId().equals(musicId));
//            System.out.println(playList.getUserId() + " " + userId);
//            System.out.println(playList.getMusicId()+ " " + musicId);
            if (playList.getUserId().equals(userId) && playList.getMusicId().equals(musicId)){
                if (DaoFactory.getPlayListDaoImpl().delete(playList)){
                    num = i;
                    break;
                }
                else {
                    return false;
                }
            }
        }


        if (num != -1){
            for (int i = num+1;i < playLists.size();i++){
                playLists.get(i).setNum(playLists.get(i).getNum()-1);

                if (!DaoFactory.getPlayListDaoImpl().update(playLists.get(i))){
                    return false;
                }
            }
        }
        else return false;

        return true;
    }
}
