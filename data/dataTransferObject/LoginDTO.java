package data.dataTransferObject;

public class LoginDTO {
	private String id;

	public LoginDTO(String id)
	{
		this.id = id;
	}
	
	public String toString(){
		return id;
	}
	
	public String getID(){
		return id;
	}
}
