package innlevering2;

import java.sql.PreparedStatement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Time;

public class RegTreningCtrl extends DBConnect{

  private PreparedStatement regStatement;
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  public void regTrening(Date dato, int varigetMinutter, int personligForm, int prestasjon, String notat){
    try{
      regStatement = connection.prepareStatement("INSERT INTO Treningsøkt (Dato, Varighet, PersonligForm, Prestasjon, Notat) VALUES (?, ?, ?, ?, ?)");
    }
    catch(Exception e){
      System.out.println("db error during prepare of insert into Treningsøkt");
    }
    try{
      regStatement.setString(1, sdf.format(dato));
      //Grunnet java.sql.Time benytter UTC som tidsformat trekkes en time fra
      //for å få korrekt lagring
      regStatement.setTime(2, new Time((long) varigetMinutter*60*1000 - 60*60*1000));
      regStatement.setInt(3, personligForm);
      regStatement.setInt(4, prestasjon);
      regStatement.setString(5, notat);
      regStatement.execute();
      System.out.println("new Treningsøkt saved to db");
    }
    catch(Exception e){
      System.out.println("db error during insert of Treningsøkt dato="+dato+" notat="+notat);
      throw new RuntimeException(e);
    }
  }
}
