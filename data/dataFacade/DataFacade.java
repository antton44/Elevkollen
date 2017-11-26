package data.dataFacade;

import java.sql.SQLException;
import java.util.ArrayList;
import data.persistanceFacade.factory.*;
import data.dataTransferObject.*;
import data.persistanceFacade.broker.*;
import domain.entities.Absence;
import domain.entities.Student;
import domain.entities.Teacher;

public class DataFacade {
	private StudentBroker sb;
	private StudentDTO sDTO;
	private TeacherBroker tb;
	private TeacherDTO tDTO;
	private Object obj;
	private EntityFactory ef;
	
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
	
	public Object getTeacher()
	{
		try {
			 obj = tb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tDTO = new TeacherDTO(obj.toString());
		return tDTO;
	}
	
	public void addTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.toString());
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
	
	public Object findSTeacher(Teacher teacher)
	{
		try {
			obj = tb.findInStorage(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		tDTO = new TeacherDTO(teacher.toString());
		return tDTO;
	}
}
