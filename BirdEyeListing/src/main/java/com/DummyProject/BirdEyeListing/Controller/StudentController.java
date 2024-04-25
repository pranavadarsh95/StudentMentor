package com.DummyProject.BirdEyeListing.Controller;

import com.DummyProject.BirdEyeListing.Entities.Student;
import com.DummyProject.BirdEyeListing.Repo.StudentRepository;
import com.DummyProject.BirdEyeListing.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/health")
	public ResponseEntity<?> health(){
		return ResponseEntity.ok("Hello tilak and pranav! welcome");
	}


	// Create, Add Students Record
	@PostMapping("/")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student save = studentRepository.save(student);
		return ResponseEntity.ok(save);
	}

	// Fetch All Student Records
	@GetMapping("/")
	public ResponseEntity<?> getStudents(){
		return ResponseEntity.ok(studentRepository.findAll());
	}

	// Get a student Record
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") Integer id){
		Optional<Student> studentOptional = studentRepository.findById(id);
		if(studentOptional.isPresent()){
			return new ResponseEntity<Student>(studentOptional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>("No student record present with id: "+id, HttpStatus.OK);

	}

	// Delete Any Student Record
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id){
		Optional<Student> studentOptional = studentRepository.findById(id);
		if(studentOptional.isPresent()){
			studentRepository.deleteById(id);
			return new ResponseEntity<>("student record deleted with id:"+ id, HttpStatus.OK);
		}
		return new ResponseEntity<>("No student record present with id: "+id, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student , @PathVariable("id") Integer id){
		Optional<Student> studentOptional = studentRepository.findById(id);
		if(studentOptional.isPresent()){
			Student dbStudent = studentOptional.get();
			dbStudent.setName(student.getName());
			dbStudent.setCity(student.getCity());
			dbStudent.setCollege(student.getCollege());
			studentRepository.save(dbStudent);
			return new ResponseEntity<>(dbStudent, HttpStatus.OK);
		}
		return new ResponseEntity<>("No student record present with id: "+id, HttpStatus.OK);
	}

	@GetMapping("/uniqueCities")
	public ResponseEntity<?> getUniqueCities(){
		return ResponseEntity.ok(studentService.getAllCities());
	}

}
