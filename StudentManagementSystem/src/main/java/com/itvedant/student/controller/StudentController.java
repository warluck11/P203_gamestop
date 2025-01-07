package com.itvedant.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.PutExchange;

import com.itvedant.student.dao.AddStudentDAO;
import com.itvedant.student.dao.UpdateStudentDAO;
import com.itvedant.student.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddStudentDAO addStudentDAO){
		return ResponseEntity.ok(this.studentService.createStudent(addStudentDAO));
	}
	
	@GetMapping("")
	public ResponseEntity<?> readAll(){
		return ResponseEntity.ok(this.studentService.readAllStudents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable Integer id){
		return ResponseEntity.ok(this.studentService.readByIdStudent(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UpdateStudentDAO updateStudentDAO,@PathVariable Integer id){
		return ResponseEntity.ok(this.studentService.updateStudent(updateStudentDAO, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return ResponseEntity.ok(this.studentService.deleteStudent(id));
	}
}
















