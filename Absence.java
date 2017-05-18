package entites;

public class Absence {
	private Student absentStudent;
	private Course course;
	private Boolean unauthorizedAbsence;
	private String date;
	
	public Absence()
	{
		this.absentStudent = new Student();
		this.course = new Course();
		this.unauthorizedAbsence = false;
		this.setDate("");
	}
	
	public Absence(Student absentStudent, Course course, Boolean unauthorizedAbsence, String date)
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

	public Boolean getUnauthorizedAbsence() {
		return unauthorizedAbsence;
	}

	public void setUnauthorizedAbsence(Boolean unauthorizedAbsence) {
		this.unauthorizedAbsence = unauthorizedAbsence;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
