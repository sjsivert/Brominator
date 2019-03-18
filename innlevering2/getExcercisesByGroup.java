package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimeZone;
import java.util.Calendar;

public class getExcercisesByGroup extends DBConnect{

  private PreparedStatement regStatement;

  public String getByID(String id) throws SQLException{
    Integer idInt = Integer.parseInt(id);
    regStatement = connection.prepareStatement("SELECT * FROM Øvelse NATURAL JOIN ØvelsesGruppe NATURAL JOIN Øvelsesgruppe WHERE ØvelseID = ?");
    regStatement.setInt(1, idInt);
    ResultSet result = regStatement.executeQuery();
    
    String stringResult = "";
    while (result.next()) {
    	String str = String.format("Name: %s. Description: %s \n", result.getString("Navn"), result.getString("Beskrivelse"));
    	
    	stringResult = stringResult + str;
    }
    return stringResult;
  }

}
