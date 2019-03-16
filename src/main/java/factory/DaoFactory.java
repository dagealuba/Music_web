package factory;

import daoImpl.UserDaoImpl;

public class DaoFactory {
    public static UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl();
    }
}
