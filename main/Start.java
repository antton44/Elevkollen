package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import gui.minterface.Login;

public class Start {

	public static void main(String[] args) {
		Login login = new Login();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(360, 600);
		login.setLayout(new BorderLayout());
		login.init();
		login.setVisible(true);
	}
}
