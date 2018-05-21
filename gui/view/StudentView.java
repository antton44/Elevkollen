package gui.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import domain.entities.Student;

public class StudentView extends JPanel implements TableModelListener{
	private static final long serialVersionUID = 1L;
	//private Course course;	//Den valda kursen
	private String[] columnNames = {"Personnummer", "Namn", "Email", "�rskurs", "Anm�ld fr�nvaro", "Fr�nvaro"};
	private String[] absences = { "Ogiltig", "anm�ld" };	//Alternativ f�r fr�nvaro anm�lning
	private Object[][] data;	//Inneh�llet i tabellen
	private JTable table = new JTable();	//Tabellen med alla studenter
	private DefaultTableModel tableModel;	//Tabellmodellen
	private JPanel panel = new JPanel();
	private ArrayList<Student> students;
	private JComboBox<String> myComboBox;

	//Konstruktor
	public StudentView() {
		super.setSize(20, 10);
		panel.setLayout(new BorderLayout());
		students = new ArrayList<Student>();
		//this.course = course;											//Tar emot den valda kursen
		myComboBox = new JComboBox<String>(absences);	//Skapar dropdownen med fr�nvaro alternativen
		//reloadData();													//Laddar in inneh�llet till tabellen
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

	public void reloadData(ArrayList<Student> students)
	{
		data = null;
		data = new String[students.size()][columnNames.length];	//Instansierar data arrayen
		for(int i = 0; i < students.size(); i++)			//Loopar igenom och l�gger in alla data i arrayen
		{
			for(int j = 0; j < columnNames.length; j++)
			{
				switch(j) {
				case 0:
					data[i][j] = students.get(i).getPersonnummer();
					break;
				case 1:
					data[i][j] = students.get(i).getName();
					break;
				case 2:
					data[i][j] = students.get(i).getEmail();
					break;
				case 3:
					data[i][j] = Integer.toString(students.get(i).getYear());
					break;
				case 4:
					data[i][j] = students.get(i).getAbsenceToString(0);
					break;
				}
			}
		}
		tableModel = new DefaultTableModel(data, columnNames);	//L�gger in studenterna i modellen
		tableModel.setColumnIdentifiers(columnNames);	//L�gger till kolumnnamnen
		table = new JTable(tableModel);					//Skapar tabellen utefter modellen
		table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(myComboBox));	//L�gger till fr�nvaro dropdownen
		table.getModel().addTableModelListener(this);	//L�gger till en tabell lyssnare
		setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.PAGE_START);	
		add(table, BorderLayout.CENTER);
	}
	
	@Override
	public void tableChanged(TableModelEvent e)	//Lyssnar efter anv�ndning av dropdownen och �ndrar fr�nvaro status om den anv�nds
	{
		int row = e.getFirstRow();
		int col = e.getColumn();
		if(col == 5)
		{
			Object changedData = table.getValueAt(row, col);
			String change = changedData.toString();
			students.get(row).changeAbscentWithString(change, 0);
			table.setValueAt(students.get(row).getAbsenceToString(0), row, col-1);
			tableModel.fireTableDataChanged();
		}
		
	}
}
