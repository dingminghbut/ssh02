package com.pojo;

public class Account {
	private String account_number;
	private String password;
	private int status;
	private float balance;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String account_number, String password, int status,
			float balance) {
		super();
		this.account_number = account_number;
		this.password = password;
		this.status = status;
		this.balance = balance;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", password="
				+ password + ", status=" + status + ", balance=" + balance
				+ "]";
	}

}
