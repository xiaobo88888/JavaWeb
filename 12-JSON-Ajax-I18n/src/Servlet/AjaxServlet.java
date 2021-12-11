package Servlet;

import bean.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet{
   
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求发过来了");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Person person = new Person(1, "刘博");
        
        //先转成json字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        
        resp.getWriter().write(personJsonString);
    }

    protected void jqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryAjax == 方法调用了");

        Person person = new Person(1, "刘博");

        //先转成json字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
    protected void jqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGet == 方法调用了");

        Person person = new Person(1, "刘博");

        //先转成json字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
    protected void jqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryPost == 方法调用了");

        Person person = new Person(1, "刘博");

        //先转成json字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jqueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGetJson == 方法调用了");

        Person person = new Person(1, "刘博");

        //先转成json字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jquerySerialize == 方法调用了");

        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));
        System.out.println("single：" + req.getParameter("single"));
        System.out.println("multiple：" + req.getParameter("multiple"));
        System.out.println("复选框：" + req.getParameterValues("check")[0] + req.getParameterValues("check")[1]);
        System.out.println("单选框：" + req.getParameter("radio"));
        
        
        Person person = new Person(1, "刘博");

        //先转成json字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
}
