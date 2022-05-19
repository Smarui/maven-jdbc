package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 表单传递参数
 * @author small瑞
 */
@WebServlet("/Request04")
public class Request04 extends HttpServlet {
    static {
        System.out.println("......");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Enumeration<String> parameterNames = request.getParameterNames();
        while( parameterNames.hasMoreElements() ){
            String parameterName = parameterNames.nextElement();
            String parameter = request.getParameter(parameterName);
            System.out.println( parameterName + " : " + parameter );
        }
    }
}
