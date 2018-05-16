package data.dataFacade;

import java.util.ArrayList;

import data.dataTransferObject.*;

public class DataFacade{
	private StudentDTO sDTO;
	private TeacherDTO tDTO;
	private ParentDTO pDTO;
	private SemesterDTO semDTO;
	private CourseDTO cDTO;
	private DataTransferObject obj;
	private PersistenceFacade pFacade;
	
	public DataFacade()
	{
		pFacade = new PersistenceFacade();
	}
	
	//Student
	public ArrayList<StudentDTO> getStudents()
	{
		ArrayList<StudentDTO> sDtoList = new ArrayList<>();
		sDtoList = pFacade.getStudents();
		System.out.println("data: " + sDtoList.size());
		return sDtoList;
	}
	
	public void addStudent(StudentDTO dto)
	{
		pFacade.addStudent(dto);
	}
	
	public void updateStudent(StudentDTO dto)
	{
		pFacade.updateStudent(dto);
	}
	
	public void deleteStudent(StudentDTO dto)
	{
		pFacade.deleteStudent(dto);
	}
	
	public StudentDTO find(StudentDTO dto)
	{
		return pFacade.findStudent(dto);
	}
	
	
	//Teacher
	public ArrayList<TeacherDTO> getTeachers()
	{
		ArrayList<TeacherDTO> tDtoList = new ArrayList<>();
		tDtoList = pFacade.getTeacher();
		return tDtoList;
	}
	
	public void addTeacher(TeacherDTO dto)
	{
		pFacade.addTeacher(dto);
	}
	
	public void updateTeacher(TeacherDTO dto)
	{
		pFacade.updateTeacher(dto);
	}
	
	public void deleteTeacher(TeacherDTO dto)
	{
		pFacade.deleteTeacher(dto);
	}
	
	public TeacherDTO find(TeacherDTO dto)
	{
		return pFacade.findTeacher(dto);
	}
	
	//Parent
	public ArrayList<ParentDTO> getParents()
	{
		ArrayList<ParentDTO> pDtoList = new ArrayList<>();
		pDtoList = pFacade.getParent();
		return pDtoList;
	}
	
	public void addParent(ParentDTO dto)
	{
		pFacade.addParent(dto);
	}
	
	public void updateParent(ParentDTO dto)
	{
		pFacade.updateParent(dto);
	}
	
	public void deleteParent(ParentDTO dto)
	{
		pFacade.deleteParent(dto);
	}
	
	public ParentDTO find(ParentDTO dto)
	{
		return pFacade.findParent(dto);
	}
	
	//Semester
	public ArrayList<SemesterDTO> getSemester()
	{
		ArrayList<SemesterDTO> semDtoList = new ArrayList<>();
		semDtoList = pFacade.getSemester();
		return semDtoList;
	}
	
	public void addSemester(SemesterDTO dto)
	{
		pFacade.addSemester(dto);
	}
	
	public void updateSemester(SemesterDTO dto)
	{
		pFacade.updateSemester(dto);
	}
	
	public void deleteSemester(SemesterDTO dto)
	{
		pFacade.deleteSemester(dto);
	}
	
	public SemesterDTO find(SemesterDTO dto)
	{
		return pFacade.findSemester(dto);
	}
	
	//Course
	public ArrayList<CourseDTO> getCourse()
	{
		ArrayList<CourseDTO> cDtoList = new ArrayList<>();
		cDtoList = pFacade.getCourse();
		return cDtoList;
	}
	
	public void addCourse(CourseDTO dto)
	{
		pFacade.addCourse(dto);
	}
	
	public void updateCourse(CourseDTO dto)
	{
		pFacade.updateCourse(dto);
	}
	
	public void deleteCourse(CourseDTO dto)
	{
		pFacade.deleteCourse(dto);
	}
	
	public CourseDTO find(CourseDTO dto)
	{
		return pFacade.findCourse(dto);
	}
	
	public LoginDTO FindLogin(String login)
	{
		LoginDTO dto = new LoginDTO(login);
		dto = pFacade.find(dto);
		return dto;
	}
}

