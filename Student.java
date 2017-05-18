package entites;

import java.util.ArrayList;

public class Student extends Entity{
	private int year;
	private ArrayList<Absence> absences;
	
	public Student()
	{
		super();
		year = -1;
		absences = null;
	}
	
	public Student(String name, int personnummer, String email, int year)
	{
		super(name, personnummer, email);
		this.year = year;
		absences = new ArrayList<Absence>();
	}
	
	public void registerAbsence(Course course, boolean unauthorizedAbsence, String date)
	{
		absences.add(new Absence(this, course, unauthorizedAbsence, date));
	}
	
	public void changeAbscent(boolean unauthorizedAbsence, int i)
	{
		absences.get(i).setUnauthorizedAbsence(unauthorizedAbsence);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Absence getAbsence(int i)
	{
		return absences.get(i);
	}
	
	public String toString()
	{
		String ss = this.getName() + " " + this.getPersonnummer() + " " + this.getEmail() + " " + year;
		return ss;
	}
}
