package serviceImpl;

import entity.Album;
import entity.Music;
import entity.Music_a;
import factory.DaoFactory;
import service.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<Music_a> FindSinger(String singer) {
        List<Music> musicList = DaoFactory.getSearchDaoImpl().SearchSinger(singer);
        List<Music_a> music_as = new ArrayList<Music_a>();

        for (Music music : musicList) {
            music_as.add(new Music_a(music));
        }

        return music_as;
    }

    @Override
    public List<Music_a> FindMusicName(String musicName) {
        List<Music> musicList = DaoFactory.getSearchDaoImpl().SearchMusicName(musicName);
        List<Music_a> music_as = new ArrayList<Music_a>();

        for (Music music: musicList){
            music_as.add(new Music_a(music));
        }

        return music_as;
    }

    @Override
    public List<Album> FindAlbumName(String albumName) {
        return DaoFactory.getSearchDaoImpl().SearchAlbum(albumName);
    }


}
