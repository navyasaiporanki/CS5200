package edu.northeastern.cs5200.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repository.*;


@Component
public class UniversityDao {

	
	 public UniversityDao() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	PersonRepository personRepository;
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired 
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	

	public void truncateDatabase() {
		enrollmentRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		studentRepository.deleteAll();
		facultyRepository.deleteAll();
		personRepository.deleteAll();
	}
	
	public Faculty createFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Section createSection(Section section) {
		return sectionRepository.save(section);
	}
	
	public Course addSectionToCourse(Section section, Course course) {	
		section.setCourse(course);
		sectionRepository.save(section);
		
		course.setSection(section);
		return courseRepository.save(course);
	}
	
	public Course setAuthorForCourse(Faculty faculty, Course course) {
		
		faculty.authoredCourse(course);
		facultyRepository.save(faculty);
		course.setFaculty(faculty);
		return courseRepository.save(course);
	}
	
	public boolean enrollStudentInSection(Student student, Section section) {
		
		int seats = section.getSeats();
		
		if(seats > 0) {
		  Enrollment enrollment = new Enrollment(student, section);	
		  enrollmentRepository.save(enrollment);
		  
		  section.setSeats(seats - 1);
		  sectionRepository.save(section);
		  return true;
		}
		return false;
	}
	
	

}
