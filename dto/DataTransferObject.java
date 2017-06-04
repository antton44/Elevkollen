package dto;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;
import state.State;
import broker.Broker;

public abstract class DataTransferObject {
	private State state;
	private List<Observer> observers = new ArrayList<Observer>();
	protected Broker broker;
	
	public void setState(State state)
	{
		this.state = state;
		System.out.println("state changed to " + state.toString());
		notifyAllObservers();
	}
	
	public State getState()
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
	
	public Broker getBroker()
	{
		return broker;
	}
	
	public String toString(){
		return "smo";
				}
}
