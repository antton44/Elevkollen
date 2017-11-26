package data.dataFacade;

import java.sql.SQLException;
import java.util.ArrayList;

import data.persistanceFacade.factory.*;
import data.dataTransferObject.*;
import data.persistanceFacade.broker.*;
import domain.entities.Absence;
import domain.entities.Parent;
import domain.entities.Semester;
import domain.entities.Student;
import domain.entities.Teacher;

public class DataFacade {
	private StudentBroker sb;
	private StudentDTO sDTO;
	private TeacherBroker tb;
	private TeacherDTO tDTO;
	private ParentBroker pb;
	private ParentDTO pDTO;
	private SemesterBroker semb;
	private SemesterDTO semDTO;
	private Object obj;
	private EntityFactory ef;
	
	//Student
	public Object getStudent()
	{
		try {
			 obj = sb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		sDTO = new StudentDTO(splitter1[0], splitter1[1],splitter1[2]);
		
		return sDTO;
	}
	
	public void addStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		try {
			sb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		try {
			sb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		try {
			sb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		try {
			obj = sb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		sDTO = new StudentDTO(splitter1[0], splitter1[1],splitter1[2]);
		return sDTO;
	}
	
	
	//Teacher
	public Object getTeacher()
	{
		try {
			 obj = tb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		tDTO = new TeacherDTO(splitter1[0], splitter1[1],splitter1[2]);
		return tDTO;
	}
	
	public void addTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		try {
			tb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTeacher(Teacher teacher)
	{
		try {
			tb.updateStorage(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTeacher(Teacher teacher)
	{
		try {
			tb.deleteStorage(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findTeacher(Teacher teacher)
	{
		try {
			obj = tb.findInStorage(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		tDTO = new TeacherDTO(splitter1[0], splitter1[1],splitter1[2]);
		return tDTO;
	}
	
	
	//Parent
	public Object getParent()
	{
		try {
			 obj = pb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		pDTO = new ParentDTO(splitter1[0], splitter1[1],splitter1[2]);
		
		return pDTO;
	}
	
	public void addParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		try {
			pb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		try {
			pb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		try {
			pb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findStudent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		try {
			obj = pb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		pDTO = new ParentDTO(splitter1[0], splitter1[1],splitter1[2]);
		return pDTO;
	}
	
	//Semester
	public Object getSemester()
	{
		try {
			 obj = semb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		semDTO = new SemesterDTO(obj.toString());
		return semDTO;
	}
	
	public void addSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		try {
			semb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		try {
			semb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		try {
			semb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		try {
			obj = semb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		semDTO = new SemesterDTO(obj.toString());
		return semDTO;
	}
	
	//
}

