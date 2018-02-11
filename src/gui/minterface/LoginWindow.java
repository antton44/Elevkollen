package gui.minterface;

//TODO: move states into own classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import domain.entities.Course;
import domain.entities.Student;
import gui.state.State;
import gui.state.loggedoffState;
import gui.view.StudentController;

public class LoginWindow extends JFrame {
	static final long serialVersionUID = -6695746967101954108L;
	public JButton btnlogin; // Knapp för att logga in
	public JPanel panellogin; // JPanel för logga in
	public JTextField jtfUser; // Textfält som tar emot användarnamn (personnummer)
	public JPasswordField jtfPassword; // Textfält som tar emot lösenord
	public JLabel labelUser; // Label för användarnamn
	public JLabel labelPassword; // Label för lösenord
	// Objekt av det tidigare fönstret, används vid utloggning
	// Handlerclass handler; //ActionListener
	// Knapp för att logga ut
	public JButton btnSubmit; // Knapp för anmäla frånvaro
	public JComboBox<String> coursePicker; // Dropdown med barnets kurser
	public ArrayList<Course> courses; // Lista med barnets kurser
	public ArrayList<Student> offsprings; // Lista med barn
	public JComboBox<String> offspringPicker; // Dropdown med barnen
	// Login objekt, används för att logga ut
	// Handlerclass handler; //Databas handlern
	public JButton btnlogout; // Logga ut knappen
	public JButton btnSeeStudents; // Menyval f�r att se alla studenter i kursen
	// ArrayList med namnen p� kurserna
	public Window window1; // Objekt f�r klassen window, anv�nds n�r listan med
					// studenter ska ses
	public AddMenu menu; // L�gger till l�rarens menyval
	public GridBagConstraints gbc = new GridBagConstraints(); // Layout i menyn
	public JPanel jp1; // Menypanelen
	public JPanel jp2; // h�ger panelen
	public JPanel jp3; // Mitten panelen med data
	public StudentController sc;
	public Student loggedInAs;
	public String name; // logged in from database
	State currentState;
	public HandlerClass handler;

	public LoginWindow() {
		super("Elevkollen");
	}
	public void init() {
		handler = new HandlerClass();
		currentState = loggedoffState.instance();
		build();
	}
	public void setState(State s) {
		currentState = s;
		System.out.print("State = ");
		System.out.println(s.toString());
	}
	public void addpanel(JPanel jc, String bl) {
		super.add(jc, bl);
	}
	public void build() {
		currentState.build(this);
		repaint();
	}
	public void logout()
	{
		currentState.logout(this);
	}
	public LoginWindow lsinstance() {
		return this;
	}

	// handlerclass
	private class HandlerClass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentState.Handle(lsinstance(), e);
		}
	}
}
