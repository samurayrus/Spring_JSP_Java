package ru.specialist.dao;

import java.util.List;

public interface CourseDAO {
	Course findById(int id);
	List<Course> findAll();
	
	//public void editAll();
	//public void add(String description);
	
	List<Course> findByTitle(String title);
	void insert(Course course);
	void update(Course course);
	void delete(int id);

}
