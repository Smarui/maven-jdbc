
import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author small瑞
 */
public class HelloWord implements Servlet {

    ServletConfig s ;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        s = servletConfig;
        System.out.println("初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("返回");
        return s;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务");
    }

    @Override
    public String getServletInfo() {
        System.out.println("之星");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("关闭");
    }
}
