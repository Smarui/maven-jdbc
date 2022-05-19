package method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 第二种开发方式
 * @author small瑞
 */
@WebServlet("/SecondStyle")
public class SecondStyle extends HttpServlet {

    static {
        System.out.println("类加载了!");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        System.out.println("service 方法 对外提供服务 ");
        System.out.println(request);
        System.out.println(response);
    }
}
