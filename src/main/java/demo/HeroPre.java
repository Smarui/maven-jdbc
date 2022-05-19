package demo;

import java.sql.*;
import java.util.Scanner;

/**
 * 预编译实现增删改查和过程
 * @author small瑞
 */
public class HeroPre {
    static void addHero(Connection connection , String sql) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.print("编号 : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("姓名 : ");
        String name = scanner.nextLine();
        System.out.print("性别 : ");
        String sex = scanner.nextLine();
        System.out.print("位置 : ");
        String location = scanner.nextLine();
        System.out.print("昵称 : ");
        String nickname = scanner.nextLine();
        System.out.println(nickname);
        System.out.print("台词 : ");
        String lines = scanner.nextLine();
        System.out.println(lines);

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2 , name);
        preparedStatement.setString(3 , sex);
        preparedStatement.setString(4 , location);
        preparedStatement.setString(5 , nickname);
        preparedStatement.setString(6 , lines);
        int i = preparedStatement.executeUpdate();
        System.out.println(i==1?"添加成功!":"添加失败!");
        preparedStatement.close();
        scanner.close();

    }
    static void deleteHero(Connection connection , String sql)throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入需要删除的英雄编号 : ");
        int n = scanner.nextInt();
        preparedStatement.setInt(1 , n);
        int i = preparedStatement.executeUpdate();
        System.out.println(i==1?"删除成功!":"删除失败!");
        preparedStatement.close();
        scanner.close();
    }
    static void updateHero(Connection connection)throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入需要修改的信息 : ");
        String cur = scanner.nextLine();
        System.out.println("修改的信息 : ");
        String mess = scanner.nextLine();
        String sql = "";
        if(cur.equals("name")){
            sql = "update hero set name = ? where id = ?";
        }
        else if(cur.equals("sex")){
            sql = "update hero set sex = ? where id = ?";
        }
        else if(cur.equals("location")){
            sql = "update hero set location = ? where id = ?";
        }
        else if(cur.equals("nickname")){
            sql = "update hero set nickname = ? where id = ?";
        }
        else if(cur.equals("lines")){
            sql = "update hero set lines = ? where id = ?";
        }
        else{
            throw new RuntimeException("错误索引信息!");
        }
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,mess);
        System.out.print("请输入修改英雄编号 : ");
        int n = scanner.nextInt();
        preparedStatement.setInt(2 , n);
        int i = preparedStatement.executeUpdate();
        System.out.println(i == 1 ? "更新成功":"更新失败");

        preparedStatement.close();
        scanner.close();
    }
    static void searchHero(Connection connection , String sql)throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.print(resultSet.getInt(1)+"   ");
            System.out.print(resultSet.getString(2)+"   ");
            System.out.print(resultSet.getString(3)+"   ");
            System.out.print(resultSet.getString(4)+"   ");
            System.out.print(resultSet.getString(5)+"   ");
            System.out.print(resultSet.getString(6)+"   ");
            System.out.println();
        }
        preparedStatement.close();
    }
    public static void main(String[] args)throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:orcl?userServerPrepStmts=true";
        String username = "C##smallrui";
        String password = "rwaw" ;

        Connection connection = DriverManager.getConnection(url, username, password);


        //增
        String addSql = "insert into hero values (?,?,?,?,?,?)";
        addHero(connection ,addSql);

        //删

        String deleteSql = "delete from hero where id=?";
        deleteHero(connection , deleteSql);

        //改

        updateHero(connection);

        //查
        String selectSql = "select * from hero";
        searchHero(connection,selectSql);

    }
}
