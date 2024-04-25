package com.DummyProject.BirdEyeListing.Service;

import com.DummyProject.BirdEyeListing.Entities.Mentor;
import com.DummyProject.BirdEyeListing.Entities.Student;
import com.DummyProject.BirdEyeListing.Repo.MentorRepository;
import com.DummyProject.BirdEyeListing.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommonService {

	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	StudentRepository studentRepository;

	public Set<String> findAllMentors(String mentorName) {
		Mentor mentor = mentorRepository.findByMentorName(mentorName);

		if (mentor == null || mentor.getStudents() == null) {
			return Collections.emptySet(); // Return an empty set if mentor or students are null
		}

		return mentor.getStudents().stream()
				.map(Student::getName)
				.filter(Objects::nonNull) // Filter out null values
				.collect(Collectors.toSet());
	}

}
