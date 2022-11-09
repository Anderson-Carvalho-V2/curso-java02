package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Departamento;
import entities.Funcionario;
import enums.NivelCargo;

public class Progam {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String departamento = sc.next();	
		System.out.println("Digite os dados do funcionário:");
		System.out.print("Nome: ");
		String nome = sc.next();
		System.out.print("Nivel: ");
		String nivel = sc.next();
		System.out.print("Salário base: ");
		Double salario = sc.nextDouble();
		
		Funcionario funcionario1 = new Funcionario(nome, NivelCargo.valueOf(nivel.toUpperCase()), salario, new Departamento(departamento));
	
		System.out.println("Digite o número de contratos do funcionário: ");
		int qtdContrato = sc.nextInt();
		
		for(int i=1; i<=qtdContrato;i++) {
			System.out.print("Digite os dados do contrato #" + i + ":\n");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorContrato = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int horasContrato = sc.nextInt();
			Contrato contrato = new Contrato(dataContrato, valorContrato, horasContrato);
			funcionario1.addContrato(contrato);
		}
		
		System.out.println("\nDigite o Mês e o Ano para calcular o salário (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.println("Nome: " + funcionario1.getNome());
		System.err.println("Departamento: " + funcionario1.getDepartamento().getName());	
		System.err.println("Renda de " + mesEAno + ": R$" + String.format("%.2f", funcionario1.renda(ano, mes)));	
		
		sc.close();
	}
}
