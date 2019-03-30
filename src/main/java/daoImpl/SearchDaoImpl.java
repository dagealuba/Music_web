package daoImpl;

import dao.BaseDao;
import dao.SearchDao;
import entity.Album;

import java.util.List;

public class SearchDaoImpl extends BaseDao implements SearchDao {
    @Override
    public String SearchSinger(String singer) {

        String sql="select * from Music where signer=?";
        return null;
    }

    @Override
    public String SearchMusicName(String musicName) {

        String sql="select * from Music where musicName=?";
        return null;
    }

    @Override
    public List<Album> SearchAlbum(String albumName) {

        String sql="select * from Album";
        return null;
    }
}
