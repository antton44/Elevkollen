package gui.minterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class AddMenu extends JPanel{
	private JButton Semesterbtn;	//Knapp för att nå klassen SemesterAddMenu
	private JButton Coursebtn;	//Knapp för att nå klassen CourseAddMenu
	private JButton Userbtn;	//Knapp för att nå klassen UserAddMenu
	private JPanel panelAddMenu = new JPanel();	//Panel för knapparna
	private GridBagConstraints gbc = new GridBagConstraints();	//Gridbaglayout för knapparna
	private JPanel center;	//Tar emot jpanel som ligger i mitten av skärmen från LoginTeacher
	
	public AddMenu(JPanel center){
		super.setSize(20, 10);
		this.center = center;
		panelAddMenu.setLayout(new GridBagLayout());
		panelAddMenu.setBorder(new LineBorder(Color.black));
		Handlerclass handler = new Handlerclass();	//ActionListener klassen
		gbc.insets = new Insets(5, 5, 5, 5);	//Padding mellan knapparna
		
		//Terminsknapp
		Semesterbtn = new JButton("Terminkontroller");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelAddMenu.add(Semesterbtn, gbc);
		Semesterbtn.addActionListener(handler);
		
		//Kursknapp
		Coursebtn = new JButton("Kurskontroller");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelAddMenu.add(Coursebtn, gbc);
		Coursebtn.addActionListener(handler);
		
		//Användarknapp
		Userbtn = new JButton("Användarkontroller");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelAddMenu.add(Userbtn, gbc);
		Userbtn.addActionListener(handler);
		
		super.add(panelAddMenu);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	//Sammanfattning av metoden: Tar bort tidigare componenter och lägg till ny vald component
	private class Handlerclass implements ActionListener {
		public void actionPerformed(ActionEvent e) {	
			if (e.getSource() == Semesterbtn) {	
				center.removeAll();
				center.repaint();
				center.revalidate();
				center.add(new SemesterAddMenu(), BorderLayout.CENTER);
			}else if(e.getSource() == Coursebtn){
				center.removeAll();
				center.repaint();
				center.revalidate();
				center.add(new CourseAddMenu(), BorderLayout.CENTER);
			}else if(e.getSource() == Userbtn){
				center.removeAll();
				center.repaint();
				center.revalidate();
				center.add(new UserAddMenu(), BorderLayout.CENTER);
			}
		}
	}
}
