package data.persistanceFacade.state;

import gui.minterface.Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import domain.entities.Course;
import domain.entities.Student;

public class studentloggedinState extends State{
	public String toString()
	{
		return "Student State";
	}
	private static studentloggedinState instance = new studentloggedinState();
	private studentloggedinState() {
	}
	public static State instance() {
		return instance;
	}
	public void build(Login ls) {
		ls.setSize(1280,  720);
		ls.remove(ls.panellogin);
		ls.revalidate();
		ls.repaint();
		
		ls.loggedInAs = new Student("Rasmus", ls.name, "Ras@ras.ras");
		// Meny panelen
		ls.jp1 = new JPanel();
		
		// Panelen till h�ger
		ls.jp2 = new JPanel();
		
		// Panelen i mitten med data
		ls.jp3 = new JPanel();
		
		ls.jp1.setBorder(new LineBorder(Color.red));
		ls.jp2.setBorder(new LineBorder(Color.blue));

		// L�s in kurser
		ls.courses = new ArrayList<Course>();
		ls.courses.add(new Course("123", "Historia A"));

		ls.courses.add(new Course("132", "Matte A"));

		String[] coursesNames = new String[ls.courses.size()];
		for (int i = 0; i < ls.courses.size(); i++) {
			coursesNames[i] = ls.courses.get(i).getCourseID();
		}

		// end

		// Dropdown med kurser
		ls.coursePicker = new JComboBox<String>(coursesNames);
		ls.coursePicker.setActionCommand("set");
		ls.coursePicker.addActionListener(ls.handler);
		ls.jp3.add(ls.coursePicker);

		// Anm�l knappen
		ls.btnSubmit = new JButton("Anmäl");
		ls.btnSubmit.addActionListener(ls.handler);
		ls.jp3.add(ls.btnSubmit);

		// Logga ut knappen
		ls.btnlogout = new JButton("Logga ut");
		ls.btnlogout.addActionListener(ls.handler);
		ls.jp1.add(ls.btnlogout);
		
		ls.addpanel(ls.jp1, BorderLayout.WEST);
		ls.addpanel(ls.jp2, BorderLayout.EAST);
		ls.addpanel(ls.jp3, BorderLayout.CENTER);
	}
	public void Handle(Login ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogout) {
			// ls.login.terminateStudent();
			ls.setState(loggedoffState.instance());
			ls.logout();
			ls.build();
		}
		if (e.getSource() == ls.btnSubmit) {
			String choice = (String) ls.coursePicker.getSelectedItem();
			int x = -1;
			for (int i = 0; i < ls.courses.size(); i++) {
				if (ls.courses.get(i).getCourseID().equals(choice)) {
					x = i;
				}
			}
			ls.loggedInAs.registerAbsence(ls.courses.get(x), 1, "today");
		}
	}
}
