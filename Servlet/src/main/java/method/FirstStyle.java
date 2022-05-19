package method;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 *第一种 Servlet 开发方式
 * @author small瑞
 */
@WebServlet(value = "/firstStyle")
public class FirstStyle implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("执行了初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("执行了获取传递信息");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行了服务");
    }

    @Override
    public String getServletInfo() {
        System.out.println("执行了获取信息");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("执行了毁灭!");
    }

    //实现Servlet接口
}
