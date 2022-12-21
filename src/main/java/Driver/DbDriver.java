package Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbDriver {
    public Connection createConnection(String user, String passwd) throws SQLException;
    public void closeConnection(Connection connection) throws SQLException;
    public int createDbUpdate(Connection connection, String sql) throws SQLException;
    public ResultSet createDbQuery(Connection connection, String sql) throws SQLException;
    public void beginTrans(Connection connection) throws SQLException;
    public void commitTrans(Connection connection) throws SQLException;
    public void rollbackTrans(Connection connection) throws SQLException;
}
