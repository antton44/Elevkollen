package data.dataTransferObject;

import java.util.UUID;

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
