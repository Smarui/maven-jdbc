package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HeroTest {
    static void createTable(Connection connection , String sql)throws Exception{

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        boolean execute = preparedStatement.execute();

        System.out.println(execute==false?"创建成功!":"创建失败");
        preparedStatement.close();
    }

    public static void main(String[] args) throws Exception {

        //注册驱动  --网络中一定要
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "C##smallrui";
        String password = "rwaw";

        //获取连接

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

        //获取操作

        //创建表
        String sql = "create table ecut_student (id int primary key , name varchar2(255) not null, numbers int not null, birthdate date not null)";
        createTable(connection , sql );
        //插入
        String sql1 = "insert into ecut_student values(001 , '灭天杀神' , 1123451214 , sysdate)";
        int insert = insert(connection, sql1);
        System.out.println("影响的行数 : " + insert);

        //查询
        String sql2 = "select * from ecut_student";

        select(connection , sql2);


        //改
        String sql4 = "update ecut_student set name  = '古法金回复刚发把号' where id = 1 ";
        int update = update(connection, sql4);
        System.out.println("影响的行数 : " + update);

        //删除
        String sql3 = "delete from ecut_student where id = 1 ";
        int delete = delete(connection, sql3);
        System.out.println("影响的行数 : " + delete);


        connection.close();


    }
    static int update (Connection connection ,String sql )throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }
    static int insert(Connection connection , String sql) throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i ;
    }
    static ResultSet select(Connection connection , String sql)throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getInt(3));
            System.out.println(resultSet.getDate(4));
        }
        preparedStatement.close();
        return resultSet;
    }
    static int delete(Connection connection , String sql ) throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return  i ;
    }


}
