package domain.domainFacade;

import java.util.ArrayList;
import java.util.UUID;

import data.dataTransferObject.CourseDTO;
import data.dataTransferObject.ParentDTO;
import data.dataTransferObject.SemesterDTO;
import data.dataTransferObject.StudentDTO;
import data.dataTransferObject.TeacherDTO;
import data.dataFacade.DataFacade;
import domain.entities.Course;
import domain.entities.Login;
import domain.entities.Parent;
import domain.entities.Semester;
import domain.entities.Student;
import domain.entities.Teacher;

public class DomainFacade {
	private DataFacade df;
	
	public DomainFacade()
	{
		df = new DataFacade();
	}
	
	//Student
	public void add(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		dto.id = UUID.randomUUID().toString();
		df.addStudent(dto);
	}
	
	public ArrayList<Student> getStudents()
	{
		ArrayList<Student> sList = new ArrayList<>();
		ArrayList<StudentDTO> sDtoList = df.getStudents();
		for(int i = 0; i < sDtoList.size(); i++)
		{
			sList.add(new Student(sDtoList.get(i).name, sDtoList.get(i).personnummer, sDtoList.get(i).email));
		}
		return sList;
	}
	
	public void updateStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		df.updateStudent(dto);
	}
	
	public void deleteStudent(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		df.deleteStudent(dto);
	}
	
	public Student find(Student student)
	{
		StudentDTO dto = new StudentDTO(student.getPersonnummer(), student.getName(), student.getEmail());
		dto = df.find(dto);
		Student newStudent = new Student(dto.name, dto.personnummer, dto.email);
		return newStudent;
	}
	
	//Teacher
	public void add(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		df.addTeacher(dto);
	}
	
	public ArrayList<Teacher> getTeachers()
	{
		ArrayList<Teacher> tList = new ArrayList<>();
		ArrayList<TeacherDTO> tDtoList = df.getTeachers();
		for(int i = 0; i < tDtoList.size(); i++)
		{
			tList.add(new Teacher(tDtoList.get(i).name, tDtoList.get(i).personnummer, tDtoList.get(i).email));
		}
		return tList;
	}
	
	public void updateTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		df.updateTeacher(dto);
	}
	
	public void deleteTeacher(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		df.deleteTeacher(dto);
	}
	
	public Teacher find(Teacher teacher)
	{
		TeacherDTO dto = new TeacherDTO(teacher.getPersonnummer(), teacher.getName(), teacher.getEmail());
		dto = df.find(dto);
		Teacher newTeacher = new Teacher(dto.name, dto.personnummer, dto.email);
		return newTeacher;
	}
	
	//Parent
	public void add(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		df.addParent(dto);
	}
	
	public ArrayList<Parent> getParents()
	{
		ArrayList<Parent> pList = new ArrayList<>();
		ArrayList<ParentDTO> pDtoList = df.getParents();
		for(int i = 0; i < pDtoList.size(); i++)
		{
			pList.add(new Parent(pDtoList.get(i).name, pDtoList.get(i).personnummer, pDtoList.get(i).email));
		}
		return pList;
	}
	
	public void updateParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		df.updateParent(dto);
	}
	
	public void deleteParent(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		df.deleteParent(dto);
	}
	
	public Parent find(Parent parent)
	{
		ParentDTO dto = new ParentDTO(parent.getPersonnummer(), parent.getName(), parent.getEmail());
		dto = df.find(dto);
		Parent newParent = new Parent(dto.name, dto.personnummer, dto.email);
		return newParent;
	}
	
	//Semester
	public void add(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.toString());
		df.addSemester(dto);
	}
	
	public ArrayList<Semester> getSemester()
	{
		ArrayList<Semester> sList = new ArrayList<>();
		ArrayList<SemesterDTO> sDtoList = df.getSemester();
		for(int i = 0; i < sDtoList.size(); i++)
		{
			sList.add(new Semester());
		}
		return sList;
	}
	
	public void updateSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		df.updateSemester(dto);
	}
	
	public void deleteSemester(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		df.deleteSemester(dto);
	}
	
	public Semester find(Semester semester)
	{
		SemesterDTO dto = new SemesterDTO(semester.getSemesterID());
		dto = df.find(dto);
		Semester newSemester = new Semester(dto.name);
		return newSemester;
	}
	
	//Course
	public void add(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		df.addCourse(dto);
	}
	
	public ArrayList<Course> getCourse()
	{
		ArrayList<Course> cList = new ArrayList<>();
		ArrayList<CourseDTO> cDtoList = df.getCourse();
		for(int i = 0; i < cDtoList.size(); i++)
		{
			cList.add(new Course(cDtoList.get(i).classID, cDtoList.get(i).name));
		}
		return cList;
	}
	
	public void updateCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		df.updateCourse(dto);
	}
	
	public void deleteCourse(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		df.deleteCourse(dto);
	}
	
	public Course find(Course course)
	{
		CourseDTO dto = new CourseDTO(course.getCourseID(), course.getCourseName());
		dto = df.find(dto);
		Course newCourse = new Course(dto.classID, dto.name);
		return newCourse;
	}
	
	//Login
	public Login findLogin(String loginString)
	{
		Login login = new Login(df.FindLogin(loginString).toString());
		return login;
	}
	
}
