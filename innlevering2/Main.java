package innlevering2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Main{
	private Scanner input = new Scanner(System.in);
	
	
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
			System.out.println("Velg en av kommandoene over ^")
		}
	}
	
	public void createExersice() {
		// gå inn til å lage / tilbake
		System.out.println("skriv inn følgende felter separert med komma og mallomrom: ");
		System.out.println("bla, bla, bla, bla, blabla");
		System.out.println("Eller skriv 'tilbake' for å gå tilbake");
		String svar = input.nextLine();
		
	}
	
	public void stringToVars(string) { // skal ikke være void, men må ha ...args ellerno så den kan returnere ulikt antall variabler.
		return string.spilt(", ")
	}
	
	public void getExercises() {
		// Vise treningsøktene basert på id
		// Man kan velge 1 id, antall treningsøkter bakover og innen et gitt tidsintervall
	}
	
	
	public static void main(String[] args) throws Exception{
		Main main = new Main();
		velkommen();
		
		RegTreningCtrl regTreningCtrl = new RegTreningCtrl();
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.JANUARY, 22, 15, 20);
		regTreningCtrl.regTrening(cal.getTime(), 60, 8, 8, "God trening");
	}
}
