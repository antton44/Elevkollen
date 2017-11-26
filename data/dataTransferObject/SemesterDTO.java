package data.dataTransferObject;

public class SemesterDTO extends DataTransferObject{
	private String name;

	public SemesterDTO(String name)
	{
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
