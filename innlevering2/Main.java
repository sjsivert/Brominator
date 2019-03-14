package innlevering2;

import java.util.List;

public class Main{

  public WorkoutCtrl workoutCtrl = new WorkoutCtrl();

  public static void main(String[] args) throws Exception{
    Main main = new Main();
    try{
      Workout workout = new Workout("2019-02-04 10:23", "70", "5", "8", "Veldig god innsats");
      main.workoutCtrl.saveWorkout(workout);
      workout = new Workout("2019-02-05 12:23", "90", "8", "9", "Supergod innsats");
      main.workoutCtrl.saveWorkout(workout);
      workout = new Workout("2019-02-10 14:00", "50", "7", "4", "Tja innsats");
      main.workoutCtrl.saveWorkout(workout);

      List<Workout> workouts = main.workoutCtrl.getNPreviousWorkouts("2");
      for(int i=0; i<workouts.size(); i++){
        System.out.println(workouts.get(i));
      }
    }
    catch(IllegalArgumentException e){
      System.out.println(e.getLocalizedMessage());
    }
  }
}
