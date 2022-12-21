import Driver.DbDriver;
import Driver.MySQLDriver;
import Entity.DbConnection;
import Mock.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbJudger {
    private DbConnection dbConnection = new DbConnection();
    private DbDriver driver = new MySQLDriver();

    public void userUpdate(User user, String updateSQL) {
        Connection connection = dbConnection.getConnection(user);
        try {
            if (connection == null) {
                String passwd = user.passwd;
                connection = driver.createConnection(user.username, user.passwd);
                dbConnection.addConnections(user, connection);
            }
            driver.createDbUpdate(connection, updateSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet userQuery(User user, String updateSQL) {
        Connection connection = dbConnection.getConnection(user);
        ResultSet resultSet = null;
        try {
            if (connection == null) {
                String passwd = user.passwd;
                connection = driver.createConnection(user.username, user.passwd);
                dbConnection.addConnections(user, connection);
            }
            resultSet = driver.createDbQuery(connection, updateSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public boolean judge(User user) {
        return true;
    }
}
