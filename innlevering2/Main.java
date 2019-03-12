package innlevering2;

public class Main{

  public ExerciseCtrl exerciseCtrl = new ExerciseCtrl();

  public static void main(String[] args) throws Exception{
    Main main = new Main();
    try{
      Exercise exercise = new Exercise("2019-02-04 10:23", "70", "5", "8", "Veldig god innsats");
      main.exerciseCtrl.saveObject(exercise);
    }
    catch(IllegalArgumentException e){
      System.out.println(e.getLocalizedMessage());
    }
  }
}
