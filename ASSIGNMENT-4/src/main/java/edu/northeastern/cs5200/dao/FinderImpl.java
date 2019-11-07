package edu.northeastern.cs5200.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repository.CourseRepository;
import edu.northeastern.cs5200.repository.EnrollmentRepository;
import edu.northeastern.cs5200.repository.FacultyRepository;
import edu.northeastern.cs5200.repository.PersonRepository;
import edu.northeastern.cs5200.repository.SectionRepository;
import edu.northeastern.cs5200.repository.StudentRepository;

@Component
public class FinderImpl implements FinderDao{

	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	
	
	
	@Override
	public List<Person> findAllUsers() {
		List<Person> personList = (List<Person>) personRepository.findAll();
		return personList;
	}

	@Override
	public List<Faculty> findAllFaculty() {
		List<Faculty> facultyList = (List<Faculty>) facultyRepository.findAll(); 
		return facultyList;
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> studentList = (List<Student>) studentRepository.findAll();
		return studentList;
	}

	@Override
	public List<Course> findAllCourses() {
		List<Course> courseList = (List<Course>) courseRepository.findAll();
		return courseList;
	}

	@Override
	public List<Section> findAllSections() {
		List<Section> sectionList = (List<Section>) sectionRepository.findAll();
		return sectionList;
	}

	@Override
	public List<Course> findCoursesForAuthor(Faculty faculty) {
		List<Course> courseList = courseRepository.findCourseByFaculty(faculty);
	    return courseList;
	}

	@Override
	public List<Section> findSectionForCourse(Course course) {
		List<Section> sectionList = sectionRepository.findSectionByCourse(course);
		return sectionList;
	}

	@Override
	public List<Student> findStudentsInSection(Section section) {
		List<Enrollment> enrollmentList = enrollmentRepository.findStudentsInSection(section);
		List<Student> studentList = new ArrayList<Student>();
		for(Enrollment e : enrollmentList ) {
			studentList.add(e.getStudent());
		}
	    return studentList;
	}

	@Override
	public List<Section> findSectionsForStudent(Student student) {
		List<Enrollment> enrollmentList = enrollmentRepository.findSectionsForStudent(student);
		List<Section> sectionList = new ArrayList<Section>();
		
		for(Enrollment e: enrollmentList) {
			sectionList.add(e.getSection());
		}
		return sectionList;
	}

}
