package data.dataTransferObject;

import java.util.ArrayList;
import java.util.List;

import data.dataFacade.IDataState;
import observer.Observer;

public abstract class DataTransferObject{
	public IDataState state;
	private List<Observer> observers = new ArrayList<Observer>();
	
	public DataTransferObject(){
		state = null;
	}
	
	public void setState(IDataState state)
	{
		this.state = state;
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
}
