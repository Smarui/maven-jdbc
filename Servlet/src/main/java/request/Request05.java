package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * post
 *
 * @author small瑞
 */
@WebServlet("/Request05")
public class Request05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Enumeration<String> parameterNames = req.getParameterNames();

        while(parameterNames.hasMoreElements()){
            String cur = parameterNames.nextElement();
            System.out.println(req.getParameter(cur) + " : " + cur);
        }

        System.out.println("-------------------------------------");

    }
}
