package gui.state;

import gui.minterface.LoginWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import domain.domainFacade.DomainFacade;
import domain.entities.Parent;
import domain.entities.Student;
import domain.entities.Teacher;
import domain.entities.Login;

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
	public void build(LoginWindow ls) {
		dFacade = new DomainFacade();
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
	public void Handle(LoginWindow ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogin) {

			String dtos = ls.jtfUser.getText() + "---"
					+ ls.jtfPassword.getText();

			obj = dFacade.findLogin(dtos);
			
			loginString = obj.getLoginId();
			Student tempS = new Student("", loginString, "");
			try {
				Student sObj = dFacade.find(tempS);
				if (sObj != null) {
					ls.setState(studentloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}

			Teacher tempT = new Teacher("", loginString, "");
			try {
				Teacher tObj = dFacade.find(tempT);
				if (tObj != null) {
					ls.setState(teacherloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}

			Parent tempP = new Parent("", loginString, "");
			try {
				Parent pObj = dFacade.find(tempP);
				if (pObj != null) {
					ls.setState(parentloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}
		}
	}
}
