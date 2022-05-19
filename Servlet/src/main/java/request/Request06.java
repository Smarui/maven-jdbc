package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author small瑞
 */
@WebServlet(value = "/Request06" , initParams = {
        @WebInitParam(name = "encoding" , value = "UTF-8")
})
public class Request06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getInitParameter("encoding");
        System.out.println(encoding);
        req.setCharacterEncoding(encoding);

        ServletInputStream inputStream = req.getInputStream();

        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));

    }
}
