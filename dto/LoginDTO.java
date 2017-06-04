package dto;

public class LoginDTO {
	private String name;

	public LoginDTO(String name)
	{
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
