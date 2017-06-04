package observer;

import dto.DataTransferObject;

public class StudentObserver extends Observer{

	public StudentObserver(DataTransferObject dto)
	{
		this.dto = dto;
		this.dto.attach(this);
	}
	
	@Override
	public void update() {
		dto.getBroker().update(dto);
	}
	
}
