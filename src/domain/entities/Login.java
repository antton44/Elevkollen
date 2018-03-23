package domain.entities;

public class Login {
	private String loginId;
	
	public Login()
	{
		setLoginId("");
	}
	
	public Login(String loginId)
	{
		this.setLoginId(loginId);
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
