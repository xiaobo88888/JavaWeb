package servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        //2.发送sql语句到数据库查询

        //一二步骤先不写了，直接生成学生信息来当作查询到的数据
        //生成学生信息
        List<User> userList = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            int t = i + 1;
            userList.add(new User(t, "username" + t, 18 + t, "phone" + t));
        }

        //3.将查询到的信息存放至request中以便传递
        req.setAttribute("studentList", userList);
        //4.请求转发到showStudent.jsp输出页面
        req.getRequestDispatcher("/Test/showStudent.jsp").forward(req, resp);
    }
}
