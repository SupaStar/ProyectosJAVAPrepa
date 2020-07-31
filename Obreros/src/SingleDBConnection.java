import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Obed Martinez
 */
public class SingleDBConnection {

    private static SingleDBConnection instance;
    private static String dbName, dbUser, dbPass;
    private Connection connection;
    private Statement statement;
    
    private SingleDBConnection() throws ClassNotFoundException {
        SingleDBConnection.dbName = "";
        SingleDBConnection.dbUser = "";
        SingleDBConnection.dbPass = "";
        
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public static SingleDBConnection getInstance(String name, String user,
            String pass) throws ClassNotFoundException {
        if (instance == null) {
            instance = new SingleDBConnection();
        }
        SingleDBConnection.dbName = name;
        SingleDBConnection.dbUser = user;
        SingleDBConnection.dbPass = pass;
        
        return instance;
    }
    
    public boolean open() {
        String url = "jdbc:mysql://localhost:3306/" + SingleDBConnection.dbName;
        try {
            this.connection = DriverManager.getConnection(url, dbUser, dbPass);
            this.statement = this.connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public ResultSet readData(String query) throws SQLException {
        return this.statement.executeQuery(query);
    }
    
    public void updateData(String sql) throws SQLException {
        this.statement.executeUpdate(sql);
    }

    @Override
    protected void finalize() throws Throwable {
        this.connection.close();
        this.statement.close();
        super.finalize();
    }    
}
