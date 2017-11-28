package com.dao;


import java.util.List;

import com.pojo.Account;

public interface AccountDao {
	//A.��¼��ѯ
	public List<Account> getAccount();
	//B.�˻�״̬��ѯ
	public boolean getStatus(String acc); 
	//C.�˻�����ѯ
	public float getBalance(String acc);
	//D.�޸��˻����
	public int updateBalance(String acc1,String acc2,float money);
	
}
