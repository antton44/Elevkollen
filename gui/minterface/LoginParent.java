package gui.minterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import domain.entities.Course;
import domain.entities.Student;

public class LoginParent extends JFrame {
	private static final long serialVersionUID = 4076671927942367366L;
	private Login login;	//Objekt av det tidigare fönstret, används vid utloggning
	private Handlerclass handler;	//ActionListener
	private JButton btnlogout;	//Knapp för att logga ut
	private JButton btnSubmit;	//Knapp för anmäla frånvaro
	private JComboBox<String> coursePicker;	//Dropdown med barnets kurser
	private ArrayList<Course> courses;	//Lista med barnets kurser
	private ArrayList<Student> offsprings;	//Lista med barn
	private JComboBox<String> offspringPicker;	//Dropdown med barnen
	
	public LoginParent(String name, Login login) {
		// vad vill föräldern kunna göra?
		super(name);
		this.login=login;
		handler = new Handlerclass();
		
		JPanel jp1 = new JPanel();	//JPanel för menyn med knappar
		super.add(jp1, BorderLayout.WEST);
		
		JPanel jp2 = new JPanel();	//Sidopanel med ev. information
		super.add(jp2, BorderLayout.EAST);
		
		JPanel jp3 = new JPanel();	//Mittenpanel med presentation av data
		super.add(jp3, BorderLayout.CENTER);
		
		jp1.setBorder(new LineBorder(Color.red));
		jp2.setBorder(new LineBorder(Color.blue));
		
		//Läs in kurser (Ersätt med db)
		offsprings = new ArrayList<Student>();
		offsprings.add(new Student("Rasmus", "123456768", "mammaspojk.live.se"));
		offsprings.add(new Student("Bastian", "87654321", "intemammaspojk.dod.dk"));
		
		courses = new ArrayList<Course>();
		courses.add(new Course("123", "Historia A"));
		
		courses.add(new Course("132", "Matte A"));

		String[] offspringsNames = new String[offsprings.size()];
		for(int i = 0; i < offsprings.size(); i++)
		{
			offspringsNames[i] = offsprings.get(i).getPersonnummer();
		}
		
		String[] coursesNames = new String[courses.size()];
		for(int i = 0; i < courses.size(); i++)
		{
			coursesNames[i] = courses.get(i).getCourseID();
		}
		//end
		
		//Dropdown med barnen
		offspringPicker = new JComboBox<String>(offspringsNames);
		offspringPicker.setActionCommand("set");
		offspringPicker.addActionListener(handler);
		jp3.add(offspringPicker);
		
		//Dropdown med barnets kurser
		coursePicker = new JComboBox<String>(coursesNames);
		coursePicker.setActionCommand("set");
		coursePicker.addActionListener(handler);
		jp3.add(coursePicker);

		//Knapp för att anmäla frånvaro
		btnSubmit = new JButton("Anmäl");
		btnSubmit.addActionListener(handler);
		jp3.add(btnSubmit);
		
		//Logga ut knapp
		btnlogout = new JButton("Logga ut");
		btnlogout.addActionListener(handler);
		jp1.add(btnlogout);
	}

	private class Handlerclass implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == btnlogout) 
			{
				login.terminateParent();
			}
			if (e.getSource() == btnSubmit) 
			{
				String choice = (String) coursePicker.getSelectedItem();
				int x = -1;
				for(int i = 0; i < courses.size(); i++)
				{
					if(courses.get(i).getCourseID().equals(choice))
					{
						x = i;
					}
				}
				String kid = (String) offspringPicker.getSelectedItem();
				int y = -1;
				for(int i = 0; i < offsprings.size(); i++)
				{
					if(offsprings.get(i).getPersonnummer().equals(kid))
					{
						y = i;
					}
				}
				offsprings.get(y).registerAbsence(courses.get(x), 1, "today");
			}
		}
	}
}