package innlevering2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimeZone;
import java.util.Calendar;

public class ExerciseInWorkoutCtrl extends DBConnect{

    private PreparedStatement getStatement;
    private PreparedStatement regStatement;

    public String getResultsInInterval(String exerciseId, String date1, String date2){
	try{
	    getStatement = connection.prepareStatement("select Navn, Dato, kilo, antallsett, antallreps from Treningsøkt natural join øvelseItreningsøkt natural join øvelse where (dato between '" + date1 + "' and '" + date2 + "') and ØvelseID=" + exerciseId + " ORDER BY Dato ASC");
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
		    "Antall kilo: " + rs.getInt("kilo") + "\n" +
		    "Antall sett: " + rs.getInt("antallsett") + "\n" +
		    "Antall reps: " + rs.getInt("antallreps") + "\n";
	    }
	    return output;
	}
	catch(Exception e){
	    throw new RuntimeException(e);
	}
    }

    public String getOverallStats(){
	try{
	    getStatement = connection.prepareStatement("SELECT Kilo, AntallSett, AntallReps FROM ØvelseITreningsøkt");
	}
	catch(Exception e){
	    throw new RuntimeException(e);
	}
	try{
	    ResultSet rs = getStatement.executeQuery();
	    String output = "";
	    int totKilos = 0;
	    int totSets = 0;
	    int totReps = 0;
	    while (rs.next()) {
		totKilos +=  rs.getInt("Kilo");
		totSets += rs.getInt("AntallSett");
		totReps += rs.getInt("AntallReps");
	    }
	    output += "-----------------------------" +
                "Total statistikk" + "\n" +
                "Total antall kilo: " + totKilos + "\n" +
                "Total antall sett: " + totSets + "\n" +
                "Total antall reps: " + totReps;
	    return output;
	}
	catch(Exception e){
	    throw new RuntimeException(e);
	}
    }

    public boolean regExerciseInWorkout(String treningsøktId, String øvelseId, String kilo, String antallSett, String antallReps){
	try{
	    regStatement = connection.prepareStatement("INSERT INTO ØvelseITreningsøkt (TreningsøktID, ØvelseID, Kilo, AntallSett, AntallReps) VALUES (?, ?, ?, ?, ?)");
	}
	catch(Exception e){
	    throw new RuntimeException(e);
	}
	try{
	    regStatement.setInt(1, Integer.parseInt(treningsøktId));
	    regStatement.setInt(2, Integer.parseInt(øvelseId));
	    regStatement.setInt(3, Integer.parseInt(kilo));
	    regStatement.setInt(4, Integer.parseInt(antallSett));
	    regStatement.setInt(5, Integer.parseInt(antallReps));
	    regStatement.execute();
	}
	catch(Exception e){
	    throw new RuntimeException(e);
	}
	return true;
    }
}
