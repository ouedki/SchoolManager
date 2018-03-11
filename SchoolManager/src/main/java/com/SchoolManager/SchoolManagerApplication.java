package com.SchoolManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SchoolManager.dao.StudentRepositoryDao;
import com.SchoolManager.models.Student;

@SpringBootApplication
public class SchoolManagerApplication implements CommandLineRunner{

	@Autowired
	StudentRepositoryDao studentRepositoryDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolManagerApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Student s1 = studentRepositoryDao.save(new Student("yassine", "ouedki", "yassine@gmail.com", "11111", df.parse("11/12/1985")));
		Student s2 = studentRepositoryDao.save(new Student("amine", "oussou", "oussou@gmail.com", "22222", df.parse("11/12/1985")));
		Student s3 = studentRepositoryDao.save(new Student("zakaria", "adnane", "zak@gmail.com", "333333", df.parse("11/12/1985")));
		Student s4 = studentRepositoryDao.save(new Student("salah", "yafout", "salah@gmail.com", "444444", df.parse("11/12/1985")));
		Student s5 = studentRepositoryDao.save(new Student("amina", "alami", "alami@gmail.com", "555555", df.parse("11/12/1985")));
		Student s6 = studentRepositoryDao.save(new Student("kamal", "nadir", "nadir@gmail.com", "666666", df.parse("11/12/1985")));
		Student s7 = studentRepositoryDao.save(new Student("boutaina", "sammi", "bou@gmail.com", "777777", df.parse("11/12/1985")));
	}
}
