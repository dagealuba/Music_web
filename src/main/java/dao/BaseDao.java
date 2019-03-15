package dao;

import java.sql.*;


//实现增删查改,链接和释放资源
public class BaseDao {
    private Connection connection = null;
    private PreparedStatement pStatement = null;
    private ResultSet resultSet = null;


    //链接
    public boolean getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "199883";
        String url = "jdbc:mysql://localhost:3306/music?useSSL=false&useUnicode=true&characterEncoding=UTF-8";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return true;
    }

    //释放
    public boolean closeResource() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        if (pStatement != null) {
            try {
                pStatement.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        return true;
    }


    //增删改
    public int executeUpdate(String sql, Object[] params) {
        int updateRow = 0;

        if (this.getConnection()) {
            try {
                pStatement = connection.prepareStatement(sql);
                //占位符赋值
                for (int i = 0; i < params.length; ++i) {
                    pStatement.setObject(i + 1, params[i]);
                }

                updateRow = pStatement.executeUpdate();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                this.closeResource();
            }
        }

        return updateRow;
    }

    //查
    public ResultSet ExecuteQuery(String sql, Object[] params) {
        if (this.getConnection()) {
            try {
                pStatement = connection.prepareStatement(sql);
                //占位符赋值
                for (int i = 0; i < params.length; ++i) {
                    pStatement.setObject(i + 1, params[i]);
                }
                //执行
                resultSet = pStatement.executeQuery();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        return resultSet;
    }
}

