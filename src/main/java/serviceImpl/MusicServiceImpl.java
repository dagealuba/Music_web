package serviceImpl;

import entity.Music;
import factory.DaoFactory;
import service.MusicService;

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
}
