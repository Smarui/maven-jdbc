import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;
import pro_demo.Hero;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestF {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "rwaw1314520";

        Connection connection = DriverManager.getConnection(url , username , password);
        //System.out.println(connection);

        String sql = "select * from hero where id = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入要查询的英雄编号 : ");
        int n = scanner.nextInt();

        preparedStatement.setInt(1 , n);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));

    }
    static Class<Hero> intiRe()throws Exception{
        Class<Hero> heroClass = Hero.class;
        return heroClass;
    }
    @Test
    public void test01() throws Exception {
        //mysql
        //预编译

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "rwaw1314520";

        Connection connection = DriverManager.getConnection(url , username , password);

        String sql = "select * from hero where id = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入要查询的英雄编号 : ");
        int n = scanner.nextInt();

        preparedStatement.setInt(1 , n);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));


    }

    @Test
    public void test02() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";

        Connection connection = DriverManager.getConnection(url , "root" , "rwaw1314520");

        String sql = "select * from hero where id = 6";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString(3));
        System.out.println(resultSet.getString(4));
        System.out.println(resultSet.getInt(5));

        System.out.println("---------------------------------------");

        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println(metaData);

        intiRe();



    }
    @Test
    public void test03() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";

        String username = "root";

        String password = "rwaw1314520";

        Class<DriverManager> driverManagerClass = DriverManager.class;

        Method getConnection = driverManagerClass.getMethod("getConnection", String.class, String.class, String.class);

        Connection connection = (Connection) getConnection.invoke(null,url, username, password);

        String sql = "select * from hero where id = 6";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        Class<Hero> heroClass = intiRe();

        Constructor<Hero> declaredConstructor = heroClass.getDeclaredConstructor();
        Hero hero = declaredConstructor.newInstance();

        resultSet.next();

        hero.setName(resultSet.getString(1));
        hero.setSex(resultSet.getString(2));
        hero.setLocation(resultSet.getString(3));
        hero.setNickname(resultSet.getString(4));

        System.out.println("英雄编号 : "+resultSet.getInt(5));
        System.out.println("信息如下:");
        System.out.println(hero);
    }
    @Test
    public void test04() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";

        String username = "root";

        String password = "rwaw1314520";

        Class<DriverManager> driverManagerClass = DriverManager.class;

        Method getConnection = driverManagerClass.getMethod("getConnection", String.class, String.class, String.class);

        Connection connection = (Connection) getConnection.invoke(null,url, username, password);

        String sql = "select * from hero ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        Class<ArrayList> arrayListClass = ArrayList.class;
        Constructor<ArrayList> declaredConstructor = arrayListClass.getDeclaredConstructor();
        ArrayList arrayList = declaredConstructor.newInstance();
        Class<Hero> heroClass = intiRe();
        Constructor<Hero> declaredConstructor1 = heroClass.getDeclaredConstructor();

        while(resultSet.next()){
            Hero hero = declaredConstructor1.newInstance();
            hero.setName(resultSet.getString(1));
            hero.setSex(resultSet.getString(2));
            hero.setLocation(resultSet.getString(3));
            hero.setNickname(resultSet.getString(4));
            arrayList.add(hero);
        }
        System.out.println(arrayList);
    }

    //jdbc -- 训练题二  jdbc实现过程一
    @Test
    public void testHeroAdd01() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";

        Connection connection = DriverManager.getConnection(url, "root", "rwaw1314520");
        System.out.println(connection);
        String sql = """
                create procedure add_hero(hero_name varchar(255), hero_sex varchar(255) , hero_location varchar(255) , hero_nickname varchar(255) )
                begin
                insert into hero values(hero_name , hero_sex , hero_location , hero_nickname);
                end;
                """;

        Statement statement = connection.createStatement();
        boolean execute = statement.execute(sql);
        System.out.println(execute);
    }

    @Test
    public void testHeroAdd02() throws Exception{
         Class.forName("com.mysql.jdbc.Driver");

         String url = "jdbc:mysql:///lol?useSSl=false&useServerPrepStmts=true";

        Connection connection = DriverManager.getConnection(url, "root", "rwaw1314520");

        String sql = """
                call add_hero(?,?,?,?,?)
                """;

        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.setString(1 ,"卡茨克" );
        callableStatement.setString(2 ,"男" );
        callableStatement.setString(3 ,"打野" );
        callableStatement.setString(4 ,"虚空掠夺者" );
        callableStatement.setInt(5 ,0 );

        boolean execute = callableStatement.execute();
        System.out.println(execute);
    }


    //jdbc -- 训练题二  jdbc实现过程二
    @Test
    public void testGetHero01() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSl=false&useServerPrepStmts=true";

        Connection connection = DriverManager.getConnection(url, "root", "rwaw1314520");

        String sql = """
                create procedure get_hero(in hero_id  int  , out hero_name varchar(255), out hero_sex varchar(255) ,out hero_location varchar(255) ,out hero_nickname varchar(255))
                                
                begin
                select name,sex,location,nickname into hero_name,hero_sex,hero_location,hero_nickname from hero where id = hero_id ;
                end;
                """;
        Statement statement = connection.createStatement();

        boolean execute = statement.execute(sql);

        System.out.println(execute);


    }
    @Test
    public void testGetHero02() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///lol?useSSl=false&useServerPrepStmts=true";

        Connection connection = DriverManager.getConnection(url, "root", "rwaw1314520");

        String sql = """
                call get_hero(?,?,?,?,?);
                """;

        CallableStatement callableStatement = connection.prepareCall(sql);

        callableStatement.setInt("hero_id", 7);

        //注册out

        callableStatement.registerOutParameter("hero_name",JDBCType.VARCHAR);
        callableStatement.registerOutParameter("hero_sex",JDBCType.VARCHAR);
        callableStatement.registerOutParameter("hero_location",JDBCType.VARCHAR);
        callableStatement.registerOutParameter("hero_nickname",JDBCType.VARCHAR);

        boolean execute = callableStatement.execute();

        if(!execute){
            System.out.println(callableStatement.getString(2));
            System.out.println(callableStatement.getString(3));
            System.out.println(callableStatement.getString(4));
            System.out.println(callableStatement.getString(5));

        }

    }

}
