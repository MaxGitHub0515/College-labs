//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.*;


// Wskazowki
// static means the method belongs to the class rather than instances of the class.
//

// ||||| 1. Base:


public class Silnia {

	private static long silnia(int n) {
	if(n==0) {
		return 1;
	} else {
		return n*silnia(n - 1);
	}
}

	public static void main(String[] args) {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	System.out.println("Program oblicza n!");
	System.out.println("n=");
	
//		// like try..catch 
		try {
		
			String s = in.readLine();
			
		int n = Integer.parseInt(s);
		if(n>=0) {
			
				long sil = silnia(n);
			
			System.out.println(n+"!="+sil);
				
		} else {
			
		System.out.println("Blad! To nie jest liczba nieujemna");
				
		}
		}
//		
		catch(Exception e) {
			// writing down errors 
			System.out.println("Blad!! Niewlasciwy format danych");
		}
		
	}
}


// ||||| 2. Zmodyfikuj funkcje silnia tak aby silnia byla liczona iteracyjnie(za pomoca petli for lub while ), a nie rekurencyjnie

// Za pomoca petli for

private static long silnia(int n) {
	if(n==0) {
		return 1;
	}
	// iteracja
	long result = 1;
	for(int i = 1; i<=n; i++) {
		resul*=1;
	} return result;
}


/*
 * ||||| 3. dodaj odpowiedni kod aby w przypadku bledy mozna bylo wprowadzic 
 * poniwnie podpowiedz
 */

public static void main(String[] args) {


BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

System.out.println("Program oblicza n!")

boolean sukces = false;
while(!sukces) {
	System.out.println("n=");
	try {
		
		String s = in.readLine();
		
		int n = Integer.parseInt(s);
		if(n>=0) {
			sukces = true;
			long sil = silnia(n);
			System.out.println(n+"!="+sil);
			else {
				
				System.out.println("Blad! To nie jest liczba nieujemna");
				
			}
	} catch (Exception e) {
		
		System.out.println("Blad!! Niewlasciwy format danych");
		sukces = false;
		
	}
}
	}
}


/*
 * ||||| 4. WPROWADZ I URUCHOM PRZKLADOWY PROGRAM OBLICZAJACY POTEGE CALKOWITA LICZBY
 */



