package test;

import bean.User;
import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User("mqy", "mqy999", "mqyemail@qq.com"));
        userService.registUser(new User("wzs", "wzs888", "wzsemail@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User("liubo", "aaaa", null)));
        System.out.println(userService.login(new User("liubo", "lb1234", null)));
    }

    @Test
    public void exitsUsername() {
        if(userService.exitsUsername("wgh")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}