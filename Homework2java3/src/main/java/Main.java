import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement prstmt;

    static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    static void disconnect() throws SQLException {
        connection.close();
    }

    static void createDB() throws SQLException {
        stmt.execute("CREATE TABLE if not exists 'products' " +
                "('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'prodid' INTEGER UNIQUE, " +
                "'title' TEXT NOT NULL, " +
                "'cost' INTEGER)");
    }

    static void writeDB() throws SQLException {

        stmt.execute("DELETE FROM products");

        stmt.execute("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='products'");

        connection.setAutoCommit(false);

        prstmt = connection.prepareStatement("INSERT INTO products (prodid, title, cost)\n" +
                "VALUES (?, ?, ?)");
        for (int i = 0; i < 10000; i++) {
            prstmt.setInt(1, i + 1);
            prstmt.setString(2, "goods" + (i + 1));
            prstmt.setInt(3, (i * 10) + 10);
            prstmt.addBatch();
        }
        prstmt.executeBatch();

        connection.setAutoCommit(true);
    }

    public static void main(String[] args) throws SQLException {
        
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        createDB();
        writeDB();
        disconnect();

    }
}
