package edu.northeastern.cs5200.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;


public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer>{

	
	@Query("SELECT e from Enrollment e where e.section =:section")
	public List<Enrollment> findStudentsInSection(@Param("section") Section section);
	
	@Query("SELECT e from Enrollment e where e.student =:student")
	public List<Enrollment> findSectionsForStudent(@Param("student") Student student);
}
