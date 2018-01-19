package gui.minterface;

//TODO: remove unused imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.ArrayList;
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
import domain.entities.Course;
import domain.entities.Student;
import data.persistanceFacade.broker.CourseBroker;
import gui.view.StudentController;

public class Login extends JFrame {
	static final long serialVersionUID = -6695746967101954108L;
	LoginBroker lb; // Broker för login
	JButton btnlogin; // Knapp för att logga in
	JPanel panellogin; // JPanel för logga in
	JTextField jtfUser; // Textfält som tar emot användarnamn (personnummer)
	JPasswordField jtfPassword; // Textfält som tar emot lösenord
	JLabel labelUser; // Label för användarnamn
	JLabel labelPassword; // Label för lösenord
	LoginObserver lobs; // Eclipse knasar, används faktiskt.
	DataTransferObject d;
	// Objekt av det tidigare fönstret, används vid utloggning
	// Handlerclass handler; //ActionListener
	// Knapp för att logga ut
	JButton btnSubmit; // Knapp för anmäla frånvaro
	JComboBox<String> coursePicker; // Dropdown med barnets kurser
	ArrayList<Course> courses; // Lista med barnets kurser
	ArrayList<Student> offsprings; // Lista med barn
	JComboBox<String> offspringPicker; // Dropdown med barnen
	// Login objekt, används för att logga ut
	// Handlerclass handler; //Databas handlern
	JButton btnlogout; // Logga ut knappen
	JButton btnSeeStudents; // Menyval f�r att se alla studenter i kursen
	// ArrayList med namnen p� kurserna
	Window window1; // Objekt f�r klassen window, anv�nds n�r listan med
					// studenter ska ses
	AddMenu menu; // L�gger till l�rarens menyval
	GridBagConstraints gbc = new GridBagConstraints(); // Layout i menyn
	JPanel jp1; // Menypanelen
	JPanel jp2; // h�ger panelen
	JPanel jp3; // Mitten panelen med data
	StudentController sc;
	Student loggedInAs;
	String name; // logged in from database
	State currentState;
	HandlerClass handler;

	public Login() {
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
	public Login lsinstance() {
		return this;
	}

	// handlerclass
	private class HandlerClass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentState.Handle(lsinstance(), e);
		}
	}
}

// STATES FOR LOGIN
class State {
	public void build(Login ls) {
	}
	public void Handle(Login ls, ActionEvent e) {
	}
	public void logout(Login ls){
		ls.remove(ls.jp1);
		ls.remove(ls.jp2);
		ls.remove(ls.jp3);
		ls.setSize(360, 600);
		ls.revalidate();
		ls.repaint();
	}
}

