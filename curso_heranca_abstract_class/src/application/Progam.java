package application;

import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.BuinessAccount;
import entities.SavingsAccount;

public class Progam {

	public static void main(String[] args) {
		
		List<Account> list = new ArrayList<>();
		
		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
		list.add(new BuinessAccount(1002, "Maria", 1000.00, 400.0));
		list.add(new SavingsAccount(1003, "Bob", 300.00, 0.01));
		list.add(new BuinessAccount(1004, "Ana", 500.00, 500.0));
		
		double sum =0;
		for(Account acc : list) {
			sum += acc.getBalance();
		}
		
		System.out.printf("Total balance: %.2f%n", sum);
		
		for(Account acc : list) {
			acc.deposito(10.0);
		}
		
		for(Account acc : list) {
			System.out.printf("Update balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}
	}
}







