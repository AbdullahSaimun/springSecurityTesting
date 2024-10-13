package com.saimun.securitytest.controller;

import com.saimun.securitytest.dto.Student;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class StudentController {
	public static List<Student> studentList = new ArrayList<>(
			Arrays.asList(
					new Student(1, "something", 32),
					new Student(2, "just", 42),
					new Student(3, "like", 22)
			)
	);

	@GetMapping("/students")
	public List<Student> students() {
		log.info(studentList.toString(), " student list ");
		return studentList;
	}

	@PostMapping("/students")
	public List<Student> addStudent(@RequestBody Student student) {
		studentList.add((student));
		log.info("student list from post " + studentList);
		return studentList;

	}

	@GetMapping("/csrf-token")
	public CsrfToken csrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
