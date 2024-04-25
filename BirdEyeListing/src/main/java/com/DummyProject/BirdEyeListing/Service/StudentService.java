package com.DummyProject.BirdEyeListing.Service;

import com.DummyProject.BirdEyeListing.Entities.Student;
import com.DummyProject.BirdEyeListing.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public Set<String> getAllCities() {
		return studentRepository.findAll().stream()
				.map(Student::getCity)
				.collect(Collectors.toSet());
	}

}
