package data.dataFacade;

import java.sql.SQLException;
import java.util.ArrayList;

import data.persistanceFacade.factory.*;
import data.persistanceFacade.state.*;
import data.dataTransferObject.*;
import data.persistanceFacade.broker.*;
import domain.entities.Absence;
import domain.entities.Course;
import domain.entities.Parent;
import domain.entities.Semester;
import domain.entities.Student;
import domain.entities.Teacher;

public class DataFacade implements Entities{
	private StudentBroker sb;
	private StudentDTO sDTO;
	private TeacherBroker tb;
	private TeacherDTO tDTO;
	private ParentBroker pb;
	private ParentDTO pDTO;
	private SemesterBroker semb;
	private SemesterDTO semDTO;
	private CourseBroker cb;
	private CourseDTO cDTO;
	private Object obj;
	private EntityFactory ef = new EntityFactory();
	private NewDataState nds = new NewDataState();
	
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
		Student newStudent = (Student) ef.getEntity(STUDENT, sDTO.name, sDTO.personnummer, sDTO.email);
		return newStudent;
	}
	
	public void addStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		nds.insert(dto);
		dto.setState(nds);
		System.out.println(dto.getState());
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
		Student newStudent = (Student) ef.getEntity(STUDENT, sDTO.name, sDTO.personnummer, sDTO.email);
		return newStudent;
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
		Teacher newTeacher = (Teacher) ef.getEntity(TEACHER, tDTO.name, tDTO.personnummer, tDTO.email);
		return newTeacher;
	}
	
	public void addTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		nds.insert(dto);
		dto.setState(nds);
		System.out.println(dto.getState());
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
		Teacher newTeacher = (Teacher) ef.getEntity(TEACHER, tDTO.name, tDTO.personnummer, tDTO.email);
		return newTeacher;
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
		Parent newParent = (Parent) ef.getEntity(PARENT, tDTO.name, tDTO.personnummer, tDTO.email);
		return newParent;
	}
	
	public void addParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		nds.insert(dto);
		dto.setState(nds);
		System.out.println(dto.getState());
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
	
	public void deleteParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		try {
			pb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		try {
			obj = pb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		Parent newParent = (Parent) ef.getEntity(PARENT, tDTO.name, tDTO.personnummer, tDTO.email);
		return newParent;
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
		Semester sem = new Semester(semDTO.toString());
		return sem;
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
		Semester sem = new Semester(semDTO.toString());
		return sem;
	}
	
	//Course
	public Object getCourse()
	{
		try {
			 obj = cb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		cDTO = new CourseDTO(splitter1[0], splitter1[1]);
		Course newCourse = new Course(cDTO.classID, cDTO.name);
		return newCourse;
	}
	
	public void addCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		try {
			cb.insertStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		try {
			cb.updateStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		try {
			cb.deleteStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object findCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		try {
			obj = cb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		cDTO = new CourseDTO(splitter1[0], splitter1[1]);
		Course newCourse = new Course(cDTO.classID, cDTO.name);
		return newCourse;
	}
}

