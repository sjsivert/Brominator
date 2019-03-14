package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimeZone;
import java.util.Calendar;

public class ExerciseResultsCtrl extends DBConnect{

  private PreparedStatement regStatement;

  public void printResultsInInterval(String date1, String date2){
    try{
      regStatement = connection.prepareStatement("SELECT * FROM Treningsøkt WHERE Dato BETWEEN \"" + date1 + "\" AND \"" + date2 + "\" NATURAL JOIN Øvelse ORDER BY TreningsøktID DESC");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      ResultSet rs = regStatement.executeQuery();
      Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
      while (rs.next()) {
        System.out.println(rs.getString("Dato") +
                        rs.getTime("Varighet", tzCal) + rs.getInt("PersonligForm") +
                        rs.getInt("Prestasjon") + rs.getString("Notat") +
                        rs.getString("Navn") + rs.getString("Beskrivelse") +
                        rs.getBoolean("HarApparat") + rs.getInt("ApparatID"));
      }
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
