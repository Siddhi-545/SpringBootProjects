package com.siddhiself.springboot.userbeananduserservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * This class defines user component class ie.dao layer
 * 
 * @author Siddhi Diwane
 *
 */

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<User>();

	private static int count = 3;

	static {
		userList.add(new User(101, "Siddhi", new Date()));
		userList.add(new User(102, "Prajwal", new Date()));
		userList.add(new User(103, "Samruddhi", new Date()));
	}

	public List<User> findAllUser() {
		return userList;
	}

	public User addUser(User user) {
		if (user.getId() == null) {
			user.setId(++count);
		}
		userList.add(user);
		return user;
	}

	public User searchUser(int id) {
		for (User user : userList) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User deleteUserById(int id) {
		Iterator<User> userIterator = userList.iterator();
		while (userIterator.hasNext()) {
			User user = userIterator.next();
			if (user.getId() == id)
				userIterator.remove();
			return user;
		}
		return null;
	}
}
