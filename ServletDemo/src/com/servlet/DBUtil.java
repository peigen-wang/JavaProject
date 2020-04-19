package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author peigen
 */
public class DBUtil {
    private static String user ="sa";
    private static String password = "123456";
    private static String url = "jdbc:sqlserver://localhost:1433;databasename=BY_CasamielWebSite";
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection conn = null;

    /**
     * 获取数据库连接
     * @return Connection
     */
    public static Connection getConnection(){
        try{
            // 加载驱动
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void closeConnection(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                System.out.println("数据库关闭异常");
                e.printStackTrace();
            }
        }
    }
}
