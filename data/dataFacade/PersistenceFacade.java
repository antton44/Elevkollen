package data.dataFacade;

import java.sql.SQLException;

import data.persistanceFacade.broker.CourseBroker;
import data.persistanceFacade.broker.ParentBroker;
import data.persistanceFacade.broker.SemesterBroker;
import data.persistanceFacade.broker.StudentBroker;
import data.persistanceFacade.broker.TeacherBroker;
import data.dataTransferObject.*;

public class PersistenceFacade {

	private StudentBroker sb;
	private TeacherBroker tb;
	private ParentBroker pb;
	private SemesterBroker semb;
	private CourseBroker cb;
	private Object obj;
	
	public PersistenceFacade()
	{
		sb = new StudentBroker();
		tb = new TeacherBroker();
		pb = new ParentBroker();
		semb = new SemesterBroker();
		cb = new CourseBroker();
	}
	
	public Object getStudents()
	{
		try {
			 obj = sb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void addStudent(StudentDTO dto)
	{
		try {
			sb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(StudentDTO dto)
	{
		try {
			sb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(StudentDTO dto)
	{
		try {
			sb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findStudent(StudentDTO dto)
	{
		try {
			obj = sb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object getTeacher()
	{
		try {
			 obj = tb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void addTeacher(TeacherDTO dto)
	{
		try {
			tb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTeacher(TeacherDTO dto)
	{
		try {
			tb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTeacher(TeacherDTO dto)
	{
		try {
			tb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findTeacher(TeacherDTO dto)
	{
		try {
			obj = tb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object getParent()
	{
		try {
			 obj = pb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void addParent(ParentDTO dto)
	{
		try {
			pb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateParent(ParentDTO dto)
	{
		try {
			pb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteParent(ParentDTO dto)
	{
		try {
			pb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findParent(ParentDTO dto)
	{
		try {
			obj = pb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object getSemester()
	{
		try {
			 obj = semb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void addSemester(SemesterDTO dto)
	{
		try {
			semb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSemester(SemesterDTO dto)
	{
		try {
			semb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSemester(SemesterDTO dto)
	{
		try {
			semb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findSemester(SemesterDTO dto)
	{
		try {
			obj = semb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object getCourse()
	{
		try {
			 obj = cb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void addCourse(CourseDTO dto)
	{
		try {
			cb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCourse(CourseDTO dto)
	{
		try {
			cb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCourse(CourseDTO dto)
	{
		try {
			cb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findCourse(CourseDTO dto)
	{
		try {
			obj = cb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
}




























