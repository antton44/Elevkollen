package entites;

public abstract class Entity {
	private String name;
	private int personnummer;
	private String email;
	
	public Entity()
	{
		name = "";
		personnummer = -1;
		email = "";
	}
	
	public Entity(String name, int personnummer, String email)
	{
		this.name = name;
		this.personnummer = personnummer;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(int personnummer) {
		this.personnummer = personnummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
