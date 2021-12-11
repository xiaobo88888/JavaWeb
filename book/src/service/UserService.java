package service;

import bean.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    void registUser(User user);

    /**
     * 用户登录
     * @param user
     * @return 如果返回null，说明登录失败，否则返回用户信息
     */
    User login(User user);

    /**
     * 检查用户名是否存在
     * @param usename
     * @return 如果返回true，则表示用户名已存在，如果返回false，则表示用户名不存在
     */
    boolean exitsUsername(String usename);
}
