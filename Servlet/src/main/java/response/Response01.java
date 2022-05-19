package response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

/**
 * @author small瑞
 */
@WebServlet("/Response01")
public class Response01 extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");


        System.out.println(res.getContentType());

        System.out.println(res.getBufferSize());

//        res.setContentType("text/plain");
//
//        PrintWriter writer = res.getWriter();
//        writer.write(5555);
//        writer.write("大沙坝");
//        writer.write("无敌杀神");


        //--html
//        res.setContentType("text/html");
//
//        PrintWriter writer = res.getWriter();
//
//        writer.write("""
//                <h1 style="color: aqua">你是傻狗第三多阿斯达啊</h1>
//                """);


        //--图片
        ServletOutputStream outputStream = res.getOutputStream();

        String path = "C:/Users/small瑞/Desktop/图片/201112111532-3-lp.jpg";
        FileInputStream fileInputStream = new FileInputStream(path);

        byte[] bytes = fileInputStream.readAllBytes();

        outputStream.write(bytes);

        fileInputStream.close();

        outputStream.close();

    }
}
