package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimeZone;
import java.util.Calendar;

public class ExerciseInWorkoutCtrl extends DBConnect{

  private PreparedStatement getStatement;

  public String getResultsInInterval(String date1, String date2){
    try{
      getStatement = connection.prepareStatement("SELECT * FROM ((SELECT * FROM Treningsøkt WHERE Dato BETWEEN '" + date1 + "' AND '" + date2 + "') AS Treningsøkter NATURAL JOIN Øvelse) ORDER BY Dato DESC");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      String output = "";
      ResultSet rs = getStatement.executeQuery();
      Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
      while (rs.next()) {

              output += "-----------------------------" +
                        rs.getString("Dato").substring(0, 16) + " " + rs.getString("Navn") + "\n" +
                        "Varighet: " + rs.getTime("Varighet", tzCal).toString().substring(0, 5) + "\n" +
                        "Personlig form: " + rs.getInt("PersonligForm") + "\n" +
                        "Prestasjon: " + rs.getInt("Prestasjon") + "\n" +
                        "Notat: " + rs.getString("Notat") + "\n" +
                        "Øvelsesbeskrivelse: " + rs.getString("Beskrivelse") + "\n" +
                        "HarApparat: " + rs.getBoolean("HarApparat") + "\n" +
                        "ApparatID: " + rs.getInt("ApparatID") + "\n";
      }
    return output;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
