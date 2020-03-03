package ru.specialist.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("courseService")
@Repository
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional(readOnly=true) 
	public List<Course> findAll() {
		return new ArrayList<Course>(courseRepository.findAll());
	}

	@Transactional(readOnly=true) 
	public Course findById(int id) {
		return courseRepository.findOne(id);
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void delete(int id) {
		courseRepository.delete(id);
		
	}



}