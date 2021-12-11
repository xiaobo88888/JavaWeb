package test;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if(userDao.queryUserByUsername("liubo") == null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("liubo", "lb1234") == null){
            System.out.println("用户名或密码错误");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        User user = new User("wgh", "wgh666", "wgheamil@qq.com");
        if(userDao.saveUser(user) == -1){
            System.out.println("用户信息保存失败");
        }else{
            System.out.println("用户信息保存成功");
        }
    }
}