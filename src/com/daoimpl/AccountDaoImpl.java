package com.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AccountDao;
import com.dao.BaseDao;
import com.pojo.Account;

public class AccountDaoImpl extends BaseDao implements AccountDao {

	public List<Account> getAccount() {
		List<Account> list = new ArrayList<Account>();
		String sql = "select * from account";
		Object param[] = {};
		ResultSet rs = query(sql, param);
		try {
			while (rs.next()) {
				Account account = new Account();
				account.setAccount_number(rs.getString("account_number"));
				account.setPassword(rs.getString("password"));
				account.setStatus(rs.getInt("status"));
				account.setBalance(rs.getFloat("balance"));
				list.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean getStatus(String acc) {
		boolean flag = false;
		String sql = "select * from account where account_number = ?";
		Object param[] = { acc };
		ResultSet rs = query(sql, param);
		Account account = new Account();
		try {
			while (rs.next()) {
				account.setAccount_number(rs.getString("account_number"));
				account.setPassword(rs.getString("password"));
				account.setStatus(rs.getInt("status"));
				account.setBalance(rs.getFloat("balance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(account.getStatus()==1){
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}

	public float getBalance(String acc) {
		String sql = "select * from account where account_number = ?";
		Object param[] = { acc };
		ResultSet rs = query(sql, param);
		Account account = new Account();
		try {
			while (rs.next()) {
				account.setAccount_number(rs.getString("account_number"));
				account.setPassword(rs.getString("password"));
				account.setStatus(rs.getInt("status"));
				account.setBalance(rs.getFloat("balance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account.getBalance();
	}

	public int updateBalance(String acc1,String acc2,float money) {
		String sql = "UPDATE account AS a1,account AS a2 SET a1.balance = a1.balance-? ,a2.balance = a2.balance+? WHERE a1.account_number = ? AND a2.account_number = ?";
		Object param[] = {money,money,acc1,acc2};
		int total= update(sql,param);
		return total;
	}

}
