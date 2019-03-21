package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimeZone;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

public class WorkoutCtrl extends DBConnect{

  private PreparedStatement regStatement;
  private PreparedStatement getStatement;

  public boolean saveWorkout(Workout workout){
    try{
      regStatement = connection.prepareStatement("INSERT INTO Treningsøkt (Dato, Varighet, PersonligForm, Prestasjon, Notat) VALUES (?, ?, ?, ?, ?)");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      regStatement.setString(1, workout.getDate());
      regStatement.setTime(2, workout.getDuration());
      regStatement.setInt(3, workout.getShape());
      regStatement.setInt(4, workout.getPerformance());
      regStatement.setString(5, workout.getNote());
      regStatement.execute();
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    return true;
  }

  public Workout getWorkout(String Id){
    try{
      regStatement = connection.prepareStatement("SELECT Dato, Varighet, PersonligForm, Prestasjon, Notat FROM Treningsøkt WHERE TreningsøktID = ?");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      regStatement.setInt(1, Integer.parseInt(Id));
      ResultSet rs = regStatement.executeQuery();
      Workout workout = null;
      Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
      while (rs.next()) {
        workout = new Workout(rs.getString("Dato"),
                        rs.getTime("Varighet", tzCal), rs.getInt("PersonligForm"),
                        rs.getInt("Prestasjon"), rs.getString("Notat"));
      }
      return workout;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public String getNPreviousWorkouts(String n){
    try{
      regStatement = connection.prepareStatement("SELECT * FROM (SELECT * FROM Treningsøkt ORDER BY TreningsøktID DESC LIMIT ?) AS AllRows ORDER BY Dato ASC");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      getStatement.setInt(1, Integer.parseInt(n));
      ResultSet rs = getStatement.executeQuery();
      Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
      String output = "";
      while (rs.next()) {
        output += "-----------------------------" +
                  rs.getString("Dato").substring(0, 16) + "\n" +
                  "Varighet: " + rs.getTime("Varighet", tzCal).toString().substring(0, 5) + "\n" +
                  "Personlig form: " + rs.getInt("PersonligForm") + "\n" +
                  "Prestasjon: " + rs.getInt("Prestasjon") + "\n" +
                  "Notat: " + rs.getString("Notat") + "\n";
      }
      return output;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public String getAllWorkouts(){
    try{
      getStatement = connection.prepareStatement("SELECT * FROM Treningsøkt ORDER BY Dato ASC");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      ResultSet rs = getStatement.executeQuery();
      Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
      String output = "";
      while (rs.next()) {
        output += "-----------------------------" +
                  rs.getString("Dato").substring(0, 16) + "\n" +
                  "ID: " + rs.getInt("TreningsøktID") + "\n" +
                  "Varighet: " + rs.getTime("Varighet", tzCal).toString().substring(0, 5) + "\n" +
                  "Personlig form: " + rs.getInt("PersonligForm") + "\n" +
                  "Prestasjon: " + rs.getInt("Prestasjon") + "\n" +
                  "Notat: " + rs.getString("Notat") + "\n";
      }
      return output;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
