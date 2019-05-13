package factory;

import daoImpl.AlbumDaoImpl;
import daoImpl.LoveDaoImpl;
import daoImpl.MusicDaoImpl;
import daoImpl.UserDaoImpl;

public class DaoFactory {
    public static UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl();
    }

    public static AlbumDaoImpl getAlbumDaoImpl(){return new AlbumDaoImpl();}

    public static MusicDaoImpl getMusicDaoImpl(){return new MusicDaoImpl();}

    public static LoveDaoImpl  getLoveDaoImpl() {return  new LoveDaoImpl();}

}
