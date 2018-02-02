package data.dataTransferObject;

import java.util.UUID;

import domain.entities.Course;
import domain.entities.Student;

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
