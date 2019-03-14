package innlevering2;

public class Main{

  public WorkoutCtrl workoutCtrl = new WorkoutCtrl();

  public static void main(String[] args) throws Exception{
    Main main = new Main();
    try{
      Workout workout = new Workout("2019-02-04 10:23", "70", "5", "8", "Veldig god innsats");
      main.workoutCtrl.saveObject(workout);
      workout = main.workoutCtrl.getObject("1");
      System.out.println(workout);
    }
    catch(IllegalArgumentException e){
      System.out.println(e.getLocalizedMessage());
    }
  }
}
