import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DbConnectionPoolManager {

    private static final int INITIAL_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 4;
    private static List<DbConnection> connectionsAlreadyInUse;
    private static List<DbConnection> connectionsAvailable;
    private static volatile DbConnectionPoolManager dbConnectionPoolManager = null;

    private DbConnectionPoolManager() {
        connectionsAlreadyInUse = new ArrayList<>();
        connectionsAvailable = new ArrayList<>();

        for (int index = 0; index < INITIAL_POOL_SIZE; index++) {
            connectionsAvailable.add(new DbConnection());
        }
    }

    public static DbConnectionPoolManager getInstance() {

        if (dbConnectionPoolManager == null) {
            synchronized (DbConnectionPoolManager.class) {
                if (dbConnectionPoolManager == null) {
                    dbConnectionPoolManager = new DbConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManager;
    }


    public synchronized DbConnection getDbConnection() {

        if (connectionsAvailable.isEmpty() &&
                connectionsAlreadyInUse.size() < MAX_POOL_SIZE) {
            connectionsAvailable.add(new DbConnection());
        }
        else if (connectionsAlreadyInUse.size() >= MAX_POOL_SIZE) {
            System.out.println("all connections are currently in use! " +
                    "Please try after some time.");
            return null;
        }
        DbConnection connection = connectionsAvailable.removeLast();
        connectionsAlreadyInUse.add(connection);
        System.out.println("Added db connection to used state for " + connection.getId());
        return connection;
    }

    public synchronized void releaseConnection(DbConnection dbConnection) {

        if (Objects.nonNull(dbConnection)) {
            connectionsAlreadyInUse.remove(dbConnection);
            connectionsAvailable.add(dbConnection);
            System.out.println("restored db connection!");
        }
    }
}
