package serviceImpl;

import entity.Music;
import factory.DaoFactory;
import service.MusicService;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    @Override
    /**
     * 功能描述:删除音乐；
     * @param: [music]
     * @return: boolean
     */
    public boolean deleteMusic(Music music){
        return DaoFactory.getMusicDaoImpl().deleteMusic(music);
    }

    @Override
    /**
     * 功能描述:根据歌曲名称和歌手名查找歌曲
     * @param: [musicname, singer]
     * @return: entity.Music
     */
    public Music findMusicByNameAndSinger(String musicname, String singer) {
        return DaoFactory.getMusicDaoImpl().getMusicByNameAndSinger(musicname,singer);
    }

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

        if (musicList.size() > 0) {
            for (Music m : musicList) {
                if (m.getMusicSrc().equals(music.getMusicSrc())) {
                    return true;
                }
            }
        }
    }

    @Override
    public boolean updateMusic(Music music) {
        return DaoFactory.getMusicDaoImpl().updateMusic();
    }

}
