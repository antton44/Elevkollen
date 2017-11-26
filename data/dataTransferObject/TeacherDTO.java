package data.dataTransferObject;

public class TeacherDTO extends DataTransferObject{
	private String name;

	public TeacherDTO(String name)
	{
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
