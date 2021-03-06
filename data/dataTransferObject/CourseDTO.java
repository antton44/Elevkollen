package data.dataTransferObject;

import java.util.UUID;

public class CourseDTO extends DataTransferObject{
	public String name;
	public String classID;

	public CourseDTO(String classID, String name)
	{
		this.name = name;
		this.classID = classID;
	}
	
	public String toString(){
		return this.classID + this.name;
	}
}
