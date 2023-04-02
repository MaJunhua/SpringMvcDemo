package com.example.restservice.Controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.Model.SchoolClass;
import com.example.restservice.Model.Student;
import com.example.restservice.Service.ClassService;
import com.example.restservice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	ClassService classService;

	@Autowired
	StudentService studentService;

	@GetMapping("/classes")
	public List<SchoolClass> ListClasses() {
		return classService.ListClass();
	}

	@PostMapping("/classes")
	public SchoolClass AddClass(@RequestBody SchoolClass new_class) throws Exception {
		return classService.AddClass(new_class);
	}

	@GetMapping("/class/{name}")
	public SchoolClass GetClass(@PathVariable String name) throws Exception {
		return classService.GetClass(name);
	}

	@PutMapping("/class/{name}")
	public SchoolClass UpdateClass(@PathVariable String name, @RequestBody SchoolClass updated_class) throws Exception {
		return classService.UpdateClass(name, updated_class);
	}

	@DeleteMapping("/class/{name}")
	public void DeleteClasses(@PathVariable String name) throws Exception {
		classService.DeleteClass(name);
	}

	@GetMapping("/class/{class_name}/students")
	public List<Student> ListStudents(@PathVariable String class_name) {
		return studentService.ListStudent(class_name);
	}

	@PostMapping("/class/{class_name}/students")
	public Student AddStudents(@PathVariable String class_name, @RequestBody Student student) throws Exception {
		return studentService.AddStudent(class_name, student);
	}

	@GetMapping("/class/{class_name}/student/{student_name}")
	public Student GetStudent(@PathVariable String class_name, @PathVariable String student_name) throws Exception {
		return studentService.GetStudent(class_name, student_name);
	}

	@PutMapping("/class/{class_name}/student/{student_name}")
	public Student UpdateClass(@PathVariable String class_name, @PathVariable String student_name, @RequestBody Student student) throws Exception {
		return studentService.UpdateStudent(class_name, student_name, student);
	}

	@DeleteMapping("/class/{class_name}/student/{student_name}")
	public void DeleteStudeet(@PathVariable String class_name, @PathVariable String student_name ) throws Exception {
		studentService.DeleteStudent(class_name, student_name);
	}
}
