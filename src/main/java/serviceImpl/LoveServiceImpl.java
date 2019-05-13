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
        if(!checkLoveName(love))
        {
            return DaoFactory.getLoveDaoImpl().addLove(love);
        }
        return false;
    }

    @Override
    public boolean checkLoveName(Love love) {
        List<Love> loves = findLovesByUserId(love.getUserId());

        if(loves.size()>0)
        {
            for(Love l:loves){
                if(l.getLoveName().equals(love.getLoveName()))
                    return true;
            }
        }
        return false;
    }


}
