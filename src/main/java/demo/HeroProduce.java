package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 过程操作
 * @author small瑞
 */
public class HeroProduce {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";

        Connection connection = DriverManager.getConnection(url, "root", "rwaw1314520");
        System.out.println(connection);
        String sql = """
                create procedure add_hero(hero_name varchar(255), hero_sex varchar(255) , hero_location varchar(255) , hero_nickname varchar(255))
                begin
                insert into hero values(hero_name , hero_sex , hero_location , hero_nickname);
                end;
                """;

        Statement statement = connection.createStatement();
        boolean execute = statement.execute(sql);
        System.out.println(execute);
    }
}
