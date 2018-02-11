package gui.minterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import domain.entities.Course;
import gui.view.StudentController;
import gui.view.StudentView;

public class Window extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentView table;
	private ArrayList<Course> courses;
	private String[] courseNames;
	private StudentController sc;
	
	public Window(ArrayList<Course> courses, StudentController sc)
	{
		super();
		this.sc = sc;
		courseNames = new String[courses.size()];
		for(int i = 0; i < courses.size(); i++)
		{
			courseNames[i] = courses.get(i).getCourseName();
		}
		this.courses = courses;
		JComboBox<String> coursePicker = new JComboBox<String>(courseNames);
		super.add(coursePicker, BorderLayout.NORTH);
		table = new StudentView();
		sc.setView(table);
		super.add(table, BorderLayout.SOUTH);
		initTable(0);
		coursePicker.setActionCommand("change");
		coursePicker.addActionListener(this);
	}

	public void initTable(int chosen)
	{
		super.remove(table);
		sc.clearModels();
		for(int i = 0; i < courses.get(chosen).getSize(); i++)
		{
			sc.addStudent(courses.get(chosen).getStudent(i));
		}
		sc.updateView();
		super.add(table, BorderLayout.CENTER);
		super.revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
			@SuppressWarnings("unchecked")
			JComboBox<String> cb = (JComboBox<String>)e.getSource();
	        String course = (String)cb.getSelectedItem();
	        for(int i = 0; i < courses.size(); i++)
	        {
	        	if(courses.get(i).getCourseID().equals(course))
	        	{
	        		initTable(i);
	        	}
	        }
		
	}
}