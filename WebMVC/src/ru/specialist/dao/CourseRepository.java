package ru.specialist.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	List<Course> findAll();
	

}
