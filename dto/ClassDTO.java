package dto;

public class ClassDTO extends DataTransferObject{
	//private String classID;
	private String name;

	public ClassDTO(String name)
	{
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
