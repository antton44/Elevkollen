package minterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import entities.Course;

public class Window extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentTable table;
	private ArrayList<Course> courses;
	private String[] courseNames;
	
	public Window(ArrayList<Course> courses)
	{
		super();
		courseNames = new String[courses.size()];
		for(int i = 0; i < courses.size(); i++)
		{
			courseNames[i] = courses.get(i).getCourseName();
		}
		this.courses = courses;
		JComboBox<String> coursePicker = new JComboBox<String>(courseNames);
		super.add(coursePicker, BorderLayout.NORTH);
		table = new StudentTable(courses.get(0));
		super.add(table, BorderLayout.SOUTH);
		initTable(0);
		coursePicker.setActionCommand("change");
		coursePicker.addActionListener(this);
	}

	public void initTable(int chosen)
	{
		super.remove(table);
		table = new StudentTable(courses.get(chosen));
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