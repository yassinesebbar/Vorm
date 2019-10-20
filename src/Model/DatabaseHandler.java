package Model;
import java.sql.*;
public class DatabaseHandler {

    String url = "jdbc:mysql://MyDB/mySchema";
    String driver = "com.mysql.jdbc.Driver";
    String user = "myName";
    String pws = "myPassword";
    private static Connection conn = null;


    public DatabaseHandler() {}

    private Connection getConnection() {

        if(this.conn == null){

            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pws);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
            return this.conn;
    }

    public ResultSet runSql(String sql) throws SQLException {
        Statement sta = conn.createStatement();
        return sta.executeQuery(sql);
    }

    @Override
    protected void finalize() throws Throwable {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}


//public class Main {
//
//    public static void main(String []args){
//
//        // to read url, username, password from configuration file
//        Properties configFile = new Properties();
//        String url = "";
//        String user_name = "";
//        String password = "";
//        String database = "";
//        try {
//            configFile.load(Main.class.getClassLoader().getResourceAsStream("config.properties"));
//            url = configFile.getProperty("url");
//            database = configFile.getProperty("database");
//            user_name = configFile.getProperty("user_name");
//            password = configFile.getProperty("password");
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//
//        //instantiate a DB object
//        DB db = new DB(url + database, user_name, password);
//        try {
//            ResultSet rs = db.runSql("select * from user");
//            while(rs.next()){
//                System.out.println(rs.getString("user_name"));
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}