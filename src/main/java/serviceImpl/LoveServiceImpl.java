package serviceImpl;
import entity.Love;
import factory.DaoFactory;
import service.LoveService;

import java.util.ArrayList;
import java.util.List;

public class LoveServiceImpl implements LoveService {
    @Override
    public List<Love> findLovesByUserId(String userid) {
        return DaoFactory.getLoveDaoImpl().getAllLove(userid);
    }

    @Override
    public boolean addlove(Love love) {
            return DaoFactory.getLoveDaoImpl().addLove(love);

    }


}
