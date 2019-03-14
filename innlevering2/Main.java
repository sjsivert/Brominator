package innlevering2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Main{
	private Scanner input = new Scanner(System.in);
	//private String state = new String;

	public void skrevetFeil() {
		System.out.println('Velg en av kommandoene over ^');
	}
	public void velkommen() {
		System.out.println("Hei og velkommen til din treningsdagbok!"
				+ "Vil du 'lage ny treningsøkt' eller 'se treningslogg'");
		String choosing = input.nextLine();
		if (choosing.equals("lage ny treningsøkt")) {
			createExersice();
		}
		elif (choosing.equals("se treningslogg")) {
			getExercises(); // Må lages
		}
		else {
			skrevetFeil();
		}
	}

	public void createExersice() {
		// gå inn til å lage / tilbake
		// ArrayList<String> retursvar = new ArrayList<String>();
		System.out.println("skriv inn følgende felter separert med komma og mallomrom: ");
		System.out.println("bla, bla, bla, bla, blabla");
		System.out.println("Eller skriv 'tilbake' for å gå tilbake");
		String svar = input.nextLine();
		retursvar = stringToList(svar); //??
//		if (svar.contains(',')) {
//			retursvar = svar.split(',')
//		}
		if (svar.equals('tilbake') || svar.equals('Tilbake')) {
			velkommen();
		}
		elif (retursvar.size() == 12) { // Må endres
			// validere og sende retursvar til backend for å lage ny exercise
			try {
			    // å lage exercise
			} catch(RuntimeException e) {
			    System.out.println('oi, noe gikk visst galt, prøv på nytt');
			    createExercise();
			}
			velkommen();
		}
		else {
			skrevetFeil();
		}

	}

	public ArrayList<String> stringToList(String string) { // skal ikke være void, men må ha ...args ellerno så den kan returnere ulikt antall variabler.
		if (string.contains(', ')) {
			return Arrays.asList(string.spilt(", "));
		}
		else {
			return null; //??
		}
	}

	public void displayAllExercises() {
		// Viser bare tiden treningøkta var, evt tittel (?)
	}

	public void displaySomeExercises() {
		// viser et par fler detaljer enn displayAllExercises
	}

	public void getExercises() {
		// Vise treningsøktene basert på id
		// Man kan velge 1 id, antall treningsøkter bakover og innen et gitt tidsintervall

		System.out.println('Dette er alle treningsøktene:');
		displayAllExercises();
		System.out.println('For å se de n sistetreningsøktene, skriv skriv inn antall n.');
		System.out.println('For å se på én av dem, skriv inn når treningsøkten var.');
		System.out.println('For å se treningsøktene i en gitt tidsperiode, skrif inn "fra"-"til"');
		System.out.println('Form på tid er: "yy-mm-dd hh:mm"'); //TODO: Endre dette riktig da
		System.out.println('----> Vil du tilbake til hovedmenyen, skriv "tilbake"');
		String svar = self.input.nextLine();
		if (svar.equals('tilbake')) {
			velkommen();
		}
		elif (svar instanceof Integer) {
			// hent ut de 'svar' siste øktene (eller færre hvis det er færre økter enn 'svar')
			// display dem med litt mer info kanskje?
		}
		elif (svar.length()==14) {
			// teste om ikke det er en valid date med en treningsøkt
			// hente ut treningsøkten
			// displaye det med litt mer info kanskje?
		}
		elif (svar.length()==29) {
			// teste om ikke de er på valid date form (må ikke være dato til treningsøkter)
			// hente ut de imellom
			//displaye det med litt mer info kanskje?
		}
		else {
			skrevetFeil();
		}
	}


//	public void manager() {
//		if (state.equals('velkommen'){
//			velkommen();
//		}
//		if (state.equals('createExercise')) {
//			createExercise();
//		}
//	}

	public static void main(String[] args) throws Exception{
		Main main = new Main();
		velkommen();

		RegTreningCtrl regTreningCtrl = new RegTreningCtrl();
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.JANUARY, 22, 15, 20);
		regTreningCtrl.regTrening(cal.getTime(), 60, 8, 8, "God trening");
	}
}
