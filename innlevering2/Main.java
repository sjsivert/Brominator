package innlevering2;

import java.util.List;

public class Main{

  public WorkoutCtrl workoutCtrl = new WorkoutCtrl();
  public ExerciseResultsCtrl exerciseResultsCtrl = new ExerciseResultsCtrl();

  public static void main(String[] args) throws Exception{
    Main main = new Main();
    try{
      main.exerciseResultsCtrl.printResultsInInterval("2019-02-05 12:20", "2019-02-07 20:23");
    }
    catch(IllegalArgumentException e){
      System.out.println(e.getLocalizedMessage());
    }
  }
}
