package factory;

import dao.SearchDao;
import daoImpl.AlbumDaoImpl;
import daoImpl.MusicDaoImpl;
import daoImpl.SearchDaoImpl;
import daoImpl.UserDaoImpl;

public class DaoFactory {
    public static UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl();
    }

    public static MusicDaoImpl getMusicDaoImpl() {
        return new MusicDaoImpl();
    }

    public static AlbumDaoImpl getAlbumDaoImpl() {
        return new AlbumDaoImpl();
    }

    public static SearchDao getSearchDaoImpl() {
        return new SearchDaoImpl();
    }
}
