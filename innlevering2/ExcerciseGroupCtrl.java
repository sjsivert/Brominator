package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimeZone;
import java.util.Calendar;

public class ExcerciseGroupCtrl extends DBConnect{

  private PreparedStatement regStatement;

  public String getByID(String id) throws SQLException{
    Integer idInt = Integer.parseInt(id);
    regStatement = connection.prepareStatement("SELECT * FROM ØvelsesGruppe NATURAL JOIN ØvelseIØvelsesgruppe INNER JOIN Øvelse on (ØvelseIØvelsesgruppe.ØvelseID=Øvelse.ØvelseID) where ØvelsesgruppeID=?");
    regStatement.setInt(1, idInt);
    ResultSet result = regStatement.executeQuery();

    String stringResult = "ØVELSER: \n";
    while (result.next()) {
    	String str = String.format("Navn: %s. Beskrivelse: %s \n", result.getString("Øvelse.Navn"), result.getString("Beskrivelse") + "\n");

    	stringResult = stringResult + str;
    }
    return stringResult;
  }

  public String getAll() {
	 ResultSet res;
	 String result = "";
	 try {
		regStatement = connection.prepareStatement("SELECT * FROM ØvelsesGruppe;");
		res = regStatement.executeQuery();
		 while (res.next()) {
			 result += "ID: "+ Integer.toString(res.getInt("ØvelsesgruppeID")) + " Navn: " + res.getString("Navn") + "\n";
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Noe gikk galt");
	}

	return result;


  }


  public String createGroup(String name) {
	  // TODO: Sjekke at gruppen ikke finnes fra før
	  try {
		regStatement =  connection.prepareStatement("INSERT INTO ØvelsesGruppe (Navn) VALUES (?)");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Klarte ikke lage SQL statement");
	}
	  try {
		regStatement.setString(1, name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("klarte ikke sette inn variabel i SQL statement");
	}
	  try {
		regStatement.execute();
		return "Gruppe laget";

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Klarte ikke kjøre SQL Statement");
	}
	return "Noe gikk galt";
  }

}
