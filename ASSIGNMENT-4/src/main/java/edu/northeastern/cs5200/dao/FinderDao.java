package edu.northeastern.cs5200.dao;

import java.util.List;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

public interface FinderDao {
	
	
	public List<Person> findAllUsers();
	
	public List<Faculty> findAllFaculty();
	
	public List<Student> findAllStudents();
	
	public List<Course> findAllCourses();
	
	public List<Section> findAllSections();
	
	public List<Course> findCoursesForAuthor(Faculty faculty);
	
	public List<Section> findSectionForCourse(Course course);
	
	public List<Student> findStudentsInSection(Section section);
	
	public List<Section> findSectionsForStudent(Student student);

	
	
}
