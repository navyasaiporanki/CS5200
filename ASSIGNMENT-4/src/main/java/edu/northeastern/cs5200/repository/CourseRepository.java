package edu.northeastern.cs5200.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;

public interface CourseRepository extends CrudRepository<Course, Integer>{

	
	 @Query("select c from Course c where c.faculty = :faculty")
	public List<Course> findCourseByFaculty(@Param("faculty") Faculty faculty);
		
	
}
