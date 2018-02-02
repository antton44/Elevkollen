package observer;

import data.dataTransferObject.DataTransferObject;

public abstract class Observer {
	protected DataTransferObject dto;
	public abstract void update();
}
