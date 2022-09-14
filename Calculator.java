package simpleCalculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double num1;
		double num2;
		char op;
		double sum;
		boolean run;
		
		while(run) {
			
			num1 = inputNumber(sc, "Zahl 1: ");
			op = inputOp(sc, "Operator: ");
			num2 = inputNumber(sc, "Zahl 2: ");
			try {
				
				sum = rechne(num1, num2, op);
				System.out.println("Ergebnis: " + sum);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			run = repeat(sc);
		}
	}
	
	private static double inputNumber(Scanner sc, String msg) {
		
		boolean exit = false;
		
		while(!exit) {
			
			System.out.print(msg);
			try {				
				double num = sc.nextDouble();		
				return num;
			} catch (Exception e) {		
				System.out.println("Error: Nur Zahlen verwenden!");
				sc.next();
			}
		}
		return 0;
	}
	
	private static char inputOp(Scanner sc, String msg) {
		
		boolean exit = false;
		char op = ' ';
		
		while(!exit) {
			
			System.out.print(msg);
			try {
				op = sc.next().charAt(0);
			} catch (Exception e) {
				System.out.println("Error: Bitte nur ein Zeichen verwenden!");
				sc.next();
			}
			
			switch(op) {
				case '+': return op;
				case '-': return op;
				case '*': return op;
				case '/': return op;
				default: System.out.println("Kein gültiger mathematischer Operator!");
			}
		}
		return ' ';
	}
	
	private static double rechne(double num1, double num2, char op) {
		
		switch(op) {
			case '+': return num1+num2;
			case '-': return num1-num2;
			case '*': return num1*num2;
			case '/': num2 != 0 ? return num1/num2 : throw new IllegalArgumentException("Error: Kann nicht durch 0 teilen");
		}
	}

	private static boolean repeat(Scanner sc) {

		System.out.print("Möchten Sie eine weitere Berechnung eingeben? (j/n) ");
		char input = sc.next().charAt(0).toLowerCase();

		if(input == 'j') {

			return true;
		}
		else {

			return false;
		}
	}
}
