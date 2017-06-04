package minterface;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import entities.Course;

public class StudentTable extends JPanel implements TableModelListener{
	private static final long serialVersionUID = 1L;
	private Course course;	//Den valda kursen
	private String[] columnNames = {"Personnummer", "Namn", "Email", "�rskurs", "Anm�ld fr�nvaro", "Fr�nvaro"};
	private String[] absences = { "Ogiltig", "anm�ld" };	//Alternativ f�r fr�nvaro anm�lning
	private Object[][] data;	//Inneh�llet i tabellen
	private JTable table = new JTable();	//Tabellen med alla studenter
	private DefaultTableModel tableModel;	//Tabellmodellen
	private JPanel panel = new JPanel();

	//Konstruktor
	public StudentTable(Course course) {
		super.setSize(20, 10);
		panel.setLayout(new BorderLayout());
		
		this.course = course;											//Tar emot den valda kursen
		JComboBox<String> myComboBox = new JComboBox<String>(absences);	//Skapar dropdownen med fr�nvaro alternativen
		reloadData();													//Laddar in inneh�llet till tabellen
		tableModel = new DefaultTableModel(data, columnNames);	//L�gger in studenterna i modellen
		
		tableModel.setColumnIdentifiers(columnNames);	//L�gger till kolumnnamnen
		table = new JTable(tableModel);					//Skapar tabellen utefter modellen
		table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(myComboBox));	//L�gger till fr�nvaro dropdownen
		table.getModel().addTableModelListener(this);	//L�gger till en tabell lyssnare
		setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.PAGE_START);	
		add(table, BorderLayout.CENTER);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

	public void reloadData()
	{
		data = null;
		data = new String[course.getSize()][columnNames.length];	//Instansierar data arrayen
		for(int i = 0; i < course.getSize(); i++)			//Loopar igenom och l�gger in alla data i arrayen
		{
			for(int j = 0; j < columnNames.length; j++)
			{
				switch(j) {
				case 0:
					data[i][j] = course.getStudent(i).getPersonnummer();
					break;
				case 1:
					data[i][j] = course.getStudent(i).getName();
					break;
				case 2:
					data[i][j] = course.getStudent(i).getEmail();
					break;
				case 3:
					data[i][j] = Integer.toString(course.getStudent(i).getYear());
					break;
				case 4:
					data[i][j] = course.getStudent(i).getAbsenceToString(0);
					break;
				}
			}
		}
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
			System.out.println(change);
			course.getStudent(row).changeAbscentWithString(change, 0);
			table.setValueAt(course.getStudent(row).getAbsenceToString(0), row, col-1);
			tableModel.fireTableDataChanged();
		}
		
	}
}
