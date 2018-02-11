package gui.view;

import java.util.ArrayList;

import domain.entities.Student;

public class StudentController
{
	private ArrayList<Student> models;
	private StudentView view;
	
	public StudentController()
	{
		models = new ArrayList<Student>();
	}
	
	public void setView(StudentView view)
	{
		this.view = view;
	}
	
	public void updateView()
	{
		view.reloadData(models);
	}
	
	public void addStudent(Student student)
	{
		models.add(student);
	}
	
	public void clearModels()
	{
		models.clear();
	}
}
