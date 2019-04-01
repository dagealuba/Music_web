package serviceImpl;

import entity.Music;
import factory.DaoFactory;
import service.MusicService;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    @Override
    public boolean addMusic(Music music) {
        System.out.println(checkMusicName(music));
        if ( !checkMusicName(music) ){
            return DaoFactory.getMusicDaoImpl().addMusic(music);
        }

        return false;
    }

    @Override
    public List<Music> getMusicsByName(String musicName) {
        return DaoFactory.getMusicDaoImpl().getMusicsBySongName(musicName);
    }

    @Override
    public boolean checkMusicName(Music music) {
        List<Music> musicList = getMusicsByName(music.getMusicName());

        if (musicList.size() > 0){
            for (Music m: musicList){
                if (m.getMusicSrc().equals(music.getMusicSrc())){
                    return true;
                }
            }
        }

        return false;
    }
}
