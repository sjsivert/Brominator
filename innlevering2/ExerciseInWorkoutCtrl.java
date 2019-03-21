package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimeZone;
import java.util.Calendar;

public class ExerciseInWorkoutCtrl extends DBConnect{

  private PreparedStatement getStatement;

    public String getResultsInInterval(String exerciseId, String date1, String date2){
    try{
	getStatement = connection.prepareStatement("select Navn, Dato, kilo, antallsett, antallreps from Treningsøkt natural join øvelseItreningsøkt natural join øvelse where (dato between " + date1 + " and " + date2 + ") and ØvelseID=" + exerciseId + " ORDER BY Dato ASC");
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
	      rs.getString("Navn") + "\n" +
	      rs.getString("Dato").substring(0, 16) + "\n" +
	      "Antall kilo: " + rs.getBoolean("kilo") + "\n" +
	      "Antall sett: " + rs.getBoolean("antallsett") + "\n" +
	      "Antall reps: " + rs.getBoolean("antallreps") + "\n";
      }
    return output;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
