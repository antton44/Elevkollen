package data.dataTransferObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import data.dataFacade.IDataState;
import observer.Observer;

public abstract class DataTransferObject implements Serializable{
	public IDataState state;
	private List<Observer> observers = new ArrayList<Observer>();

	private int id;
	public int getId()
	{
		return id;
	}
    public void setId(int id)
    {
    	this.id = id;
    }
	
	public void setState()
	{
		notifyAllObservers();
	}
	
	public void attach(Observer observer)
	{
		observers.add(observer);
	}
	
	public void notifyAllObservers(){
      	 for (Observer observer : observers) {
         	observer.update();
      	 }
	}
}
