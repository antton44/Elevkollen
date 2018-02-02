package domain.entities;

import data.persistanceFacade.factory.Entities;

public abstract class Entity implements Entities{
	private String name;
	private String personnummer;
	private String email;
	
	public Entity()
	{
		name = "";
		personnummer = "";
		email = "";
	}
	
	public Entity(String name, String personnummer, String email)
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

	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
