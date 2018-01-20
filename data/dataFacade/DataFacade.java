package data.dataFacade;

import java.util.ArrayList;

import data.persistanceFacade.factory.*;
import data.persistanceFacade.state.*;
import data.dataTransferObject.*;
import domain.entities.Course;
import domain.entities.Parent;
import domain.entities.Semester;
import domain.entities.Student;
import domain.entities.Teacher;

public class DataFacade implements Entities{
	private StudentDTO sDTO;
	private TeacherDTO tDTO;
	private ParentDTO pDTO;
	private SemesterDTO semDTO;
	private CourseDTO cDTO;
	private Object obj;
	private EntityFactory ef;
	private NewDataState nds;
	private PersistenceFacade pFacade;
	
	public DataFacade()
	{
		ef = new EntityFactory();
		nds = new NewDataState();
		pFacade = new PersistenceFacade();
	}
	
	//Student
	public ArrayList<Student> getStudents()
	{
		obj = pFacade.getStudents();
		ArrayList<Student> students = new ArrayList<Student>();
		String s1 = obj.toString();
		String[] test = s1.split("\\n");
		int length = test.length;
		int rounds = length / 3;
		
		for (int i = 0; i < rounds; i++) {
			int r = 0;
			int t = 1;
			int y = 2;
			for (int k = 0; k < length; k++) {
				String[] splitter1 = s1.split("---|\\n");
				sDTO = new StudentDTO(splitter1[r], splitter1[t],splitter1[y]);
				students.add((Student) ef.getEntity(STUDENT, sDTO.name, sDTO.personnummer, sDTO.email));
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
		return students;
	}
	
	public void addStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		nds.insert(dto);
		dto.setState(nds);
		System.out.println(dto.getState());
		pFacade.addStudent(dto);
	}
	
	public void updateStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		pFacade.updateStudent(dto);
	}
	
	public void deleteStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		pFacade.deleteStudent(dto);
	}
	
	public Object findStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		obj = pFacade.findStudent(dto);
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		sDTO = new StudentDTO(splitter1[0], splitter1[1],splitter1[2]);
		Student newStudent = (Student) ef.getEntity(STUDENT, sDTO.name, sDTO.personnummer, sDTO.email);
		return newStudent;
	}
	
	
	//Teacher
	public ArrayList<Teacher> getTeacher()
	{
		obj = pFacade.getTeacher();
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		String s1 = obj.toString();
		String[] test = s1.split("\\n");
		int length = test.length;
		int rounds = length / 3;
		
		for (int i = 0; i < rounds; i++) {
			int r = 0;
			int t = 1;
			int y = 2;
			for (int k = 0; k < length; k++) {
				String[] splitter1 = s1.split("---|\\n");
				tDTO = new TeacherDTO(splitter1[r], splitter1[t],splitter1[y]);
				teachers.add((Teacher) ef.getEntity(TEACHER, tDTO.name, tDTO.personnummer, tDTO.email));
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
		return teachers;
	}
	
	public void addTeacher(Teacher teacher)
	{
		System.out.println("se");
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		nds.insert(dto);
		dto.setState(nds);
		System.out.println(dto.getState());
		pFacade.addTeacher(dto);
	}
	
	public void updateTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		pFacade.updateTeacher(dto);
	}
	
	public void deleteTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		pFacade.deleteTeacher(dto);
	}
	
	public Object findTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		obj = pFacade.findTeacher(dto);
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		tDTO = new TeacherDTO(splitter1[0], splitter1[1],splitter1[2]);
		Teacher newTeacher = (Teacher) ef.getEntity(TEACHER, tDTO.name, tDTO.personnummer, tDTO.email);
		return newTeacher;
	}
	
	
	//Parent
	public ArrayList<Parent> getParent()
	{
			obj = pFacade.getParent();
			ArrayList<Parent> parents = new ArrayList<Parent>();
			String s1 = obj.toString();
			String[] test = s1.split("\\n");
			int length = test.length;
			int rounds = length / 3;
			
			for (int i = 0; i < rounds; i++) {
				int r = 0;
				int t = 1;
				int y = 2;
				for (int k = 0; k < length; k++) {
					String[] splitter1 = s1.split("---|\\n");
					pDTO = new ParentDTO(splitter1[r], splitter1[t],splitter1[y]);
					parents.add((Parent) ef.getEntity(PARENT, pDTO.name, pDTO.personnummer, pDTO.email));
					r = r + 3;
					t = t + 3;
					y = y + 3;
				}
			}
			return parents;
	}
	
	public void addParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		nds.insert(dto);
		dto.setState(nds);
		System.out.println(dto.getState());
		pFacade.addParent(dto);
	}
	
	public void updateParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		pFacade.updateParent(dto);
	}
	
	public void deleteParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		pFacade.deleteParent(dto);
	}
	
	public Object findParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		obj = pFacade.findParent(dto);
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		pDTO = new ParentDTO(splitter1[0], splitter1[1],splitter1[2]);
		Parent newParent = (Parent) ef.getEntity(PARENT, pDTO.name, pDTO.personnummer, pDTO.email);
		return newParent;
	}
	
	//Semester
	public ArrayList<Semester> getSemester()
	{
		obj = pFacade.getSemester();
		ArrayList<Semester> semesters = new ArrayList<Semester>();
		String s1 = obj.toString();
		String[] test = s1.split("\\n");
		int length = test.length;
		int rounds = length / 3;
		
		for (int i = 0; i < rounds; i++) {
			int r = 0;
			int t = 1;
			int y = 2;
			for (int k = 0; k < length; k++) {
				String[] splitter1 = s1.split("---|\\n");
				tDTO = new TeacherDTO(splitter1[r], splitter1[t],splitter1[y]);
				semesters.add(new Semester(semDTO.toString()));
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
		return semesters;
	}
	
	public void addSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		pFacade.addSemester(dto);
	}
	
	public void updateSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		pFacade.updateSemester(dto);
	}
	
	public void deleteSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		pFacade.deleteSemester(dto);
	}
	
	public Object findSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		pFacade.findSemester(dto);
		semDTO = new SemesterDTO(obj.toString());
		Semester sem = new Semester(semDTO.toString());
		return sem;
	}
	
	//Course
	public ArrayList<Course> getCourse()
	{
		obj = pFacade.getCourse();
		ArrayList<Course> courses = new ArrayList<Course>();
		String s1 = obj.toString();
		String[] test = s1.split("\\n");
		int length = test.length;
		int rounds = length / 3;
		
		for (int i = 0; i < rounds; i++) {
			int r = 0;
			int t = 1;
			for (int k = 0; k < length; k++) {
				String[] splitter1 = s1.split("---|\\n");
				cDTO = new CourseDTO(splitter1[r], splitter1[t]);
				courses.add(new Course(cDTO.classID, cDTO.name));
				r = r + 2;
				t = t + 2;
			}
		}
		return courses;
	}
	
	public void addCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		pFacade.addCourse(dto);
	}
	
	public void updateCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		pFacade.updateCourse(dto);
	}
	
	public void deleteCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		pFacade.deleteCourse(dto);
	}
	
	public Object findCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		obj = pFacade.findCourse(dto);
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		cDTO = new CourseDTO(splitter1[0], splitter1[1]);
		Course newCourse = new Course(cDTO.classID, cDTO.name);
		return newCourse;
	}
	
	public Object FindLogin(String login)
	{
		LoginDTO dto = new LoginDTO(login);
		obj = pFacade.findLogin(dto);
		return obj;
	}
}

