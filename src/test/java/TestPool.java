import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import javax.sql.PooledConnection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TestPool {
    String url = "jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true";
    String username = "root";
    String password = "rwaw1314520" ;

    /**
     * Java 自带数据库连接池
     */
    @Test
    public void test01() throws SQLException {
        //Java  可以通过set语句设置用户和数据库
        DataSource dataSource = new MysqlDataSource();

        Connection connection = dataSource.getConnection(username , password);
        String sql = "use lol";
        Statement statement = connection.createStatement();
        boolean execute = statement.execute(sql);
        System.out.println(execute);
        boolean execute1 = statement.execute("select * from hero");
        if(execute1){
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        }
    }

    /**
     *Java 自带的连接池 继承了DataSource
     * @throws SQLException
     */
    @Test
    public void test02() throws SQLException {
        MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
        mysqlConnectionPoolDataSource.setUrl("jdbc:mysql:///lol?useSSL=false&useServerPrepStmts=true");
        mysqlConnectionPoolDataSource.setUser("root");
        mysqlConnectionPoolDataSource.setPassword("rwaw1314520");


        PooledConnection pooledConnection = mysqlConnectionPoolDataSource.getPooledConnection();

        Connection connection = pooledConnection.getConnection();
        String sql = "select * from hero";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
        }


    }

    /**
     * DBCP数据库连接池
     * @throws SQLException
     */
    @Test
    public void test03() throws Exception {
        Properties properties = new Properties() ;
        InputStream resourceAsStream = TestPool.class.getClassLoader().getResourceAsStream("dbcp.properties");

        InputStream inputStream = new FileInputStream("D:\\java\\run\\maven-jdbc\\src\\main\\resources\\dbcp.properties");

        System.out.println(resourceAsStream);

        properties.load(inputStream);

        System.out.println(inputStream);

        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();

        String sql = "select * from hero";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

        System.out.println(dataSource.getPassword());

    }

    /**
     * C3P0 数据库连接池
     * @throws Exception
     */
    @Test
    public void test04() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Connection connection = comboPooledDataSource.getConnection();

        System.out.println(connection);


    }
}
