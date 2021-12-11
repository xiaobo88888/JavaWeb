package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.List;

public class UploadServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//先得到流对象
        ServletInputStream inputStream = req.getInputStream();
        
        byte[] buffer = new byte[10240000];
        //read表示读到的字节数
        int read = inputStream.read(buffer);
        //输出上传的内容
        System.out.println(new String(buffer, 0, read));*/
        
        //先判断上传的数据是否是多段的数据（只有是多端的数据，才是文件上传的）
        if(ServletFileUpload.isMultipartContent(req)){
            //先创建一个ServletFileUpload类

            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            
            try {
                //解析上传的数据，得到表单项的集合FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                
                //判断每一个表单项是什么类型的
                for(FileItem fileItem : list){
                    if(fileItem.isFormField()){
                        //普通表单项

                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        //参数UTF-8解决乱码问题
                        System.out.println("表单项的value属性值：" + fileItem.getString("UTF-8"));
                        
                    }else{
                        //上传的文件

                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        
                        //写入磁盘
                        fileItem.write(new File("E:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        

    }
}
