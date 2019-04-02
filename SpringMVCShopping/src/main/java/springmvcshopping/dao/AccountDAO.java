package springmvcshopping.dao;

import springmvcshopping.entity.Account;

public interface AccountDAO {
	public Account findAccount(String userName);
}