class loggedoffState extends State {
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
		System.out.println("handle 1");
		if (e.getSource() == ls.btnlogin) {
			System.out.println("handle 2");
			ls.lb = new LoginBroker();

			String dtos = ls.jtfUser.getText() + "---"
					+ ls.jtfPassword.getText();

			LoginDTO d = new LoginDTO(dtos);

			Object loginobject = null;
			try {
				loginobject = ls.lb.findInStorage(d);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			String loginstring = loginobject.toString();

			Object rs = null;
			StudentDTO sdto = new StudentDTO("", loginstring, "");
			StudentBroker sb = new StudentBroker();
			try {
				rs = sb.findInStorage(sdto);
				if (rs != null) {
					System.out.println("A");
					// ls.loginasstudent(loginstring);
					ls.setState(studentloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}

			TeacherDTO tdto = new TeacherDTO("", loginstring, "");
			TeacherBroker tb = new TeacherBroker();

			rs = null;
			System.out.println(loginstring);
			try {
				rs = tb.findInStorage(tdto);
				if (rs != null) {
					System.out.println("B");
					// ls.loginasteacher(loginstring);
					//ls.clear();
					ls.setState(teacherloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}

			rs = null;
			ParentDTO pdto = new ParentDTO("", loginstring, "");
			ParentBroker pb = new ParentBroker();
			try {
				rs = pb.findInStorage(pdto);
				if (rs != null) {
					System.out.println("C");
					// ls.loginasparent(loginstring);
					ls.setState(parentloggedinState.instance());
					ls.build();
				}
			} catch (Exception e2) {

			}
		}
	}
}

class teacherloggedinState extends State {
	public String toString()
	{
		return "Teacher State";
	}
	private static teacherloggedinState instance = new teacherloggedinState();
	private teacherloggedinState() {
	}
	public static State instance() {
		return instance;
	}
	public void build(Login ls) {
		ls.setSize(1280,  720);
		ls.remove(ls.panellogin);
		ls.revalidate();
		ls.repaint();
		ls.sc = new StudentController();
		ls.courses = new ArrayList<Course>();

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
			ls.courses.add(new Course(splitter[i], splitter[j]));
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

		for (int v = 0; v < ls.courses.size(); v++) {
			int r = 0;
			int t = 1;
			int y = 2;
			for (int k = 0; k < length; k++) {
				String[] splitter1 = s1.split("---|\\n");
				ls.courses.get(v)
						.addStudent(
								new StudentDTO(splitter1[r], splitter1[t],
										splitter1[y]));
				ls.courses.get(v).getStudent(k)
						.registerAbsence(ls.courses.get(0), 0, "tus");
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}

		// Menypanelen
		ls.jp1 = new JPanel();
		
		// H�gerpanelen
		ls.jp2 = new JPanel();
		

		// Mittenpanelen
		ls.jp3 = new JPanel();
		

		// Window objekt f�r att se alla studenter i kursen
		ls.window1 = new Window(ls.courses, ls.sc);
		ls.jp3.add(ls.window1, BorderLayout.CENTER);

		// L�rarens menyal
		ls.menu = new AddMenu(ls.jp3);
		ls.jp1.setBorder(new LineBorder(Color.red));
		ls.jp2.setBorder(new LineBorder(Color.blue));
		ls.jp1.setLayout(new GridBagLayout());

		// Menyvalet se alla studenter
		ls.btnSeeStudents = new JButton("See students");
		ls.btnSeeStudents.addActionListener(ls.handler);

		// Logga ut knappen
		ls.btnlogout = new JButton("Logga ut");
		ls.btnlogout.addActionListener(ls.handler);

		// Menylayout
		ls.gbc.gridx = 0;
		ls.gbc.gridy = 0;
		ls.jp1.add(ls.btnSeeStudents, ls.gbc);
		ls.gbc.gridx = 0;
		ls.gbc.gridy = 1;
		ls.jp1.add(ls.menu, ls.gbc);
		ls.gbc.gridx = 0;
		ls.gbc.gridy = 2;
		ls.jp1.add(ls.btnlogout, ls.gbc);
		
		
		
		
		ls.addpanel(ls.jp1, BorderLayout.WEST);
		ls.addpanel(ls.jp2, BorderLayout.EAST);
		ls.addpanel(ls.jp3, BorderLayout.CENTER);
	}
	public void Handle(Login ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogout) {
			// ls.login.terminateTeacher();
			ls.setState(loggedoffState.instance());
			ls.logout();
			ls.build();
		}
		if (e.getSource() == ls.btnSeeStudents) {
			ls.jp3.removeAll();
			ls.jp3.repaint();
			ls.jp3.revalidate();
			ls.jp3.add(new Window(ls.courses, ls.sc), BorderLayout.CENTER);
		}
	}
}
class studentloggedinState extends State {
	public String toString()
	{
		return "Student State";
	}
	private static studentloggedinState instance = new studentloggedinState();
	private studentloggedinState() {
	}
	public static State instance() {
		return instance;
	}
	public void build(Login ls) {
		ls.setSize(1280,  720);
		ls.remove(ls.panellogin);
		ls.revalidate();
		ls.repaint();
		
		ls.loggedInAs = new Student("Rasmus", ls.name, "Ras@ras.ras");
		// Meny panelen
		ls.jp1 = new JPanel();
		
		// Panelen till h�ger
		ls.jp2 = new JPanel();
		
		// Panelen i mitten med data
		ls.jp3 = new JPanel();
		
		ls.jp1.setBorder(new LineBorder(Color.red));
		ls.jp2.setBorder(new LineBorder(Color.blue));

		// L�s in kurser
		ls.courses = new ArrayList<Course>();
		ls.courses.add(new Course("123", "Historia A"));

		ls.courses.add(new Course("132", "Matte A"));

		String[] coursesNames = new String[ls.courses.size()];
		for (int i = 0; i < ls.courses.size(); i++) {
			coursesNames[i] = ls.courses.get(i).getCourseID();
		}

		// end

		// Dropdown med kurser
		ls.coursePicker = new JComboBox<String>(coursesNames);
		ls.coursePicker.setActionCommand("set");
		ls.coursePicker.addActionListener(ls.handler);
		ls.jp3.add(ls.coursePicker);

		// Anm�l knappen
		ls.btnSubmit = new JButton("Anmäl");
		ls.btnSubmit.addActionListener(ls.handler);
		ls.jp3.add(ls.btnSubmit);

		// Logga ut knappen
		ls.btnlogout = new JButton("Logga ut");
		ls.btnlogout.addActionListener(ls.handler);
		ls.jp1.add(ls.btnlogout);
		
		ls.addpanel(ls.jp1, BorderLayout.WEST);
		ls.addpanel(ls.jp2, BorderLayout.EAST);
		ls.addpanel(ls.jp3, BorderLayout.CENTER);
	}
	public void Handle(Login ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogout) {
			// ls.login.terminateStudent();
			ls.setState(loggedoffState.instance());
			ls.logout();
			ls.build();
		}
		if (e.getSource() == ls.btnSubmit) {
			String choice = (String) ls.coursePicker.getSelectedItem();
			int x = -1;
			for (int i = 0; i < ls.courses.size(); i++) {
				if (ls.courses.get(i).getCourseID().equals(choice)) {
					x = i;
				}
			}
			ls.loggedInAs.registerAbsence(ls.courses.get(x), 1, "today");
		}
	}
}
class parentloggedinState extends State {
	public String toString()
	{
		return "Parent State";
	}
	private static parentloggedinState instance = new parentloggedinState();
	private parentloggedinState() {
	}
	public static State instance() {
		return instance;
	}
	public void build(Login ls) {
		ls.setSize(1280, 720);
		ls.remove(ls.panellogin);
		ls.revalidate();
		ls.repaint();
		ls.jp1 = new JPanel(); // JPanel för menyn med knappar
		
		ls.jp2 = new JPanel(); // Sidopanel med ev. information
		

		ls.jp3 = new JPanel(); // Mittenpanel med presentation av data
		

		ls.jp1.setBorder(new LineBorder(Color.red));
		ls.jp2.setBorder(new LineBorder(Color.blue));

		// Läs in kurser (Ersätt med db)
		ls.offsprings = new ArrayList<Student>();
		ls.offsprings.add(new Student("Rasmus", "123456768",
				"mammaspojk.live.se"));
		ls.offsprings.add(new Student("Bastian", "87654321",
				"intemammaspojk.dod.dk"));

		ls.courses = new ArrayList<Course>();
		ls.courses.add(new Course("123", "Historia A"));

		ls.courses.add(new Course("132", "Matte A"));

		String[] offspringsNames = new String[ls.offsprings.size()];
		for (int i = 0; i < ls.offsprings.size(); i++) {
			offspringsNames[i] = ls.offsprings.get(i).getPersonnummer();
		}

		String[] coursesNames = new String[ls.courses.size()];
		for (int i = 0; i < ls.courses.size(); i++) {
			coursesNames[i] = ls.courses.get(i).getCourseID();
		}
		// end

		// Dropdown med barnen
		ls.offspringPicker = new JComboBox<String>(offspringsNames);
		ls.offspringPicker.setActionCommand("set");
		ls.offspringPicker.addActionListener(ls.handler);
		ls.jp3.add(ls.offspringPicker);

		// Dropdown med barnets kurser
		ls.coursePicker = new JComboBox<String>(coursesNames);
		ls.coursePicker.setActionCommand("set");
		ls.coursePicker.addActionListener(ls.handler);
		ls.jp3.add(ls.coursePicker);

		// Knapp för att anmäla frånvaro
		ls.btnSubmit = new JButton("Anmäl");
		ls.btnSubmit.addActionListener(ls.handler);
		ls.jp3.add(ls.btnSubmit);

		// Logga ut knapp
		ls.btnlogout = new JButton("Logga ut");
		ls.btnlogout.addActionListener(ls.handler);
		ls.jp1.add(ls.btnlogout);
		
		ls.addpanel(ls.jp1, BorderLayout.WEST);
		ls.addpanel(ls.jp2, BorderLayout.EAST);
		ls.addpanel(ls.jp3, BorderLayout.CENTER);
	}
	public void Handle(Login ls, ActionEvent e) {
		if (e.getSource() == ls.btnlogout) {
			// ls.login.terminateParent();
			ls.setState(loggedoffState.instance());
			ls.logout();
			ls.build();
		}
		if (e.getSource() == ls.btnSubmit) {
			String choice = (String) ls.coursePicker.getSelectedItem();
			int x = -1;
			for (int i = 0; i < ls.courses.size(); i++) {
				if (ls.courses.get(i).getCourseID().equals(choice)) {
					x = i;
				}
			}
			String kid = (String) ls.offspringPicker.getSelectedItem();
			int y = -1;
			for (int i = 0; i < ls.offsprings.size(); i++) {
				if (ls.offsprings.get(i).getPersonnummer().equals(kid)) {
					y = i;
				}
			}
			ls.offsprings.get(y).registerAbsence(ls.courses.get(x), 1, "today");
		}
	}
}
