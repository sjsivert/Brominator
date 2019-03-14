package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimeZone;
import java.util.Calendar;

public class getExcercisesByGroup extends DBConnect{

  private PreparedStatement regStatement;

  public String getByID(String id){
    Integer idInt = Integer.parseInt(id);
    regStatement = connection.prepareStatement("SELECT * FROM Øvelse NATURAL JOIN ØvelsesGruppe NATURAL JOIN ØvelseIØvelsesgruppe WHERE ØvelseID = ?");
    regStatement.setInt(1, idInt);
    ResultSet result = regStatement.executeQuery();
    
    while (result.next()) {
    	
    }
  }
  public boolean saveObject(Workout workout){
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

  public Workout getObject(String Id){
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
}
