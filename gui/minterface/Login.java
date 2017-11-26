package gui.minterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import data.dataTransferObject.DataTransferObject;
import data.dataTransferObject.LoginDTO;
import data.dataTransferObject.ParentDTO;
import data.dataTransferObject.StudentDTO;
import data.dataTransferObject.TeacherDTO;
import data.persistanceFacade.broker.LoginBroker;
import data.persistanceFacade.broker.ParentBroker;
import data.persistanceFacade.broker.StudentBroker;
import data.persistanceFacade.broker.TeacherBroker;
import observer.LoginObserver;


public class Login extends JFrame {
	private static final long serialVersionUID = -6695746967101954108L;	//Finns för att slippa varning
	private LoginBroker lb;		//Broker för login
	private JButton btnlogin;	//Knapp för att logga in
	private JPanel panellogin;	//JPanel för logga in
	private JTextField jtfUser;		//Textfält som tar emot användarnamn (personnummer) 
	private JPasswordField jtfPassword;	//Textfält som tar emot lösenord
	private JLabel labelUser;	//Label för användarnamn
	private JLabel labelPassword;	//Label för lösenord
	private LoginTeacher lt;	//LoginTeacher object, används för att öppna nästa fönster	
	private LoginStudent ls;	//LoginStudent object, används för att öppna nästa fönster	
	private LoginParent lp;		//LoginParent object, används för att öppna nästa fönster
	private LoginObserver lobs; // Eclipse knasar, används faktiskt.
	private DataTransferObject d;

	public Login() {
		super("Elevkollen - Logga in");
	}

	public void addComponents() {
		panellogin = new JPanel();
		panellogin.setBorder(new LineBorder(Color.BLACK));
		super.add(panellogin, BorderLayout.CENTER);
		Handlerclass handler = new Handlerclass();

		//Användarnamn label
		labelUser = new JLabel("Användarnamn");
		labelUser.setBounds(30, 30, 110, 10);
		panellogin.add(labelUser);
		
		//Användarnamn textfält
		jtfUser = new JTextField(15);
		jtfUser.setBounds(150, 25, 150, 20);
		panellogin.add(jtfUser);
		
		//Lösenord label
		labelPassword = new JLabel("Lösenord");
		labelPassword.setBounds(30, 70, 110, 10);
		panellogin.add(labelPassword);
		
		//Lösenord textfält
		jtfPassword = new JPasswordField(15);
		jtfPassword.setBounds(150, 65, 150, 20);
		panellogin.add(jtfPassword);
		
		//Login knapp
		btnlogin = new JButton("Logga in");
		btnlogin.setBounds(30, 100, 270, 50);
		btnlogin.addActionListener(handler);
		panellogin.add(btnlogin);

		repaint();
	}

	public void loginasstudent(String name) {
		this.setVisible(false);
		//Öppnar nytt LoginStudent fönster och stänger gamla loginfönstret
		ls = new LoginStudent(name, this);
		ls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ls.setVisible(true);
		ls.setSize(1280, 720);
		lobs = new LoginObserver(d);
		d.attach(lobs);
		d.notifyAllObservers();
	}

	public void loginasteacher(String name) {
		this.setVisible(false);
		lt = new LoginTeacher(name, this);
		//Öppnar nytt LoginTeacher fönster och stänger gamla loginfönstret
		lt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lt.setVisible(true);
		lt.setSize(1280, 720);
		lobs = new LoginObserver(d);
		d.attach(lobs);
		d.notifyAllObservers();
	}

	public void loginasparent(String name) {
		this.setVisible(false);
		//Öppnar nytt LoginParent fönster och stänger gamla loginfönstret
		lp = new LoginParent(name, this);
		lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lp.setVisible(true);
		lp.setSize(1280, 720);
		lobs = new LoginObserver(d);
		d.attach(lobs);
		d.notifyAllObservers();
	}

	//Stänger LoginParentfönstret och öppnar detta fönstret
	public void terminateParent() {
		this.lp.setVisible(false);
		this.lp = null;
		this.setVisible(true);
	}

	//Stänger LoginStudentfönstret och öppnar detta fönstret
	public void terminateStudent() {
		this.ls.setVisible(false);
		this.ls = null;
		this.setVisible(true);
	}

	//Stänger LoginTeacherfönstret och öppnar detta fönstret
	public void terminateTeacher() {
		this.lt.setVisible(false);
		this.lt = null;
		this.setVisible(true);
	}

	private class Handlerclass implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnlogin) {
				
				lb = new LoginBroker();
			
			String dtos = jtfUser.getText() + "---" + jtfPassword.getText();
			
			LoginDTO d = new LoginDTO(dtos);
			
			Object loginobject = null;
			try {
				loginobject = lb.findInStorage(d);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				String loginstring = loginobject.toString();
				
				Object rs = null;
				StudentDTO sdto = new StudentDTO("", loginstring, "");
				StudentBroker sb = new StudentBroker();
				try{
					rs = sb.findInStorage(sdto);
					if(rs != null){
						loginasstudent(loginstring);
					}
				}catch(Exception e2){
					
				}
				
				TeacherDTO tdto = new TeacherDTO(loginstring);
				TeacherBroker tb = new TeacherBroker();
				
				rs=null;
				System.out.println(loginstring);
				try{
					rs = tb.findInStorage(tdto);
					if(rs != null){
						loginasteacher(loginstring);
					}
				}catch(Exception e2){
					
				}
				
				rs = null;
				ParentDTO pdto = new ParentDTO(loginstring);
				ParentBroker pb = new ParentBroker();
				try{
					rs = pb.findInStorage(pdto);
					if(rs != null){
						loginasparent(loginstring);
					}
				}catch(Exception e2){
					
				}
			}
		}
	}
}
