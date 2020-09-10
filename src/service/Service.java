package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mapper.Mapper;
import po.User;


@Component("serviceImp")
public class Service {

    //service调用dao层实现类，使用注解的方式
    @Autowired(required=true)
    private Mapper mapper;

    public Boolean Login(String username,String password) throws Exception {
        List<User> list = mapper.query();
        Boolean bool=null;

        for(User user:list){
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                bool=true;break;
            }
            else
                bool=false;
        }
        return bool;
    }


    public Boolean register(User user) throws Exception{
        Boolean bool=false;

        if(mapper.query2(user.getUsername())==null){
            mapper.query3(user);
            bool=true;
        }

        return bool;
    }


}