package com.test;

import com.service.AccountService;
import com.serviceimpl.AccountServiceImpl;

public class TestAccountServiceImpl {
	public static void main(String[] args) {
		AccountService as = new AccountServiceImpl();
		System.out.println(as.getAccount());
		String name1 = "acc1";
		String name2 = "acc2";
		System.out.println(as.getBalance(name1));
		System.out.println(as.getStatus(name2));
		System.out.println(as.updateBalance(name1,name2,13.86f));
	}
	
}
