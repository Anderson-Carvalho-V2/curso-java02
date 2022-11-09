package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Progam {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		System.out.print("Enter the number of taxpayers: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Indiual or company (i/c)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(resp == 'i') {
				System.out.print("Health spending: ");
				double healthSpending = sc.nextDouble();
				taxPayers.add(new Individual(name, anualIncome, healthSpending));
			}else {
				System.out.print("number of employes: ");
				int numberOfEmployes = sc.nextInt();
				taxPayers.add(new Company(name, anualIncome, numberOfEmployes));
			}
		}
		
		System.out.println("\nTAXES PAID:");
		for(TaxPayer tp : taxPayers) {
			System.err.println(String.format("%s: $ %.2f", tp.getName(), tp.tax()));
		}
		
		double sum = 0.0;
		for(TaxPayer tp : taxPayers) {
			sum += tp.tax();
		}
		
		System.out.printf("\nTOTAL: $ %.2f", sum);
		
		sc.close();
	}
}
