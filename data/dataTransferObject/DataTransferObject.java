package data.dataTransferObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import data.dataFacade.IDataState;
import observer.Observer;

public abstract class DataTransferObject{
	public IDataState state;
	private List<Observer> observers = new ArrayList<Observer>();
	protected UUID uuid;
	
	public DataTransferObject(){
		uuid = UUID.randomUUID();
	}
	
	public void setState(IDataState state)
	{
		this.state = state;
		//System.out.println("state changed to " + state.toString());
		notifyAllObservers();
	}
	
	public IDataState getState()
	{
		return state;
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
	
	public UUID getUUID(){
		return uuid;
	}
	
	public String toString(){
		return "smo";
				}
}
