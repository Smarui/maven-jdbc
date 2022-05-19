package listener;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration;

/**
 *   通过监听动态添加servlet
 * @author small瑞
 */
public class AddServlet implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();


        //动态添加Servlet

        //添加Servlet 和 类
        ServletRegistration.Dynamic thirdStyle = servletContext.addServlet("ThirdStyle", "method.ThirdStyle");

        //添加映射

        thirdStyle.addMapping("/ThirdStyle");
    }
}
