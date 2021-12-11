package servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取要下载的文件名
        String downloadFileName = "1.jpg";
        
        //2.读取要下载的文件内容（通过ServletContext对象可以读取）
        ServletContext servletContext = getServletContext();

        //4.在回传前，通过响应头告诉客户端回传的数据类型
        //获取要下载的文件的文件类型
        String mimeType = servletContext.getMimeType("/File/" + downloadFileName);
        System.out.println("回传文件的类型是：" + mimeType);
        //告诉客户端回传数据的类型
        resp.setContentType(mimeType);

        //5.还要通过响应头告诉客户端收到的数据用于下载使用
        //Content-Disposition响应头表示收到的数据怎么处理
        //attachment表示附件，表示下载使用
        //filename = 表示指定下载的文件名，该文件名可以与要下载的文件名不同，浏览器会按照这里的文件名来下载，但下载的内容还是指定的
        //url编码是把汉字转换成%xx%xx的格式，这个适合谷歌和IE浏览器
        //Base64编码适合火狐浏览器，且响应头得修改为  =?charest?B?xxxx?=  的形式
        if(req.getHeader("User-Agent").contains("Firefox")){
            //如果是火狐，使用Base64编码
            System.out.println("火狐");
            resp.setHeader("Content-Disposition", "attachment; filename ==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) + "?=");
        }else {
            //如果不是火狐，是IE或者谷歌，使用URL编码操作
            System.out.println("不是火狐");
            resp.setHeader("Content-Disposition", "attachment; filename = " + URLEncoder.encode("中国.jpg", "UTF-8"));
        }
        
        /**
         * / 斜杠被服务器解析为表示地址：http:ip:port/工程名/ 映射道web目录
         */
        InputStream inputStream = servletContext.getResourceAsStream("/File/" + downloadFileName);

        //3.把下载的文件内容回传给客户端
        
        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        //使用iojar包的工具类，讲输入流中的数据复制给输出流，输出给客户端
        IOUtils.copy(inputStream, outputStream);
        
       
    }
}
