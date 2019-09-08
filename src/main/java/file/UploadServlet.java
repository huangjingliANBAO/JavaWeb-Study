package file;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 * 2019.08.14
 */
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws IOException,ServletException{
        try{
            //设置字符编码
            response.setContentType("text/html;charset=utf-8");
            //创建DiskFileItemFactory工厂对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //创建文件目录
            File file = new File("E:\\testfile");
            if (!file.exists()){
                file.mkdirs();
            }
            //设置文件的缓冲路径
            factory.setRepository(file);
            //创建ServletFileUpload对象
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            //设置字符编码
            fileUpload.setHeaderEncoding("utf-8");
            //解析request，得到上传文件的FileItem对象
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            //获取字符流
            PrintWriter writer = response.getWriter();
            //遍历集合
            for (FileItem fileitem:fileItems){
                //判断是否为字段
                if (fileitem.isFormField()){
                    //获取字段名和字段值
                    String name = fileitem.getFieldName();
                    if (name.equals("name")){
                        //如果文件不为空，保存到value
                        if (!fileitem.getString().equals("")){
                            String value = fileitem.getString("utf-8");
                            writer.print("上传者" + value + "<br/>");
                        }
                    }
                }else {
                    //获取上传的文件名
                    String filename = fileitem.getName();
                    //处理上传文件
                    if (filename != null && !filename.equals("")){
                        writer.print("上传的文件名称是" + filename + "<br/>");
                        //截取出文件名
                        filename = filename.substring(filename.lastIndexOf("\\") + 1);
                        //文件名需要唯一
                        filename = UUID.randomUUID().toString() + "_" + filename;
                        //在服务器创建同名文件
                        String webPath = "/upload/";
                        //将服务器中文件夹路径与文件名组合完整的服务器路径
                        String filepath = getServletContext().getRealPath(webPath + filename);
                        //创建文件
                        File file1 = new File(filepath);
                        file1.getParentFile().mkdirs();
                        file1.createNewFile();
                        //获取上传文件流
                        InputStream in = fileitem.getInputStream();
                        //打开服务器的上传文件
                        FileOutputStream out = new FileOutputStream(file1);
                        byte[] buffer = new byte[1024];
                        int len;
                        //开始读取上传文件的字节，并将其输出到服务器的上传文件输出流中
                        while ((len = in.read(buffer)) > 0){
                            out.write(buffer,0,len);
                            in.close();
                            out.close();
                            fileitem.delete();
                            writer.print("上传文件成功！<br/>");
                        }
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws IOException,ServletException {
        doGet(request,response);
    }
}
