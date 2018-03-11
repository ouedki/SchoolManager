package com.SchoolManager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManager.dao.RoleRepositoryDao;
import com.SchoolManager.dao.UserRepositoryDao;
import com.SchoolManager.models.Role;
import com.SchoolManager.models.User;

@RestController
@Secured({"ROLE_ADMIN"})
public class UserRestController {
	
	@Autowired
	UserRepositoryDao userRepositoryDao;
	
	@Autowired
	RoleRepositoryDao roleRepositoryDao; 
	
	@RequestMapping("/saveUser")
	public User saveUser(User user) {
		return userRepositoryDao.save(user);
	}

	@RequestMapping("/users")
	public List<User> getUsers () {
		return userRepositoryDao.findAll();
	}
	
	@RequestMapping("/saveRole")
	public Role saveRole(Role role) {
		return roleRepositoryDao.save(role);
	}

	@RequestMapping("/roles")
	public List<Role> getRoles () {
		return roleRepositoryDao.findAll();
	}
	
	@RequestMapping("/rolesToUser")
	public User AssignRoleToUser (String username, String role) {
		User u = userRepositoryDao.findOne(username);
		Role r= roleRepositoryDao.findOne(role);
		u.getRoles().add(r);
		userRepositoryDao.save(u);
		return u;
	}
}
