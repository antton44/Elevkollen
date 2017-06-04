package minterface;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Semester;

@SuppressWarnings("serial")
public class SemesterAddMenu extends JPanel{
	private JButton addBtn;	//Knappen f�r att l�gga till en termin
	private JTextField semesterID;	//Textf�lt som tar emot terminens namn
	private JLabel semesterIDLabel;	//Label f�r textf�ltet
	private Semester s;
	
	public SemesterAddMenu(){
		JPanel panel = new JPanel();

		super.add(panel, BorderLayout.WEST);
		Handlerclass handler2 = new Handlerclass();

		//Label
		semesterIDLabel = new JLabel("Termin: ");
		semesterIDLabel.setBounds(30, 30, 110, 10);
		panel.add(semesterIDLabel);
		
		//Textf�ltet
		semesterID = new JTextField(20);
		semesterID.setBounds(150,25,150,20);
		panel.add(semesterID);
		
		//Knappen
		addBtn = new JButton("L�gg till Termin");
		addBtn.addActionListener(handler2);
		panel.add(addBtn);
	}
	
	public void semester(String entry){
		s = new Semester(entry);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	private class Handlerclass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String entry = semesterID.getText();
			if (e.getSource() == addBtn) {
				semester(entry);
			}
		}
	}
}
