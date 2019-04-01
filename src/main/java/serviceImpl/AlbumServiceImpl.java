package serviceImpl;

import entity.Album;
import factory.DaoFactory;
import service.AlbumService;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {
    @Override
    public List<Album> getAlbumsByName(String albumName) {
        return DaoFactory.getAlbumDaoImpl().getAlbumsByName(albumName);
    }

    @Override
    public List<Album> getAlbumsBySinger(String singer) {
        return DaoFactory.getAlbumDaoImpl().getAlbumsBySinger(singer);
    }

    @Override
    public boolean addAlbum(Album album) {
        return DaoFactory.getAlbumDaoImpl().addAlbum(album);
    }
}
