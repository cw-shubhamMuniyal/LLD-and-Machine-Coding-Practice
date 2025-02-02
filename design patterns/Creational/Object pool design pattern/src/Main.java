public class Main {
    public static void main(String[] args) {
        System.out.println("Learning object pool design pattern with example!");
        System.out.println("_________________________________________________");

        DbConnectionPoolManager dbConnectionPoolManager = DbConnectionPoolManager.getInstance();

        DbConnection dbConnection1 = dbConnectionPoolManager.getDbConnection();

        DbConnection dbConnection2 = dbConnectionPoolManager.getDbConnection();
        dbConnection2.connect();

        DbConnection dbConnection3 = dbConnectionPoolManager.getDbConnection();

        DbConnection dbConnection4 = dbConnectionPoolManager.getDbConnection();

        DbConnection dbConnection5 = dbConnectionPoolManager.getDbConnection();

        dbConnectionPoolManager.releaseConnection(dbConnection1);
        dbConnectionPoolManager.releaseConnection(dbConnection2);
        dbConnectionPoolManager.releaseConnection(dbConnection3);
        dbConnectionPoolManager.releaseConnection(dbConnection4);
        dbConnectionPoolManager.releaseConnection(dbConnection5);

    }
}