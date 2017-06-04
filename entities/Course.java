package entities;

import java.util.ArrayList;

import dto.StudentDTO;
import factory.Entities;
import factory.EntityFactory;

public class Course implements Entities{
	private String courseID;
	private String courseName;
	private ArrayList<Student> students;
	private EntityFactory ef;
	
	public Course()
	{
		courseID = "";
		courseName = "";
		students = null;
	}
	
	public Course(String courseID, String courseName)
	{
		this.courseID = courseID;
		this.courseName = courseName;
		students = new ArrayList<Student>();
		ef = new EntityFactory();
	}

	public void addStudent(StudentDTO dto)
	{
		students.add((Student)ef.getEntity(STUDENT, dto.name,  dto.personnummer,  dto.email));
	}
	
	public Student getStudent(int i)
	{
		return students.get(i);
	}
	
	public void removeStudent(int i)
	{
		students.remove(i);
	}
	
	public int getSize()
	{
		return students.size();
	}
	
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
