package com.DummyProject.BirdEyeListing.Entities;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "mentors")
public class Mentor {
	private int id;
	private String mentorName;
	private String mentorCity;
	private String specialization;
	private String salary;
	@DBRef (lazy = true)
	private List<Student> students;
}
