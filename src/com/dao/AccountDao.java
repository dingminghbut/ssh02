package com.dao;


import java.util.List;

import com.pojo.Account;

public interface AccountDao {
	//A.登录查询
	public List<Account> getAccount();
	//B.账户状态查询
	public boolean getStatus(String acc); 
	//C.账户余额查询
	public float getBalance(String acc);
	//D.修改账户余额
	public int updateBalance(String acc1,String acc2,float money);
	
}
