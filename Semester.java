package entites;

public class Semester {
	private String semesterID;
	
	public Semester()
	{
		setSemesterID("");
	}
	
	public Semester(String id)
	{
		setSemesterID(id);
	}

	public String getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(String semesterID) {
		this.semesterID = semesterID;
	}
}
