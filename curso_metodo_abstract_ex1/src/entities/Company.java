package entities;

public class Company extends TaxPayer {
	
	private Integer numberOfEmployes;

	public Company(String name, Double anualIncome, Integer numberOfEmployes) {
		super(name, anualIncome);
		this.numberOfEmployes = numberOfEmployes;
	}

	public Integer getNumberOfEmployes() {
		return numberOfEmployes;
	}

	public void setNumberOfEmployes(Integer numberOfEmployes) {
		this.numberOfEmployes = numberOfEmployes;
	}

	@Override
	public double tax() {
		if(numberOfEmployes > 10) {
			return getAnualIncome() * 0.14;
		}else {
			return getAnualIncome() * 0.16;			
		}
	}
	
}
