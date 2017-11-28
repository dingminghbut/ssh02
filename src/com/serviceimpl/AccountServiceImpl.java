package com.serviceimpl;

import java.util.List;

import com.dao.AccountDao;
import com.daoimpl.AccountDaoImpl;
import com.pojo.Account;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountDao ad = new AccountDaoImpl();
	public List<Account> getAccount() {
		List<Account> list = ad.getAccount();
		return list;
	}

	public boolean getStatus(String acc) {		
		return ad.getStatus(acc);
	}

	public float getBalance(String acc) {
		return ad.getBalance(acc);
	}
	public int updateBalance(String acc1, String acc2, float money) {
		
		return ad.updateBalance(acc1, acc2, money);
	}
	
}
