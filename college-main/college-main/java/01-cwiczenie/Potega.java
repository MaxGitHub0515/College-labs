


//import java.io.BufferedReader;
//import java.io.InputStreamReader; 
//import java.io.*;

/*
 * ||||| 4. wprowadz i uruchom przkladowy program obliczajacy potege calkowita liczby
 
*/
// 
//public class Potega {
//	private static long potega(int a, int n) {
//		if(n==0) 
//			return 1;
//		else 
//			return a * potega(a, n - 1);
//	}
//	
//	
//	public static void main(String[] args) {
//
//	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	System.out.println("Program obliczajacy a do potegi n");
//	try {
//		int a,n;
//		System.out.println("a=");
//		String s = in.readLine();
//		a = Integer.parseInt(s.trim());
//
//		System.out.println("n=");
//		s = in.readLine();
//		n = Integer.parseInt(s.trim());
//		if(n>=0) {
//			long c = potega(a, n);
//			System.out.println(a+ "do potegi " + n+" = " +c);		
//			
//		} else {
//			System.err.println("Blad!! Wykladnik nie moze byc ujemny");
//		}
//		
//	} catch(Exception e) {
//		System.err.println("Blad!! Niewlasciwy format danych");
//	}
//	
//	}
//}

/* 
 * Testowanie programu
 * Program obliczajacy a do potegi n
a=
5
n=
4
5do potegi 4 = 625
*/


// ||||| 5. Zmodyfikuj funckje potega aby dzialala ona w sposob iteracyjny
// z petla for iteracja
//private static long potega(int a, int n) {
//    long result = 1;
//    for (int i = 0; i < n; i++) {
//        result *= a;
//    }
//    return result;
//}


//||||| 6. Dodaj odpowiedni kod aby w przypadku bledu mozna bylo wprowadzic dane ponownie





//||||| 7. Zmodyfikuj program tak aby poegi dzialaly  na liczbach rzeczywistych



