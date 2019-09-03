package mock.bank.model;

import java.util.UUID;

public class BankAccount {
	
	private UUID id;
	
	private Double balance;

	public BankAccount(Double balance) {
		super();
		this.balance = balance;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	

}
