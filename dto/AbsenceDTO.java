package dto;

import entities.Course;
import entities.Student;

public class AbsenceDTO extends DataTransferObject{
	public Student absentStudent;
	public Course course;
	public Boolean unauthorizedAbsence;
	
	public AbsenceDTO(Student absentStudent, Course course, Boolean unauthorizedAbsence)
	{
		this.absentStudent = absentStudent;
		this.course = course;
		this.unauthorizedAbsence = unauthorizedAbsence;
	}
}
