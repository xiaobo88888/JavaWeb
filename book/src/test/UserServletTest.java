package test;

import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("这是login()方法被调用了");
    }
    public void regist(){
        System.out.println("这是regist()方法被调用了");
    }
    public void updataUser(){
        System.out.println("这是updataUser()方法被调用了");
    }
    public void updateUserPassword(){
        System.out.println("这是updateUserPassword()方法被调用了");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            //获取action业务，鉴别字符串，获取响应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);

            System.out.println(method);
            
            //调用目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
