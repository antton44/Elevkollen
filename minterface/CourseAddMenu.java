package minterface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import broker.CourseBroker;
import dto.ClassDTO;

@SuppressWarnings("serial")
public class CourseAddMenu extends JPanel {
	private JButton addBtn;		//Knapp för att lägga till kurser
	private JButton viewBtn;	//Knapp för att se kurser
	private JLabel courseIDLabel;	//Label för kursid
	private JTextField courseID;	//Textfält flr kursid
	private JLabel CourseNameLabel;	//LAbel för kursnamn
	private JTextField courseName;	//Textfält för kursnamn
	private GridBagConstraints gbc = new GridBagConstraints();	//Gridbaglayout för knapparna
	private ClassDTO d;	//DTO för kurser
	private JPanel panel; //Klassens JPanel
	Handlerclass handler;

	public CourseAddMenu() {
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		handler = new Handlerclass();
		super.add(panel, BorderLayout.WEST);	//ActionListener
		gbc.insets = new Insets(5, 5, 5, 5);	//Padding mellan componenter
		
		//Label för kursid
		gbc.gridx = 0;
		gbc.gridy = 0;
		courseIDLabel = new JLabel("KursID: ");
		courseIDLabel.setBounds(30, 30, 110, 10);
		panel.add(courseIDLabel, gbc);
		
		//Textfält för kursid
		gbc.gridx = 0;
		gbc.gridy = 1;
		courseID = new JTextField(20);
		courseID.setBounds(150, 25, 150, 20);
		panel.add(courseID, gbc);
		
		//Label för kursnamn
		gbc.gridx = 0;
		gbc.gridy = 2;
		CourseNameLabel = new JLabel("Namn: ");
		CourseNameLabel.setBounds(30, 60, 110, 10);
		panel.add(CourseNameLabel, gbc);
		
		//Textfält för kursnamn
		gbc.gridx = 0;
		gbc.gridy = 3;
		courseName = new JTextField(20);
		courseName.setBounds(150, 45, 150, 20);
		panel.add(courseName, gbc);
		
		//Lägg-till-kurs knapp
		gbc.gridx = 0;
		gbc.gridy = 6;
		addBtn = new JButton("Lägg till Kurs");
		addBtn.addActionListener(handler);
		panel.add(addBtn, gbc);
		
		//Se-kurser knapp
		gbc.gridx = 0;
		gbc.gridy = 7;
		viewBtn = new JButton("Se tillagda Kurser");
		viewBtn.addActionListener(handler);
		panel.add(viewBtn, gbc);
	}

	private class Handlerclass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String entry = courseID.getText();
			String entry2 = courseName.getText();
			String dto = entry + "---" + entry2; // 12345---Matematik
			//Broker
			CourseBroker cb = new CourseBroker();
			//Skapar ny klassdto med input (strängen  dto)
			d = new ClassDTO(dto);
			if(e.getSource() == addBtn){
				if(entry != null){
					try {
						//Skickar d (dto) till cb(brokern)
						cb.insertStorage(d);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}	
			} else if (e.getSource() == viewBtn) {
				try {
					cb.getFromStorage(d);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}