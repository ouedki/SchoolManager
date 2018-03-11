package com.SchoolManager.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManager.dao.StudentRepositoryDao;
import com.SchoolManager.models.Student;

@RestController
public class RestStudentController {

	@Autowired
	StudentRepositoryDao studentRepositoryDao;
	
	@RequestMapping("/students")
	@Secured({"ROLE_ADMIN", "ROLE_SCHOLAR"})
	public Page<Student> students(int page, int size){
		return studentRepositoryDao.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping("/saveStudents")
	@Secured({"ROLE_ADMIN", "ROLE_SCHOLAR", "ROLE_STUDENT", "ROLE_PROF"})
	public Student Savestudent(Student student){
		return studentRepositoryDao.save(student);
	}
	
	@RequestMapping("/loggedInUser")
	public Map<String, Object> getLoggedInUser(HttpServletRequest httpServletRequest ){
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext context = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = context.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority g : context.getAuthentication().getAuthorities()) {
			roles.add(g.getAuthority());
		}
		Map<String, Object> list = new HashMap<>();
		list.put("username", username);
		list.put("roles", roles);
		return list;
	}
}
