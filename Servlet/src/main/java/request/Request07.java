package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**传文件  --默认位置
 * @author small瑞
 */
@WebServlet("/Request07")
@MultipartConfig
public class Request07 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //post request读的是请求体
        req.setCharacterEncoding("UTF-8");

        System.out.println(req.getContextPath());

        System.out.println("------------------------------");

//        ServletInputStream inputStream = req.getInputStream();
//
//        byte[] bytes = inputStream.readAllBytes();
//
//        System.out.println(new String(bytes,"UTF-8"));

//        BufferedReader reader = req.getReader();
//        String cur ;
//        while((cur = reader.readLine())!=null){
//            System.out.println(cur);
//        }


//        Part cur = req.getPart("看山");
//
//        System.out.println(cur.getSize());
//
//        System.out.println(cur.getName());
//
//        System.out.println(cur.getSubmittedFileName());
//
//        InputStream inputStream = cur.getInputStream();
//
//        byte[] bytes = inputStream.readAllBytes();
//        System.out.println(new String(bytes , "UTF-8"));

        Collection<Part> parts = req.getParts();

        for(Part cur:parts){
            System.out.println(cur.getName());
        }

    }
}
