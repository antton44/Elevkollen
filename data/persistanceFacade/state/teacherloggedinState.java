package data.persistanceFacade.state;

import gui.minterface.AddMenu;
import gui.minterface.Login;
import gui.minterface.Window;
import gui.view.StudentController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import data.dataFacade.DataFacade;
import data.dataTransferObject.StudentDTO;
import domain.entities.Course;
import domain.entities.Student;

public class teacherloggedinState extends State{
	public String toString()
	{
		return "Teacher State";
	}
	private static teacherloggedinState instance = new teacherloggedinState();
	private teacherloggedinState() {
	}
	public static State instance() {
		return instance;
	}
	public void build(Login ls) {
		dFacade = new DataFacade();
		ls.setSize(1280,  720);
		ls.remove(ls.panellogin);
		ls.revalidate();
		ls.repaint();
		ls.sc = new StudentController();
		ls.courses = new ArrayList<Course>();
		
		ArrayList<Course> coursesFromStorage = new ArrayList<Course>();
		coursesFromStorage = dFacade.getCourse();
		for(int i = 0; i < coursesFromStorage.size(); i++)
		{
			ls.courses.add(new Course(coursesFromStorage.get(i).getCourseID(), coursesFromStorage.get(i).getCourseName()));
		}
			
		ArrayList<Student> students = dFacade.getStudents();
		for (int v = 0; v < ls.courses.size(); v++) 
		{
			for(int i = 0; i < students.size(); i++)
			{
				ls.courses.get(v)
					.addStudent(
						new StudentDTO(students.get(i).getName(), students.get(i).getPersonnummer(),
								students.get(i).getEmail()));
				ls.courses.get(v).getStudent(i)
					.registerAbsence(ls.courses.get(0), 0, "tus");
			}
		}

		// Menypanelen
		ls.jp1 = new JPanel();
		
		// H�gerpanelen
		ls.jp2 = new JPanel();
		

		// Mittenpanelen
		ls.jp3 = new JPanel();
		

		// Window objekt f�r att se alla studenter i kursen
		ls.window1 = new Window(ls.courses, ls.sc);
		ls.jp3.add(ls.window1, BorderLayout.CENTER);

		// L�rarens menyal
		ls.menu = new AddMenu(ls.jp3);
		ls.jp1.setBorder(new LineBorder(Color.red));
		ls.jp2.setBorder(new LineBorder(Color.blue));
		ls.jp1.setLayout(new GridBagLayout());

		// Menyvalet se alla studenter
		ls.btnSeeStudents = new JButton("See students");
		ls.btnSeeStudents.addActionListener(ls.handler);

		// Logga ut knappen
		ls.btnlogout = new JButton("Logga ut");
		ls.btnlogout.addActionListener(ls.handler);

		// Menylayout
		ls.gbc.gridx = 0;
		ls.gbc.gridy = 0;
		ls.jp1.add(ls.btnSeeStudents, ls.gbc);
		ls.gbc.gridx = 0;
		ls.gbc.gridy = 1;
		ls.jp1.add(ls.menu, ls.gbc);
		ls.gbc.gridx = 0;
		ls.gbc.gridy = 2;
		ls.jp1.add(ls.btnlogout, ls.gbc);
		
		
		
		
		ls.addpanel(ls.jp1, BorderLayout.WEST);
		ls.addpanel(ls.jp2, BorderLayout.EAST);
		ls.addpanel(ls.jp3, BorderLayout.CENTER);
	}
	public void Handle(Login ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogout) {
			// ls.login.terminateTeacher();
			ls.setState(loggedoffState.instance());
			ls.logout();
			ls.build();
		}
		if (e.getSource() == ls.btnSeeStudents) {
			ls.jp3.removeAll();
			ls.jp3.repaint();
			ls.jp3.revalidate();
			ls.jp3.add(new Window(ls.courses, ls.sc), BorderLayout.CENTER);
		}
	}
}
