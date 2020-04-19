package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author peigen
 * Servlet 相当于最早期的action
 */
@WebServlet(name = "MyFirstServlet", urlPatterns = "/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
    private Connection conn = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //region 初始化数据库连接
       /* try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databasename=BY_CasamielWebSite","sa","123456");
            if(conn!=null)
            {
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        //endregion
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String passsWord = request.getParameter("passsWord");
        String realName = request.getParameter("realName");
        String mobile = request.getParameter("mobile");
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        conn = DBUtil.getConnection();
        if (conn != null) {
            try {
                String sql = " INSERT INTO [dbo].[member] ([UserName],[Password],[RealName],[Mobile],[Status],[CreateTime]) values (?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, userName);
                ps.setString(2, passsWord);
                ps.setString(3, realName);
                ps.setString(4, mobile);
                ps.setInt(5, 1);
                ps.setTimestamp(6, createTime);
                ps.executeUpdate();
                ps.close();
                DBUtil.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();//尤其注意这个打印，生产环境中不能有这些。会导致内存吃满 服务器卡死
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        conn = DBUtil.getConnection();
        if (conn != null) {
            try {
                //region 调用存储过程

                //CallableStatement callableStatement = conn.prepareCall("{call findAllMember()}");
                //ResultSet callRs = callableStatement.executeQuery();
                //while (callRs.next()) {
                //    System.out.println("[MemberId]= " + callRs.getInt("MemberId"));
                //}
                //endregion

                Statement statement = conn.createStatement();

                String sql = "SELECT * FROM member WHERE MemberId=1";
                ResultSet resultSet = statement.executeQuery(sql);
                List<String> list = new ArrayList<String>();
                list.add("武汉加油");
                list.add("中国加油");
                list.add("王根培加油");

                for (String s : list) {
                    System.out.println(s);
                }
                list.forEach(item -> {
                    System.out.println(item);
                });
                if (resultSet.next()) {
                    System.out.println("[MemberId]= " + resultSet.getInt("MemberId"));
                    System.out.println("[UserName]= " + resultSet.getString("UserName"));
                    System.out.println("[Password]= " + resultSet.getString("Password"));
                    System.out.println("[RealName]= " + resultSet.getString("RealName"));
                    System.out.println("[Mobile]= " + resultSet.getString("Mobile"));
                    System.out.println("[Status]= " + resultSet.getInt("Status"));
                    System.out.println("[CreateTime]= " + resultSet.getTimestamp("CreateTime"));
                } else {
                    System.out.println("查无此人");
                }
                statement.close();
                DBUtil.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        String method = request.getMethod();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("Hello,这是我得第一个Servlet，请求方式是" + method);
        response.getWriter().write("当前系统时间是：" + new Date());
    }


}
