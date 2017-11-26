package data.dataTransferObject;

public class TeacherDTO extends DataTransferObject{
	public String name;
	public String personnummer;
	public String email;

	
	public TeacherDTO(String personummer, String name, String email)
	{
		this.name = name;
		this.personnummer = personummer;
		this.email = email;
	}
	
	public String toString(){
		return this.personnummer + this.name + this.email;
	}
}
