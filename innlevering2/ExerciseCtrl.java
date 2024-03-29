package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimeZone;
import java.util.Calendar;

public class ExerciseCtrl extends DBConnect{

  private PreparedStatement regStatement;
  private PreparedStatement getStatement;

  public String regExercise(String Navn, String Beskrivelse, boolean HarApparat, String ApparatID){
    try{
      regStatement = connection.prepareStatement("INSERT INTO Øvelse (Navn, Beskrivelse, HarApparat, ApparatID) VALUES (?, ?, ?, ?)");
      getStatement = connection.prepareStatement("SELECT * FROM Øvelse ORDER BY ØvelseID DESC LIMIT 1");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      regStatement.setString(1, Navn);
      regStatement.setString(2, Beskrivelse);
      regStatement.setBoolean(3, HarApparat);
      regStatement.setInt(4, Integer.parseInt(ApparatID));
      regStatement.execute();
      ResultSet rs = getStatement.executeQuery();
      String id = null;
      while (rs.next()) {
        id = rs.getString("ØvelseID");
      }
      return id;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public String regExercise(String Navn, String Beskrivelse, boolean HarApparat){
    try{
      regStatement = connection.prepareStatement("INSERT INTO Øvelse (Navn, Beskrivelse, HarApparat) VALUES (?, ?, ?)");
      getStatement = connection.prepareStatement("SELECT * FROM Øvelse ORDER BY ØvelseID DESC LIMIT 1");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      regStatement.setString(1, Navn);
      regStatement.setString(2, Beskrivelse);
      regStatement.setBoolean(3, HarApparat);
      regStatement.execute();
      ResultSet rs = getStatement.executeQuery();
      String id = null;
      while (rs.next()) {
        id = rs.getString("ØvelseID");
      }
      return id;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public String getAllExercises(){
    try{
      getStatement = connection.prepareStatement("SELECT * FROM Øvelse ORDER BY ØvelseID DESC");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      ResultSet rs = getStatement.executeQuery();
      String output = "";
      while (rs.next()) {
        output += "-----------------------------" +
                  "ØvelseID: " + rs.getInt("ØvelseID") + "\n" +
                  "Navn: " + rs.getString("Navn") + "\n" +
                  "Beskrivelse: " + rs.getString("Beskrivelse") + "\n" +
                  "Har apparat: " + rs.getString("HarApparat") + "\n" +
                  "ApparatID: " + rs.getString("ApparatID") + "\n";
      }
      return output;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }


}
