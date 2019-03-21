package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeviceCtrl extends DBConnect{

  private PreparedStatement regStatement;
  private PreparedStatement getStatement;

  public boolean regDevice(String Navn, String HvordanBruke){
    try{
      regStatement = connection.prepareStatement("INSERT INTO Apparat (Navn, HvordanBruke) VALUES (?, ?)");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      regStatement.setString(1, Navn);
      regStatement.setString(2, HvordanBruke);
      regStatement.execute();
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    return true;
  }

  public String getAllDevices(){
    try{
      getStatement = connection.prepareStatement("SELECT * FROM Apparat ORDER BY ApparatID DESC");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      ResultSet rs = getStatement.executeQuery();
      String output = "";
      while (rs.next()) {
        output += "-----------------------------" +
                  "ApparatID: " + rs.getInt("ApparatID") + "\n" +
                  "Navn: " + rs.getString("Navn") + "\n" +
                  "Hvordan bruke: " + rs.getString("HvordanBruke") + "\n";
      }
      return output;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
