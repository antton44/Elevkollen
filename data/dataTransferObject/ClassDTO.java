package data.dataTransferObject;

import java.util.UUID;

public class ClassDTO extends DataTransferObject{
	public String name;
	public String classID;

	public ClassDTO(String classID, String name)
	{
		this.name = name;
		this.classID = classID;
	}
	
	public String toString(){
		return this.classID + this.name;
	}
}
