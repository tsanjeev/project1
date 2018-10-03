package com.revature.services;

import com.revature.dao.UserDAOImp;
import com.revature.pojos.Event;
import com.revature.pojos.User;

public class UserServices {
		static UserDAOImp ud = new UserDAOImp();
		
		public static User addNewUser(User u) throws Exception {
			ud.userInsert(u);
			return u;
		}
		
		public static User login(User u) {
			User user = ud.getUserByCred(u);
			return user;
		}
		
		public static User updateUser(User u) throws Exception {
			ud.userUpdate(u);
			User user = ud.getUserByCred(u);
			return user;
		}
		
		public static void deleteUser(User u) throws Exception {
			ud.userDelete(u);
		}
		
		
}
