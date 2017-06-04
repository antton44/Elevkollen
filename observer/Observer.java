package observer;

import dto.DataTransferObject;

public abstract class Observer {
	protected DataTransferObject dto;
	public abstract void update();
}
