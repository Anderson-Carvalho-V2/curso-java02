package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.NivelCargo;

public class Funcionario {
	private String nome;
	private NivelCargo nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<Contrato> contratos = new ArrayList<>();
	
	public Funcionario() {}

	public Funcionario(String nome, NivelCargo nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelCargo getNivel() {
		return nivel;
	}

	public void setNivel(NivelCargo nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void addContrato(Contrato contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for(Contrato c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes =  1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
}
