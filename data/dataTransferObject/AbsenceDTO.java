package data.dataTransferObject;

@SuppressWarnings("serial")
public class AbsenceDTO extends DataTransferObject{
	public StudentDTO absentStudent;
	public CourseDTO course;
	public Boolean unauthorizedAbsence;
	
	public AbsenceDTO(StudentDTO absentStudent, CourseDTO course, Boolean unauthorizedAbsence)
	{
		this.absentStudent = absentStudent;
		this.course = course;
		this.unauthorizedAbsence = unauthorizedAbsence;
	}

	@Override
	public String toString() {
		return absentStudent.toString() + course.toString() + unauthorizedAbsence;
	}
}
