package factory;

import serviceImpl.UserServiceImpl;

public class ServiceFactory {
    public static UserServiceImpl getUserService(){
        return new UserServiceImpl();
    }
}
