package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 *   获取get传递的初始化参数
 * @author small瑞
 */
@WebServlet(value = "/Request03" ,initParams = {
        @WebInitParam(name = "username" , value = "smallrui"),
        @WebInitParam(name = "password" , value = "rwaw1314"),
        @WebInitParam(name = "lines" , value = "点亮了混沌,就是干干净净的人间")

})
public class Request03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Enumeration<String> initParameterNames = this.getInitParameterNames();


        Enumeration<String> parameterNames = request.getParameterNames();

        while(initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement() ;

            System.out.println(key +" : " +  this.getInitParameter( key ));
        }
    }
}
