package data.dataTransferObject;

@SuppressWarnings("serial")
public class SemesterDTO extends DataTransferObject{
	public String name;

	public SemesterDTO(String name)
	{
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
