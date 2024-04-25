package com.selflearnining.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selflearnining.springboot.learnjpaandhibernate.course.Course;

//Spring Data JPA

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByAuthor(String author);
	
	List<Course> findByName(String name);


}
