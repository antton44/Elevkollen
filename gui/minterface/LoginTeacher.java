package gui.minterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import data.dataTransferObject.StudentDTO;
import data.persistanceFacade.broker.CourseBroker;
import data.persistanceFacade.broker.StudentBroker;
import domain.entities.Course;
import gui.view.StudentController;

public class LoginTeacher extends JFrame {
	private static final long serialVersionUID = 1L;
	private Login login;		//Login objekt, används för att logga ut
	private Handlerclass handler;	//Databas handlern
	private JButton btnlogout;		//Logga ut knappen
	private JButton btnSeeStudents;	//Menyval f�r att se alla studenter i kursen
	private ArrayList<Course> courses;	//ArrayList med namnen p� kurserna
	private Window window1;	//Objekt f�r klassen window, anv�nds n�r listan med studenter ska ses
	private AddMenu menu;	//L�gger till l�rarens menyval
	private GridBagConstraints gbc = new GridBagConstraints();	//Layout i menyn
	private JPanel jp1;	//Menypanelen
	private JPanel jp2; //h�ger panelen
	private JPanel jp3;	//Mitten panelen med data
	private StudentController sc;

	public LoginTeacher(String name, Login login) {
		super(name);
		sc = new StudentController();
		init();
		this.login = login;
		
		//Menypanelen
		jp1 = new JPanel();
		super.add(jp1, BorderLayout.WEST);
		
		//H�gerpanelen
		jp2 = new JPanel();
		super.add(jp2, BorderLayout.EAST);
		
		//Mittenpanelen
		jp3 = new JPanel();
		super.add(jp3, BorderLayout.CENTER);
		
		//Window objekt f�r att se alla studenter i kursen
		window1 = new Window(courses, sc);
		jp3.add(window1, BorderLayout.CENTER);
		
		//L�rarens menyal
		menu = new AddMenu(jp3);
		jp1.setBorder(new LineBorder(Color.red));
		jp2.setBorder(new LineBorder(Color.blue));
		jp1.setLayout(new GridBagLayout());
		
		//Handler klassen
		handler = new Handlerclass();
		
		//Menyvalet se alla studenter
		btnSeeStudents = new JButton("See students");
		btnSeeStudents.addActionListener(handler);
		
		//Logga ut knappen
		btnlogout = new JButton("Logga ut");
		btnlogout.addActionListener(handler);
		
		//Menylayout
		gbc.gridx = 0;
		gbc.gridy = 0;
		jp1.add(btnSeeStudents, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		jp1.add(menu, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		jp1.add(btnlogout, gbc);
	}
	
	public void init() {
		courses = new ArrayList<Course>();

		CourseBroker cb = new CourseBroker();
		Object d = null;
		try {
			d = cb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String s = d.toString();

		String[] test2 = s.split("\\n");
		int length2 = test2.length;
		int i = 0;
		int j = 1;
		for (int q = 0; q < length2; q++) {
			String[] splitter = s.split("---|\\n");
			courses.add(new Course(splitter[i], splitter[j]));
			i = i + 2;
			j = j + 2;
		}

		StudentBroker sb = new StudentBroker();
		Object student = null;
		try {
			student = sb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String s1 = student.toString();
		String[] test = s1.split("\\n");
		int length = test.length;
		
		for (int v = 0; v < courses.size(); v++) {
			int r = 0;
			int t = 1;
			int y = 2;
			for (int k = 0; k < length; k++) {
				String[] splitter1 = s1.split("---|\\n");
				courses.get(v).addStudent(new StudentDTO(splitter1[r], splitter1[t],splitter1[y]));
				courses.get(v).getStudent(k).registerAbsence(courses.get(0), 0, "tus");
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
	}
	
	private class Handlerclass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnlogout) {
				login.terminateTeacher();
			}
			if (e.getSource() == btnSeeStudents) {
				jp3.removeAll();
				jp3.repaint();
				jp3.revalidate();
				jp3.add(new Window(courses, sc), BorderLayout.CENTER);
			}
		}
	}
}
