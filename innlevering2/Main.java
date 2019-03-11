package innlevering2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Calendar;

public class Main{

  public static void main(String[] args) throws Exception{
    RegTreningCtrl regTreningCtrl = new RegTreningCtrl();
    Calendar cal = Calendar.getInstance();
    cal.set(2019, Calendar.JANUARY, 22, 15, 20);
    regTreningCtrl.regTrening(cal.getTime(), 60, 8, 8, "God trening");
  }
}
