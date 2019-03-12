package innlevering2;

import java.sql.PreparedStatement;

public class ExerciseCtrl extends DBConnect{

  private PreparedStatement regStatement;

  public boolean saveObject(Exercise exercise){
    try{
      regStatement = connection.prepareStatement("INSERT INTO Treningsøkt (Dato, Varighet, PersonligForm, Prestasjon, Notat) VALUES (?, ?, ?, ?, ?)");
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    try{
      regStatement.setString(1, exercise.getDate());
      regStatement.setTime(2, exercise.getDuration());
      regStatement.setInt(3, exercise.getShape());
      regStatement.setInt(4, exercise.getPerformance());
      regStatement.setString(5, exercise.getNote());
      regStatement.execute();
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    return true;
  }
}
