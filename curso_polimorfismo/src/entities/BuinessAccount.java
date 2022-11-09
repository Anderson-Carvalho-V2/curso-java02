package entities;

public class BuinessAccount extends Account{
	private Double loanLimit;
	
	public BuinessAccount() {
		super();
	}

	public BuinessAccount(Integer number, String holder, Double balance, Double limiteSaque) {
		super(number, holder, balance);
		this.loanLimit = limiteSaque;
	}

	public Double getLimiteSaque() {
		return loanLimit;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.loanLimit = limiteSaque;
	}
	
	public void loan(double valor) {
		if(valor <= loanLimit) {
			balance += valor - 10;			
		}
	}
	
	@Override
	public void saque(double valor) {
		super.saque(valor);
		balance -= 2.0;
	}
}
