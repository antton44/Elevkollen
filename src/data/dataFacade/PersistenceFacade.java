package data.dataFacade;

import java.sql.SQLException;
import java.util.ArrayList;

import data.dataTransferObject.CourseDTO;
import data.dataTransferObject.LoginDTO;
import data.dataTransferObject.ParentDTO;
import data.dataTransferObject.SemesterDTO;
import data.dataTransferObject.StudentDTO;
import data.dataTransferObject.TeacherDTO;
import data.persistanceFacade.broker.CourseBroker;
import data.persistanceFacade.broker.LoginBroker;
import data.persistanceFacade.broker.ParentBroker;
import data.persistanceFacade.broker.SemesterBroker;
import data.persistanceFacade.broker.StudentBroker;
import data.persistanceFacade.broker.TeacherBroker;

public class PersistenceFacade {

	private StudentBroker sb;
	private TeacherBroker tb;
	private ParentBroker pb;
	private SemesterBroker semb;
	private CourseBroker cb;
	private LoginBroker lb;
	private Object obj;
	private CourseDTO cDTO;
	private TeacherDTO tDTO;
	private StudentDTO sDTO;
	private ParentDTO pDTO;
	private LoginDTO lDTO;
	private SemesterDTO semDTO;
	
	public PersistenceFacade()
	{
		sb = new StudentBroker();
		tb = new TeacherBroker();
		pb = new ParentBroker();
		semb = new SemesterBroker();
		cb = new CourseBroker();
		lb = new LoginBroker();
	}
	
	//
	public ArrayList<StudentDTO> getStudents()
	{
		try {
			 obj = sb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<StudentDTO> students = new ArrayList<>();
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
				students.add(new StudentDTO(sDTO.name, sDTO.personnummer, sDTO.email));
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
		return students;
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
	
	public StudentDTO findStudent(StudentDTO dto)
	{
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
	
	public ArrayList<TeacherDTO> getTeacher()
	{
		try {
			 obj = tb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TeacherDTO> teachers = new ArrayList<>();
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
				teachers.add(new TeacherDTO(tDTO.name, tDTO.personnummer, tDTO.email));
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
		return teachers;
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
	
	public TeacherDTO findTeacher(TeacherDTO dto)
	{
		try {
			obj = tb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		tDTO = new TeacherDTO(splitter1[0], splitter1[1],splitter1[2]);
		return tDTO;
	}
	
	public ArrayList<ParentDTO> getParent()
	{
		try {
			 obj = pb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<ParentDTO> parents = new ArrayList<>();
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
				parents.add(new ParentDTO(pDTO.name, pDTO.personnummer, pDTO.email));
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
		return parents;
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
	
	public ParentDTO findParent(ParentDTO dto)
	{
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
	
	public CourseDTO findCourse(CourseDTO dto)
	{
		try{
			obj = pb.findInStorage(dto);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter = s1.split("---|\\n");
		cDTO = new CourseDTO(splitter[0], splitter[1]);
		return cDTO;
	}
	
	public ArrayList<SemesterDTO> getSemester()
	{
		try {
			 obj = semb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<SemesterDTO> semesters = new ArrayList<>();
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
				semesters.add(new SemesterDTO(semDTO.toString()));
				r = r + 3;
				t = t + 3;
				y = y + 3;
			}
		}
		return semesters;
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
	
	public SemesterDTO findSemester(SemesterDTO dto)
	{
		try {
			obj = semb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		String s1 = obj.toString();
		semDTO = new SemesterDTO(s1);
		return semDTO;
	}
	
	public ArrayList<CourseDTO> getCourse()
	{
		try {
			 obj = cb.getFromStorage(new Object());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<CourseDTO> courses = new ArrayList<CourseDTO>();
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
				courses.add(new CourseDTO(cDTO.classID, cDTO.name));
				r = r + 2;
				t = t + 2;
			}
		}
		return courses;
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
	
	public CourseDTO find(CourseDTO dto)
	{
		try {
			obj = cb.findInStorage(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String s1 = obj.toString();
		String[] splitter1 = s1.split("---|\\n");
		cDTO = new CourseDTO(splitter1[0], splitter1[1]);
		return cDTO;
	}
	
	public LoginDTO find(LoginDTO dto)
	{
		lDTO = null;
		String s1 = "";
		try {
			obj = lb.findInStorage(dto);
			s1 = obj.toString();
			lDTO = new LoginDTO(s1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return lDTO;
	}
}




























