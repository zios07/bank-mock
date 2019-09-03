package mock.bank.model;

import java.util.UUID;

public class User {

	private UUID id;
	
	private String username;
	
	private String password;
	
	private BankAccount account;

	public User(String username, String password, BankAccount account) {
		this.username = username;
		this.password = password;
		this.account = account;
	}
	
	public User() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
}
