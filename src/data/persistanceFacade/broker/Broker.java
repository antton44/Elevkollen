package data.persistanceFacade.broker;

import java.sql.SQLException;

public abstract class Broker {

	// Cache

	public Object find(Object obj) throws SQLException { // Template Method
        Object obj2 = getFromStorage(obj);

        return obj2;
	}

	//DTO
	
	
	public void insert(Object object)
	{
	}
	
	public void update(Object object)
	{
	}
	
	public void delete(Object object)
	{
	}
	
	
	//DATABAS
	public abstract void insertStorage(Object object) throws SQLException;
	
	public abstract void updateStorage(Object object) throws SQLException;
	
	public abstract void deleteStorage(Object object) throws SQLException;
	
	public abstract Object getFromStorage(Object object) throws SQLException;

	public abstract Object findInStorage(Object object) throws SQLException; 
	
	
}