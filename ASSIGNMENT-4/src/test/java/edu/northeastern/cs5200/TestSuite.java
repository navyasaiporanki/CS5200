package edu.northeastern.cs5200;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.northeastern.cs5200.dao.FinderImpl;
import edu.northeastern.cs5200.dao.UniversityDao;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSuite {
	
	@Autowired
	UniversityDao universityDao;
	
	@Autowired
	FinderImpl finderImpl;
	
	@Before
	public void setUp() {
		
		/*Removes all the elements from the database*/
		universityDao.truncateDatabase();
		
		
		/* Inserting the Faculties */
		  Faculty alan = new Faculty("alan", "password", "Alna", "Turin", "123A",true);
		  Faculty ada = new Faculty("ada", "password", "Ada", "Lovelace","123B", true);
	   /******/	 
		
		/*Inserting faculties into the database*/
		  universityDao.createFaculty(alan); 
		  universityDao.createFaculty(ada);
	  /******/	 
		 
		
		/* Inserting Students */
		
		  Student alice = new Student("alice", "password", "Alice", "Wonderland",2020,12000);
		  Student return_alice = universityDao.createStudent(alice);
		  
		  Student bob = new Student("bob", "password", "Bob", "Hope", 2021,23000);
		  Student return_bob = universityDao.createStudent(bob);
		  
		  Student charlie = new Student("charlie", "password", "Charlie", "Brown", 2019,21000);
		  Student return_charlie = universityDao.createStudent(charlie);
		  
		  Student dan = new Student("dan", "password", "Dan", "Craig", 2019,0); 
		  Student return_dan = universityDao.createStudent(dan);
		  
		  Student edward = new Student("edward", "password", "Edward", "Scissorhands",2022,11000); 
		  Student return_edward = universityDao.createStudent(edward);
		  
		  Student frank = new Student("frank", "password", "Frank", "Herbert", 2018,0);
		  Student return_frank = universityDao.createStudent(frank);
		  
		  Student gregory = new Student("gregory", "password", "Gregory", "Peck", 2023,10000); 
		  Student return_gregory = universityDao.createStudent(gregory);
		  
			Course cs1234 = new Course("CS1234", alan);
	        universityDao.createCourse(cs1234);
			Course cs2345 = new Course("CS2345", alan);
	        universityDao.createCourse(cs2345);
			Course cs3456 = new Course("CS3456", ada);
	        universityDao.createCourse(cs3456);
			Course csS4567 = new Course("CS4567", ada);
	        universityDao.createCourse(csS4567);
	        
	        
	        Section SEC4321 = new Section(50, "SEC4321", cs1234);
	        universityDao.createSection(SEC4321);
	        Section SEC5432 = new Section(50, "SEC5432", cs1234);
	        universityDao.createSection(SEC5432);
	        Section SEC6543 = new Section(50, "SEC6543", cs2345);
	        universityDao.createSection(SEC6543);
	        Section SEC7654 = new Section(50, "SEC7654", cs3456);
	        universityDao.createSection(SEC7654);
	        
	       
	        universityDao.enrollStudentInSection(alice,SEC4321);
	        universityDao.enrollStudentInSection(alice,SEC5432);
	        universityDao.enrollStudentInSection(bob,SEC5432);
	        universityDao.enrollStudentInSection(charlie,SEC6543);		
	}
	
	/*A Test Method to validate the number of users.*/
	@Test
	public void validateUsers() {
		
		List<Person> personList = finderImpl.findAllUsers();
		assertEquals(personList.size(), 9);
	}
	
	/*A Test Method to validate the number of Faculty.*/
	@Test
	public void validateFaculty() {
		
		List<Faculty> facultyList = finderImpl.findAllFaculty();
		assertEquals(facultyList.size(), 2);
	}
	
	/*A Test Method to validate the number of Student.*/
	@Test
	public void validateStudents() {
		
		List<Student> studentList = finderImpl.findAllStudents();
		assertEquals(studentList.size(), 7);
	}
	
	/*A Test Method to validate the number of Course.*/
	@Test
	public void validateCourse() {
		
		List<Course> courseList = finderImpl.findAllCourses();
		assertEquals(courseList.size(), 4);
	}
	
	/*A Test Method to validate the number of Section.*/
	@Test
	public void validateSections() {
		
		List<Section> sectionList = finderImpl.findAllSections();
		assertEquals(sectionList.size(), 4);
	}
	
	/*A Test Method to validate the number of Course Authorship.*/
	@Test
	public void validateCourseAuthorship() {
		
		List<Faculty> facultyList = finderImpl.findAllFaculty();
		for(Faculty f : facultyList) {
			List<Course> courseList = finderImpl.findCoursesForAuthor(f);
			assertEquals(courseList.size(), 2);
		}  
	}
	
	/*A Test Method to validate the number of Sections per Course.*/
	@Test
	public void validateSectionsPerCourse() {
		List<Course> courseList = finderImpl.findAllCourses();
	
		for(Course c: courseList) {
			List<Section> sectionList = finderImpl.findSectionForCourse(c);
			if(c.getLabel().equalsIgnoreCase("cs1234")) {
				assertEquals(2, sectionList.size());
			}
			else if (c.getLabel().equalsIgnoreCase("cs2345") || c.getLabel().equalsIgnoreCase("cs3456")) {
				assertEquals(1, sectionList.size());
			}
			else {
				assertEquals(0, sectionList.size());
			}
		}
	}
	
	/*A Test Method to validate the number of Students in a Section.*/
	@Test
	public void validateStudentsInSections() {
		
		List<Section> sectionList = finderImpl.findAllSections();
		
		for(Section s : sectionList) {
			List<Student> studentList = finderImpl.findStudentsInSection(s);
			if(s.getTitle().equalsIgnoreCase("SEC5432")) {
				assertEquals(studentList.size(), 2);
			}
			else if (s.getTitle().equalsIgnoreCase("SEC6543") || s.getTitle().equalsIgnoreCase("SEC4321")) {
				assertEquals(studentList.size(), 1);
			}
			else {
				assertEquals(studentList.size(), 0);
			}
		}
		
	}
	
	
	/*Validate total number of sections for each student*/
    @Test
    public void validateSectionsForStudent() {
    	List<Student> studentList = finderImpl.findAllStudents();
    	for(Student s: studentList) {
    		List<Section> sectionList = finderImpl.findSectionsForStudent(s);
    		if (s.getUsername().equalsIgnoreCase("alice")) {
    			assertEquals(sectionList.size(), 2);
    		}
    		else if(s.getUsername().equalsIgnoreCase("bob")) {
    			assertEquals(sectionList.size(), 1);
    		}
    		else if(s.getUsername().equalsIgnoreCase("charlie")) {
    			assertEquals(sectionList.size(), 1);
    		}
    		else {
    			assertEquals(sectionList.size(), 0);
    		}
    	}
    }
    
    /*Validate total number of section seats*/
    @Test
    public void validateSectionSeats() {
    	List<Section> sectionList = finderImpl.findAllSections();
    	for(Section s : sectionList) {
    		if(s.getTitle().equalsIgnoreCase("SEC5432")) {
    			assertEquals(s.getSeats(), 48);
    		}
    		else if(s.getTitle().equalsIgnoreCase("SEC6543") || s.getTitle().equalsIgnoreCase("SEC4321") ) {
    			assertEquals(s.getSeats(), 49);
    		}
    		else {
    			assertEquals(s.getSeats(), 50);
    		}
    	}
    }
	
	
    
}
