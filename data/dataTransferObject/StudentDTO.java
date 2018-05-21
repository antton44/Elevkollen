package data.dataTransferObject;

@SuppressWarnings("serial")
public class StudentDTO extends DataTransferObject{
	public String name;
	public String personnummer;
	public String email;
	public String id;

	public StudentDTO(String personummer, String name, String email)
	{
		this.name = name;
		this.personnummer = personummer;
		this.email = email;
	}
	
	public StudentDTO(String personummer, String name, String email, String id)
	{
		this.name = name;
		this.personnummer = personummer;
		this.email = email;
		this.id = id;
	}
	
	public String toString(){
		return this.personnummer + this.name + this.email + this.id;
	}
}
