package innlevering2;

import java.sql.DriverManager;
import java.sql.Connection;

public abstract class DBConnect{
  protected Connection connection;

  public DBConnect(){
    connectToDB();
  }

  public void connectToDB() {
    try{
      Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
      String user = System.getenv("DB_TRENINGSDAGBOK_USER");
      String password = System.getenv("DB_TRENINGSDAGBOK_PASS");
      connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Treningsdagbok?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
      System.out.println("Connection established");
    }
    catch(Exception e){
      throw new RuntimeException("Unable to connect", e);
    }
  }
}
