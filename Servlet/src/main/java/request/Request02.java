package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author small瑞
 */
@WebServlet("/Request02")
public class Request02 extends HttpServlet {

    //res  - > post
    //request  - - > get

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("提交方式 : "+request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getCookies());
        System.out.println(request.getContextPath());
        System.out.println(request.getQueryString());
        System.out.println(request.getServletPath());
        System.out.println("服务器端口号 : "+request.getServerPort());
        System.out.println("远端端口号 : "+ request.getRemotePort());
        System.out.println("本地端口号 : "+ request.getLocalPort());
    }
}
