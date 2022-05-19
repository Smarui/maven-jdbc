package client;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class HttpClient01 {
    @Test
    public void test01(){
        HttpClient httpClient = HttpClient.newBuilder().build();
        URI cur = URI.create("http://localhost:8080/Servlet_war/Request01");
        HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(cur).build();


        //发送请求

    }
}
