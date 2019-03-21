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
	public WorkoutCtrl workoutCtrl = new WorkoutCtrl();
	private Scanner input = new Scanner(System.in);

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

	public void velkommen() {
		System.out.println("Hei og velkommen til din treningsdagbok!"
				+ "Vil du 'lage ny treningsøkt' eller 'se treningslogg'? Skriv inn ditt valg.");
		String choosing = input.nextLine();

		if (choosing.equals("lage ny treningsøkt")) {
			createExersice();
		}
		else if (choosing.equals("se treningslogg")){
			getExercises();
		}
		else {
			skrevetFeil();
		}
	}

	public void createExersice() {
		// gå inn til å lage / tilbake
		// ArrayList<String> retursvar = new ArrayList<String>();
		System.out.println("skriv inn følgende felter separert med komma og mallomrom: ");
		System.out.println("Dato, Varighet, Personlig Form, Prestasjon, Notat");
		System.out.println("(Format på tid er: 'yyyy-mm-dd hh:mm')");
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
			if (validering == "ja") {
				try {
				    // TODO å lage exercise
					Workout workout = new Workout(retursvar.get(0), retursvar.get(1), retursvar.get(2), retursvar.get(3), retursvar.get(4));
					this.workoutCtrl.saveWorkout(workout);
				} catch(Exception e) {
						System.out.println("Fikk ikke laget treningsøkt, prøv på nytt");
				    createExersice();
				}
			}
			else if (validering == "nei"){
				velkommen();
			}
			else {
				skrevetFeil();
			}
			

			velkommen();
		}
		else {
			skrevetFeil();
		}
	}

	public void displayAllExercises() {
		this.workoutCtrl.getNPreviousWorkouts("9999");
	}

	public void displaySomeExercises() {
		// viser et par fler detaljer enn displayAllExercises
	}
	
	public void displayOneExercise() {
		
	}

	public void getExercises() {
		// Vise treningsøktene basert på id
		// Man kan velge 1 id, antall treningsøkter bakover og innen et gitt tidsintervall
		System.out.println("Dette er alle treningsøktene:");
		displayAllExercises();
		System.out.println("For å se på én av dem, skriv inn ID-nummer.");
		System.out.println("For å se de n sistetreningsøktene, skriv skriv inn antall n.");
		System.out.println("For å se treningsøktene i en gitt tidsperiode, skriv inn 'fra'-'til'");
		System.out.println("Form på tid er: 'yyyy-mm-dd hh:mm'"); //TODO: dobbeltsjekke at dette stemmer
		System.out.println("----> Vil du tilbake til hovedmenyen, skriv 'tilbake'");
		String svar = this.input.nextLine();

		if (svar.equals("tilbake")) {
			velkommen();
		}
		else if (svar.matches("[0-9]+") && svar.length() > 0) {
			// hent ut de 'svar' siste øktene (eller færre hvis det er færre økter enn 'svar')
			// display dem med litt mer info kanskje?
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
	}

//	public void manager() {
//		if (state.equals("velkommen"){
//			velkommen();
//		}
//		if (state.equals("createExercise")) {
//			createExercise();
//		}
//	}

	public static void main(String[] args) throws Exception{
		Main main = new Main();
		main.velkommen();
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
