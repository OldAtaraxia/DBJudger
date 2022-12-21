package Driver;

import Config.DbConfig;

import java.sql.*;

public class MySQLDriver implements DbDriver {
    @Override
    public Connection createConnection(String user, String passwd) throws SQLException {
        int a = Integer.MAX_VALUE;
        return DriverManager.getConnection(DbConfig.jdbc_url, user, passwd);
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public int createDbUpdate(Connection connection, String sql) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeUpdate(sql);
    }

    @Override
    public ResultSet createDbQuery(Connection connection, String sql) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery(sql);
    }

    @Override
    public void beginTrans(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
    }

    @Override
    public void commitTrans(Connection connection) throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    @Override
    public void rollbackTrans(Connection connection) throws SQLException {
        connection.rollback();
    }
}
