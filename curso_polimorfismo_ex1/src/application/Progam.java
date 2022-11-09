package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;
import entities.FuncionarioTerceirizado;

public class Progam {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o número de empregados: ");
		int n = sc.nextInt();
		
		Funcionario func;
		List<Funcionario> funcionarios = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			System.out.print("Dados do funcionário #" + i +":\n");
			System.out.print("Terceirado (y/n)? ");
			char terceirizado = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			
			if(terceirizado == 'y') {
				System.out.print("Adicional: ");
				double adicional = sc.nextDouble();
				func = new FuncionarioTerceirizado(nome, horas, valorHora, adicional);
				funcionarios.add(func);
			}else {
				func = new Funcionario(nome, horas, valorHora);
				funcionarios.add(func);
			}			
		}
		
		System.out.println("\nPagamentos:");
		for (Funcionario f : funcionarios) {
			System.out.println(f);
		}
		
		sc.close();
	}
}
