package serviceImpl;

import entity.Album;
import factory.DaoFactory;
import service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public String FindSinger(String singer) {
        return DaoFactory.getSearchDaoImpl().SearchSinger(singer );
    }

    @Override
    public String FindMusicName(String musicName) {
        return DaoFactory.getSearchDaoImpl().SearchMusicName(musicName);
    }

    @Override
    public List<Album> FindAlbumName(String albumName) {
        return DaoFactory.getSearchDaoImpl().SearchAlbum(albumName);
    }
}
