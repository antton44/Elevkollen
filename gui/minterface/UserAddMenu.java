package gui.minterface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.dataFacade.IDataState;
import data.dataTransferObject.ParentDTO;
import data.dataTransferObject.StudentDTO;
import data.dataTransferObject.TeacherDTO;
import data.persistanceFacade.broker.ParentBroker;
import data.persistanceFacade.broker.StudentBroker;
import data.persistanceFacade.broker.TeacherBroker;
import data.persistanceFacade.state.NewDataState;

@SuppressWarnings("serial")
public class UserAddMenu extends JPanel {

	@SuppressWarnings("unused")
	private Handlerclass handler2;	
	private JButton addBtn;
	private JButton viewBtn;
	private JTextField userID;
	private JLabel userIDLabel;
	private JTextField userName;
	private JLabel UserNameLabel;
	private JTextField userEmail;
	private JLabel userEmailLabel;
	private JComboBox<String> userType;
	private GridBagConstraints gbc = new GridBagConstraints();
	private ParentDTO p;
	private StudentDTO s;
	private data.dataTransferObject.TeacherDTO t;
	private IDataState oldCleanDataState;


	public UserAddMenu() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		Handlerclass handler2 = new Handlerclass();

		super.add(panel, BorderLayout.WEST);
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		userIDLabel = new JLabel("Personummer: ");
		userIDLabel.setBounds(30, 30, 110, 10);
		panel.add(userIDLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		userID = new JTextField(20);
		userID.setBounds(150, 25, 150, 20);
		panel.add(userID, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		UserNameLabel = new JLabel("Namn: ");
		UserNameLabel.setBounds(60, 30, 110, 10);
		panel.add(UserNameLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		userName = new JTextField(20);
		userName.setBounds(170, 50, 150, 20);
		panel.add(userName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		userEmailLabel = new JLabel("Email: ");
		userEmailLabel.setBounds(90, 60, 110, 10);
		panel.add(userEmailLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		userEmail = new JTextField(20);
		userEmail.setBounds(190, 25, 150, 20);
		panel.add(userEmail, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		addBtn = new JButton("L�gg till Anv�ndare");
		addBtn.addActionListener(handler2);
		panel.add(addBtn, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		viewBtn = new JButton("Se tillagda Anv�ndare");
		viewBtn.addActionListener(handler2);
		panel.add(viewBtn, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		String[] userTypeStrings = {"Student", "Parent", "Teacher"};
		userType = new JComboBox<String>(userTypeStrings);
		userType.setSelectedIndex(2);
		userType.addActionListener(handler2);
		panel.add(userType, gbc);
		
	}


	private class Handlerclass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String table = (String) userType.getSelectedItem();
			String entry = userID.getText() + "---";
			String entry2 = userName.getText() + "---";
			String entry3 = userEmail.getText();

			String dto = entry + "---" + entry2 + "---" + entry3;

			switch (table) {
			case "Teacher":
				TeacherBroker tb = new TeacherBroker();
				t = new TeacherDTO(dto);
				oldCleanDataState.insert(t);
				if (e.getSource() == addBtn) {
					if (entry != null) {
						try {
							tb.insertStorage(t);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (e.getSource() == viewBtn) {
					try {
						tb.getFromStorage(t);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
				}
				break;
			case "Student":
				StudentBroker sb = new StudentBroker();
				
				s = new StudentDTO(entry, entry2, entry3);
				NewDataState nds = new NewDataState();
				nds.insert(s);
				s.setState(nds);
				System.out.println(s.getState());
				if (e.getSource() == addBtn) {
					if (entry != null) {
						try {
							sb.insertStorage(s);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (e.getSource() == viewBtn) {
					try {
						sb.getFromStorage(s);
						System.out.println(s);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
				}
				break;
			case "Parent":
				ParentBroker pb = new ParentBroker();
				p = new ParentDTO(dto);
				if (e.getSource() == addBtn) {
					if (entry != null) {
						try {
							pb.insertStorage(p);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (e.getSource() == viewBtn) {
					try {
						pb.getFromStorage(p);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
				}
				break;
			}
		}
	}
}
