import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseDataParser extends DataParser{
    String readData(String[] sourceArgs){
        try {
            Database database = new Database(sourceArgs[0], sourceArgs[1], sourceArgs[2], sourceArgs[3]);
            String data = "";
            Connection cnt = database.getConnection();
            String query = "SELECT * FROM " + sourceArgs[4];
            PreparedStatement ps = cnt.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int ctr = 1 ; ctr < rsmd.getColumnCount() ; ctr++) {
                    data += rs.getString(ctr);
                    data += ",";
                }
                data += rs.getString(rsmd.getColumnCount());
                data += "\n";
            }
            return data;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return "";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
    List<List<String>> processData(String data){
        List<List<String>> processed = new ArrayList<List<String>>();
        String[] rows = data.split("\n");

        for (String row : rows) {
            List<String> processedCells = new ArrayList<String>();
            String[] cells = row.split(",");
            for (String cell : cells) {
                processedCells.add(cell);
            }
            processed.add(processedCells);
        }

        return processed;
    }
}

class Database{
    private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private String url;
    private String username;
    private String password;
    private String database;

    public Database(String url, String username, String password, String database){
        this.url = url;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(
                url +
                database + "?autoReconnect=true&useSSL=false",
                username,
                password);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
