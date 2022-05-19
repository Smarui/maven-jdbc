package method;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 继承GenericServlet类
 * @author small瑞
 */
public class ThirdStyle extends GenericServlet {

    static {
        System.out.println("类加载了......");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("开始服务了......");
    }
}
