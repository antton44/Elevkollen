package domain.entities;

public class Absence {
	private Student absentStudent;
	private Course course;
	private int unauthorizedAbsence; //0 = ingen anm�lan, 1 = anm�ld fr�nvaro, 2 = ogilitig fr�nvaro
	private String date;
	
	public Absence()
	{
		this.absentStudent = new Student();
		this.course = new Course();
		this.unauthorizedAbsence = 0;
		this.setDate("");
	}
	
	public Absence(Student absentStudent, Course course, int unauthorizedAbsence, String date)
	{
		this.absentStudent = absentStudent;
		this.course = course;
		this.unauthorizedAbsence = unauthorizedAbsence;
		this.setDate(date);
	}

	public Student getAbsentStudent() {
		return absentStudent;
	}

	public void setAbsentStudent(Student absentStudent) {
		this.absentStudent = absentStudent;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getUnauthorizedAbsence() {
		return unauthorizedAbsence;
	}

	public void setUnauthorizedAbsence(int unauthorizedAbsence) {
		this.unauthorizedAbsence = unauthorizedAbsence;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
