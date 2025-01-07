package com.itvedant.student.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.student.dao.AddStudentDAO;
import com.itvedant.student.dao.UpdateStudentDAO;
import com.itvedant.student.entity.Student;

@Service
public class StudentService {
	
	private Map<Integer, Student> students = new HashMap<Integer, Student>() ;
	
	AtomicInteger counter = new AtomicInteger();
	
	
	public Student createStudent(AddStudentDAO addStudentDAO) {
		
		Student student = new Student();
		
		student.setId(counter.incrementAndGet());
		student.setName(addStudentDAO.getName());
		student.setAge(addStudentDAO.getAge());
		student.setMarks(addStudentDAO.getMarks());
		
		this.students.put(student.getId(), student);
		
		return student;
	}
	
	public Collection<Student> readAllStudents(){
		
		Collection<Student> student = new ArrayList<Student>();
		
		student = this.students.values();
		
		return student;
	}
	
	
	public Student readByIdStudent(Integer id){
		
		Student student = new Student();
		
		student = this.students.get(id);
		
		return student;
	}
	
	
	public Student updateStudent(UpdateStudentDAO updateStudentDAO, Integer id) {
		
		Student student = new Student();
		
		student = this.readByIdStudent(id);
		
		if(updateStudentDAO.getName() != null){
			student.setName(updateStudentDAO.getName());
		}
		if(updateStudentDAO.getAge() != null) {
			student.setAge(updateStudentDAO.getAge());
		}
		if(updateStudentDAO.getMarks() != null){
			student.setMarks(updateStudentDAO.getMarks());
		}
		
		
		return student;
	}
	
	
	public String deleteStudent(Integer id) {
		
		Student student = new Student();
		
		student = this.readByIdStudent(id);
		
		this.students.remove(id, student);
		
		return "Student data deleted";
		
	}
	
}















