package com.test;

import com.dao.AccountDao;
import com.daoimpl.AccountDaoImpl;

public class TestAccountDaoimpl {
	public static void main(String[] args) {
		AccountDao ad = new AccountDaoImpl();
		System.out.println(ad.getAccount());
		String name1 = "acc1";
		String name2 = "acc2";
		System.out.println(ad.getBalance(name1));
		System.out.println(ad.getStatus(name2));
		System.out.println(ad.updateBalance(name1,name2,13.86f));
		
	}
}
