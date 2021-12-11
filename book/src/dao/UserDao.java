package dao;


import bean.User;

public interface UserDao{


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null，则说明该用户不存在
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null，则说明用户名或密码错误
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return 如果返回-1，则说明用户信息保存失败，返回其他的则表示sql语句影响的行数
     */
    int saveUser(User user);
}
