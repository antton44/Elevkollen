package data.dataTransferObject;

import java.io.Serializable;

public abstract class DataTransferObject implements Serializable{
	private static final long serialVersionUID = 1L;
	public String id;
	public abstract String toString();
}
