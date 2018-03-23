package gui.state;

import gui.minterface.LoginWindow;

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

public class parentloggedinState extends State{
	public String toString()
	{
		return "Parent State";
	}
	private static parentloggedinState instance = new parentloggedinState();
	private parentloggedinState() {
	}
	public static State instance() {
		return instance;
	}
	public void build(LoginWindow ls) {
		ls.setSize(1280, 720);
		ls.remove(ls.panellogin);
		ls.revalidate();
		ls.repaint();
		ls.jp1 = new JPanel(); // JPanel för menyn med knappar
		
		ls.jp2 = new JPanel(); // Sidopanel med ev. information
		

		ls.jp3 = new JPanel(); // Mittenpanel med presentation av data
		

		ls.jp1.setBorder(new LineBorder(Color.red));
		ls.jp2.setBorder(new LineBorder(Color.blue));

		// Läs in kurser (Ersätt med db)
		ls.offsprings = new ArrayList<Student>();
		ls.offsprings.add(new Student("Rasmus", "123456768",
				"mammaspojk.live.se"));
		ls.offsprings.add(new Student("Bastian", "87654321",
				"intemammaspojk.dod.dk"));

		ls.courses = new ArrayList<Course>();
		ls.courses.add(new Course("123", "Historia A"));

		ls.courses.add(new Course("132", "Matte A"));

		String[] offspringsNames = new String[ls.offsprings.size()];
		for (int i = 0; i < ls.offsprings.size(); i++) {
			offspringsNames[i] = ls.offsprings.get(i).getPersonnummer();
		}

		String[] coursesNames = new String[ls.courses.size()];
		for (int i = 0; i < ls.courses.size(); i++) {
			coursesNames[i] = ls.courses.get(i).getCourseID();
		}
		// end

		// Dropdown med barnen
		ls.offspringPicker = new JComboBox<String>(offspringsNames);
		ls.offspringPicker.setActionCommand("set");
		ls.offspringPicker.addActionListener(ls.handler);
		ls.jp3.add(ls.offspringPicker);

		// Dropdown med barnets kurser
		ls.coursePicker = new JComboBox<String>(coursesNames);
		ls.coursePicker.setActionCommand("set");
		ls.coursePicker.addActionListener(ls.handler);
		ls.jp3.add(ls.coursePicker);

		// Knapp för att anmäla frånvaro
		ls.btnSubmit = new JButton("Anmäl");
		ls.btnSubmit.addActionListener(ls.handler);
		ls.jp3.add(ls.btnSubmit);

		// Logga ut knapp
		ls.btnlogout = new JButton("Logga ut");
		ls.btnlogout.addActionListener(ls.handler);
		ls.jp1.add(ls.btnlogout);
		
		ls.addpanel(ls.jp1, BorderLayout.WEST);
		ls.addpanel(ls.jp2, BorderLayout.EAST);
		ls.addpanel(ls.jp3, BorderLayout.CENTER);
	}
	public void Handle(LoginWindow ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogout) {
			// ls.login.terminateParent();
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
			String kid = (String) ls.offspringPicker.getSelectedItem();
			int y = -1;
			for (int i = 0; i < ls.offsprings.size(); i++) {
				if (ls.offsprings.get(i).getPersonnummer().equals(kid)) {
					y = i;
				}
			}
			ls.offsprings.get(y).registerAbsence(ls.courses.get(x), 1, "today");
		}
	}
}
