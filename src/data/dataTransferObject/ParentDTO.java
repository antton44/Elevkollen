package data.dataTransferObject;

@SuppressWarnings("serial")
public class ParentDTO extends DataTransferObject{
	public String name;
	public String personnummer;
	public String email;

	
	public ParentDTO(String personummer, String name, String email)
	{
		this.name = name;
		this.personnummer = personummer;
		this.email = email;
	}
	
	public String toString(){
		return this.personnummer + this.name + this.email;
	}
}
