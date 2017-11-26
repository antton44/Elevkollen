package observer;

import data.dataTransferObject.DataTransferObject;

public class LoginObserver extends Observer{

	public LoginObserver(DataTransferObject dto){
		this.dto = dto;
		this.dto.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println("kommer hit");
	}

}
