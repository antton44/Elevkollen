package domain.entities;

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
	
	public Student(String name, String personnummer, String email)
	{
		super(name, personnummer, email);
		this.year = 7;
		absences = new ArrayList<Absence>();
	}
	
	public void registerAbsence(Course course, int unauthorizedAbsence, String date)
	{
		absences.add(new Absence(this, course, unauthorizedAbsence, date));
	}
	
	public void changeAbscent(int unauthorizedAbsence, int i)
	{
		absences.get(i).setUnauthorizedAbsence(unauthorizedAbsence);
	}
	
	public void changeAbscentWithString(String unauthorizedAbsence, int i)
	{
		if(unauthorizedAbsence.isEmpty())
		{
			absences.add(new Absence(this, new Course(), 0, "wed"));
		}
		
		if(unauthorizedAbsence.equals("Ogiltig"))
		{
			absences.get(i).setUnauthorizedAbsence(2);
		}
		else if(unauthorizedAbsence.equals("anm�ld"))
		{
			absences.get(i).setUnauthorizedAbsence(1);
		}
	}

	public String getAbsenceToString(int i)
	{
		if(absences.isEmpty() || absences.get(i).getUnauthorizedAbsence() == 0)
		{
			return "Ingen registrerad fr�nvaro";
		}
		else if(absences.get(i).getUnauthorizedAbsence() == 1) 
		{
			return "Anm�ld fr�nvaro";
		}
		else if(absences.get(i).getUnauthorizedAbsence() == 2)
		{
			return "Registrerad ogilltig fr�nvaro";
		}
		return "Ingen registrerad fr�nvaro";
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
