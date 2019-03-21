package innlevering2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private ExcerciseGroupCtrl excerciseGroupCtrl = new ExcerciseGroupCtrl();
    private ExerciseCtrl exerciseCtrl = new ExerciseCtrl();
    private WorkoutCtrl workoutCtrl = new WorkoutCtrl();
    private DeviceCtrl deviceCtrl = new DeviceCtrl();
    private Scanner input = new Scanner(System.in);
    private ExerciseInWorkoutCtrl exerciseInWorkoutCtrl = new ExerciseInWorkoutCtrl();

    //private String state = new String;
    public void skrevetFeil() {
	System.out.println("Du kan ha skrevet noe feil. Se beskrivelse over ^");
    }

    public ArrayList<String> stringToList(String string) { // skal ikke være void, men må ha ...args ellerno så den kan returnere ulikt antall variabler.
	if (string.contains(", ")) {
	    ArrayList<String> l = new ArrayList<>(Arrays.asList(string.split(", ")));
	    return l;
	}
	else {
	    return null; //??
	}
    }

    public void registerDevice() {
	System.out.print("Skriv inn navn: ");
	String name = input.nextLine();
	System.out.print("Skriv inn beskrivelse: ");
	String description = input.nextLine();
	try {
	    deviceCtrl.regDevice(name, description);
	    System.out.println("Apparat registrert!");
	}
	catch (Exception e) {
	    System.out.println(e);
	    System.out.println("noe gikk galt");
	}
	velkommen();
    }

    public void getExerciseByGroup() {
	System.out.println(excerciseGroupCtrl.getAll());
	System.out.print("Skriv inn en øvelsesID: ");
	String id = input.nextLine();
	try {
	    System.out.println(excerciseGroupCtrl.getByID(id));
	}
	catch (Exception e) {
	    System.out.println("Noe gikk galt");
	}
	velkommen();
    }

    public void velkommen() {
	System.out.println("Hva vil du gjøre nå? "
			   + "Vil du 'lage ny treningsøkt', 'lage ny gruppe', 'se treningslogg', 'registrere øvelse' 'finne øvelse i gruppe' eller 'registrere apparat'? Skriv inn ditt valg.");
	String choosing = input.nextLine();

	if (choosing.equals("lage ny treningsøkt")) {
	    createWorkout();
	}
	else if (choosing.equals("se treningslogg")){
	    getExercises();
	}
	else if (choosing.equals("lage ny gruppe")) {
	    createGroup();
	}
	else if (choosing.equals("registrere apparat")) {
	    registerDevice();
	}
	else if (choosing.equals("registrere øvelse")) {
	    registerExercise();
	}
	else if (choosing.equals("finne øvelse i gruppe")) {
	    getExerciseByGroup();
	}
	else {
	    skrevetFeil();
	}
	velkommen();
    }

    private void registerExercise() {
	System.out.print("Skriv inn navn: ");
	String name = input.nextLine();
	System.out.print("Skriv inn beskrivelse: ");
	String description = input.nextLine();
	System.out.print("Har den et apparat?: ");
	String answer = input.nextLine();
	boolean harApparat = false;
	if (answer.equals("ja")) {
	    harApparat = true;
	    System.out.println(deviceCtrl.getAllDevices());
	    System.out.print("Skriv inn apparat_id: ");
	    String apparatId = input.nextLine();
	    try {
		exerciseCtrl.regExercise(name, description, harApparat, apparatId);
		System.out.println("Øvelse registrert!");
	    }
	    catch (Exception e) {
		System.out.println(e);
		System.out.println("noe gikk galt");
	    }
	} else {
	    try {
		exerciseCtrl.regExercise(name, description, harApparat);
		System.out.println("Øvelse registrert!");
	    }
	    catch (Exception e) {
		System.out.println(e);
		System.out.println("noe gikk galt");
	    }
	}
	velkommen();
    }

    private void createGroup() {
	// TODO Auto-generated method stub
	System.out.print("Skriv inn navn på Treningsgruppen (EKS: Bein, Armer, rygg etc): ");
	String svar = input.nextLine();
	ExcerciseGroupCtrl groupCtrl = new ExcerciseGroupCtrl();
	try {
	    System.out.println(groupCtrl.createGroup(svar));
	} catch (Exception e) {
	    System.out.println(e);
	}
	velkommen();
    }

    private void registerExercisesToWorkout(String workoutId) {
	while (true) {
	    System.out.println(exerciseCtrl.getAllExercises());
	    System.out.print("Skriv inn id på øvelsen du vil legge til (trykk kun enter hvis du er ferdig): ");
	    String exerciseId = input.nextLine();
	    if (exerciseId.equals("")) {
		break;
	    }
	    System.out.print("Skriv antall kilo: ");
	    String antall_kilo = input.nextLine();
	    System.out.print("Skriv antall reps: ");
	    String antall_reps = input.nextLine();
	    System.out.print("Skriv antall set: ");
	    String antall_sett = input.nextLine();
	    System.out.print("------------------------------------------------");
	}

    }

    public void createWorkout() {
	// gå inn til å lage / tilbake
	// ArrayList<String> retursvar = new ArrayList<String>();
	System.out.println("skriv inn følgende felter separert med komma og mallomrom: ");
	System.out.println("Dato, Varighet, Personlig Form, Prestasjon, Notat");
	System.out.println("(Format på tid er: 'yyyy-mm-dd hh:mm')");
	System.out.println("(Tiden på økten gis i antall minutter)");
	System.out.println("----> Vil du tilbake til hovedmenyen, skriv 'tilbake'");
	String svar = input.nextLine();
	ArrayList<String> retursvar = this.stringToList(svar); // får null hvis uten ','
	if (svar.equals("tilbake") || svar.equals("Tilbake")) {
	    velkommen();
	}
	else if (retursvar.size() == 5){ // Må endres
	    System.out.println("Er dette informasjonen du vil sende inn til databasen?");
	    for (String i : retursvar) {
		System.out.println(i);
	    }
	    // validere og sende retursvar til backend for å lage ny exercise
	    String validering = input.nextLine();
	    if (validering.equals("ja")) {
		try {
		    // TODO å lage exercise
		    Workout workout = new Workout(retursvar.get(0), retursvar.get(1), retursvar.get(2), retursvar.get(3), retursvar.get(4));
		    String id = this.workoutCtrl.saveWorkout(workout);
		    registerExercisesToWorkout(id);
		} catch(Exception e) {
		    System.out.println(e);
		    System.out.println("Fikk ikke laget treningsøkt, prøv på nytt");
		    createWorkout();
		}
	    }
	    else if (validering.equals("nei")){
		velkommen();
	    }
	    else {
		System.out.println("Skriv 'ja' eller 'nei'");
	    }
	    velkommen();
	}
	else {
	    System.out.println("Feil antall argumenter");
	    createWorkout();
	}
    }

    public void displayAllExercises() {
	System.out.println(this.workoutCtrl.getNPreviousWorkouts("9999"));
    }

    public void displayNExercises(String n) {
	this.workoutCtrl.getNPreviousWorkouts(n);
    }

    public void displayOneExercise() {

    }

    public void getExercises() {
	// Vise treningsøktene basert på id
	// Man kan velge 1 id, antall treningsøkter bakover og innen et gitt tidsintervall
	System.out.println("For å se på én av dem, skriv inn ID");
	System.out.println("For å se de n sistetreningsøktene, skriv skriv 'n'.");
	System.out.println("For å se treningsøktene i en gitt tidsperiode, skriv inn 'fra'-'til'");
	System.out.println("Form på tid er: 'yyyy-mm-dd hh:mm'"); //TODO: dobbeltsjekke at dette stemmer
	System.out.println("----> Vil du tilbake til hovedmenyen, skriv 'tilbake'");
	String svar = this.input.nextLine();

	if (svar.equals("tilbake")) {
	    velkommen();
	}
	else if (svar.equals("n")) {
	    String tall = this.input.nextLine();
	    if (svar.matches("[0-9]+") && svar.length() > 0) {
		// hent ut de 'svar' siste øktene (eller færre hvis det er færre økter enn 'svar')
		displayNExercises(svar);
	    }
	}


	else if (svar.length()==14) {
	    // én treningsøkt
	    // teste om ikke det er en valid date med en treningsøkt
	    // hente ut treningsøkten
	    // displaye det med litt mer info kanskje?

	}
	else if (svar.length()==29) {
	    // teste om ikke de er på valid date form (må ikke være dato til treningsøkter)
	    // hente ut de imellom
	    //displaye det med litt mer info kanskje?
	}
	else {
	    skrevetFeil();
	}
	getExercises();
    }

    //	public void manager() {
    //		if (state.equals("velkommen"){
    //			velkommen();
    //		}
    //		if (state.equals("createExercise")) {
    //			createExercise();
    //		}
    //	}

    public void start() {
	System.out.println("Hei og velkommen til din treningsdagbok!");
	System.out.println(exerciseInWorkoutCtrl.getOverallStats());
	velkommen();
    }

    public static void main(String[] args) throws Exception{
	Main main = new Main();
	main.start();
	System.out.println("Dato, Varighet, Personlig Form, Prestasjon, Notat");
	try{
	    Workout workout = new Workout("2019-02-04 10:23", "70", "5", "8", "Veldig god innsats");
	    main.workoutCtrl.saveWorkout(workout);
	    workout = main.workoutCtrl.getWorkout("1");
	    System.out.println(workout);
	}
	catch(IllegalArgumentException e){
	    System.out.println(e.getLocalizedMessage());
	}
    }
}
