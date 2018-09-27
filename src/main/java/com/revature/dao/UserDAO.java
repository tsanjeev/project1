package com.revature.dao;

import com.revature.pojos.User;

public interface UserDAO {
	void userInsert(User user) throws Exception;
	void userUpdate(User user) throws Exception;
	void userDelete(User user) throws Exception;
	User getUserByCred(User user);
}
