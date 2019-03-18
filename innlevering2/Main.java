package innlevering2;

import java.util.List;

public class Main{

  public WorkoutCtrl workoutCtrl = new WorkoutCtrl();
  public ExerciseInWorkoutCtrl exerciseInWorkoutCtrl = new ExerciseInWorkoutCtrl();

  public static void main(String[] args) throws Exception{
    Main main = new Main();
    try{
      String results = main.exerciseInWorkoutCtrl.getResultsInInterval("2018-10-24 10:00", "2018-10-31 12:12");
      String workresult = main.workoutCtrl.getNPreviousWorkouts("2");
      System.out.println(workresult);
    }
    catch(IllegalArgumentException e){
      System.out.println(e.getLocalizedMessage());
    }
  }
}
