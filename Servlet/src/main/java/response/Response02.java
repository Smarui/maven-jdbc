package response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * --设置状态码
 * @author small瑞
 */
@WebServlet(value = "/Response02",initParams = {
        @WebInitParam(name = "encoding" , value = "UTF-8")
})
public class Response02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = this.getInitParameter("encoding");

        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        response.setStatus(500);
    }
}
