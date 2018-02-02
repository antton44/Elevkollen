package data.persistanceFacade.state;

import gui.minterface.Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import data.dataFacade.DataFacade;
import domain.entities.Parent;
import domain.entities.Student;
import domain.entities.Teacher;

public class loggedoffState extends State{
	private String loginString;
	public String toString()
	{
		return "Logged Off State";
	}
	private static loggedoffState instance = new loggedoffState();
	private loggedoffState() {
	}
	public static State instance() {
		return instance;
	}
	public void build(Login ls) {
		dFacade = new DataFacade();
		ls.panellogin = new JPanel();
		ls.panellogin.setBorder(new LineBorder(Color.BLACK));

		// Användarnamn label
		ls.labelUser = new JLabel("Användarnamn");
		ls.labelUser.setBounds(30, 30, 110, 10);
		ls.panellogin.add(ls.labelUser);

		// Användarnamn textfält
		ls.jtfUser = new JTextField(15);
		ls.jtfUser.setBounds(150, 25, 150, 20);
		ls.panellogin.add(ls.jtfUser);

		// Lösenord label
		ls.labelPassword = new JLabel("Lösenord");
		ls.labelPassword.setBounds(30, 70, 110, 10);
		ls.panellogin.add(ls.labelPassword);

		// Lösenord textfält
		ls.jtfPassword = new JPasswordField(15);
		ls.jtfPassword.setBounds(150, 65, 150, 20);
		ls.panellogin.add(ls.jtfPassword);

		// Login knapp
		ls.btnlogin = new JButton("Logga in");
		ls.btnlogin.setBounds(30, 100, 270, 50);
		ls.btnlogin.addActionListener(ls.handler);
		ls.panellogin.add(ls.btnlogin);
		ls.addpanel(ls.panellogin, BorderLayout.CENTER);
	}
	public void Handle(Login ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogin) {

			String dtos = ls.jtfUser.getText() + "---"
					+ ls.jtfPassword.getText();

			obj = dFacade.FindLogin(dtos);
			loginString = obj.toString();

			obj = null;
			Student tempS = new Student("", loginString, "");
			try {
				obj = dFacade.findStudent(tempS);
				System.out.println(obj.toString());
				if (obj != null) {
					ls.setState(studentloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}

			Teacher tempT = new Teacher("", loginString, "");

			obj = null;
			try {
				obj = dFacade.findTeacher(tempT);
				if (obj != null) {
					ls.setState(teacherloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}

			obj = null;
			Parent tempP = new Parent("", loginString, "");
			try {
				obj = dFacade.findParent(tempP);
				if (obj != null) {
					ls.setState(parentloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}
		}
	}
}
