package file;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.ServerException;

/**
 * 文件下载
 * 2019.08.15
 */
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServerException,IOException{
        response.setContentType("text/html;charset=utf-8");
        //获取需要下载的文件
        String filename = request.getParameter("filename");
        //下载文件所在目录
        String folder = "/img/";
        //通知浏览器以下载方式打开
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename="+filename);
        //通过文件流读取文件
        InputStream in = getServletContext().getResourceAsStream(folder + filename);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        //循环取出流中的数据
        while ((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws ServerException, IOException {
        doGet(request,response);
    }
}
