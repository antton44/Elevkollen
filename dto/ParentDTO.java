package dto;

public class ParentDTO extends DataTransferObject{
	private String name;

	public ParentDTO(String name)
	{
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
