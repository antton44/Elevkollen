package dto;

public class StudentDTO extends DataTransferObject{
	public String name;
	public String personnummer;
	public String email;

	
	public StudentDTO(String personummer, String name, String email)
	{
		this.name = name;
		this.personnummer = personummer;
		this.email = email;
	}
	
	public String toString(){
		return this.personnummer + this.name + this.email;
	}
}
