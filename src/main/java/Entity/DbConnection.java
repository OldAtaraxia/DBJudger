package Entity;

import Config.DbConfig;
import Mock.User;
import com.sun.corba.se.pept.transport.ConnectionCache;

import java.sql.Connection;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Persist the mapping relationship between users and database connections in memory
 */
public class DbConnection {
    private Map<User, Connection> connections = new HashMap<>(DbConfig.UserNums);

    public DbConnection() {

    }

    public void addConnections(User user, Connection connection) {
        this.connections.put(user, connection);
    }

    public void removeConnections(User user) {
        this.connections.remove(user);
    }

    public Connection getConnection(User user) {
        return connections.get(user);
    }

}
