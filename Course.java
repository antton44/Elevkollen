package entites;

import java.util.ArrayList;

public class Course {
	private String courseID;
	private String courseName;
	private ArrayList<Student> students;
	
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
	}

	public void addStudent(Student student)
	{
		students.add(student);
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
