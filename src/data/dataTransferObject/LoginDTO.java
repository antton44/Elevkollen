package data.dataTransferObject;

public class LoginDTO {
	private String loginId;

	public LoginDTO(String loginId)
	{
		this.loginId = loginId;
	}
	
	public String toString(){
		return loginId;
	}
}
