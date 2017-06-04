package minterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import entities.Course;
import entities.Student;

public class LoginStudent extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Login login;		//Login objekt, anv�nds f�r att logga ut
	private Handlerclass handler;	//Databas handlern
	private JButton btnlogout;		//Logga ut knappen
	private JButton btnSubmit;		//Knappen som godk�nner fr�nvaro registrering
	private JComboBox<String> coursePicker;	//Dropdown med studentens kurser
	private ArrayList<Course> courses;	//ArrayList med namnen p� kurserna
	private Student loggedInAs;	//Den inloggade studenten

	public LoginStudent(String name, Login login) {
		super(name);
		
		//Hämta Student från db
		loggedInAs = new Student("Rasmus", name, "Ras@ras.ras");
		
		this.login = login;
		
		//Meny panelen
		JPanel jp1 = new JPanel();
		super.add(jp1, BorderLayout.WEST);
		
		//Panelen till h�ger
		JPanel jp2 = new JPanel();
		super.add(jp2, BorderLayout.EAST);
		
		//Panelen i mitten med data
		JPanel jp3 = new JPanel();
		super.add(jp3, BorderLayout.CENTER);
		jp1.setBorder(new LineBorder(Color.red));
		jp2.setBorder(new LineBorder(Color.blue));

		
		//L�s in kurser
		courses = new ArrayList<Course>();
		courses.add(new Course("123", "Historia A"));
		
		courses.add(new Course("132", "Matte A"));

		String[] coursesNames = new String[courses.size()];
		for(int i = 0; i < courses.size(); i++)
		{
			coursesNames[i] = courses.get(i).getCourseID();
		}

		//end
		
		//Dropdown med kurser
		coursePicker = new JComboBox<String>(coursesNames);
		coursePicker.setActionCommand("set");
		coursePicker.addActionListener(handler);
		jp3.add(coursePicker);

		//Handler klassen
		handler = new Handlerclass();
		
		//Anm�l knappen
		btnSubmit = new JButton("Anmäl");
		btnSubmit.addActionListener(handler);
		jp3.add(btnSubmit);
		
		//Logga ut knappen
		btnlogout = new JButton("Logga ut");
		btnlogout.addActionListener(handler);
		jp1.add(btnlogout);
	}

	private class Handlerclass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnlogout) {
				login.terminateStudent();
			}
			if (e.getSource() == btnSubmit) {
				String choice = (String) coursePicker.getSelectedItem();
				int x = -1;
				for(int i = 0; i < courses.size(); i++)
				{
					if(courses.get(i).getCourseID().equals(choice))
					{
						x = i;
					}
				}
				loggedInAs.registerAbsence(courses.get(x), 1, "today");
			}
		}
	}
}
