package com.DummyProject.BirdEyeListing.Entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "students")
public class Student {
	private int id;
	private String name;
	private String city;
	private String college;
	@DBRef(lazy = true)
	private Mentor mentor;
}
