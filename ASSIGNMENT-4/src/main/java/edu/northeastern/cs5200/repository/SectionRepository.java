package edu.northeastern.cs5200.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Section;

public interface SectionRepository extends CrudRepository<Section, Integer> {

	@Query("SELECT s from Section s where s.course = :course")
	public List<Section> findSectionByCourse(@Param("course") Course course);
}
