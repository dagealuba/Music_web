package serviceImpl;

import entity.Album;
import entity.Music;
import factory.DaoFactory;
import service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<Music> FindSinger(String signer) {
        return DaoFactory.getSearchDaoImpl().SearchSinger(signer );
    }

    @Override
    public List<Music> FindMusicName(String musicName) {
        return DaoFactory.getSearchDaoImpl().SearchMusicName(musicName);
    }

    @Override
    public List<Album> FindAlbumName(String albumName) {
        return DaoFactory.getSearchDaoImpl().SearchAlbum(albumName);
    }


}
