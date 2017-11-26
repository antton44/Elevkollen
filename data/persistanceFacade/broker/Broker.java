package data.persistanceFacade.broker;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public abstract class Broker {

	private HashMap<UUID, Object> cache = new HashMap<UUID, Object>();

	// Cache

	public Object find(UUID id) throws SQLException { // Template Method
		if (cache.containsKey(id))
			return cache.get(id);

		Object obj = this.findInStorage(id);
		cache.put(id, obj);
		return obj;
	}

	//DTO
	
	
	public void insert(Object object)
	{
		cache.put(UUID.fromString(object.toString()), object);
	}
	
	public void update(Object object)
	{
		cache.put(UUID.fromString(object.toString()), object);
	}
	
	public void delete(Object object)
	{
		cache.remove(UUID.fromString(object.toString()));
	}
	
	
	//DATABAS
	public abstract void insertStorage(Object object) throws SQLException;
	
	public abstract void updateStorage(Object object) throws SQLException;
	
	public abstract void deleteStorage(Object object) throws SQLException;
	
	public abstract Object getFromStorage(Object object) throws SQLException;

	public abstract Object findInStorage(Object object) throws SQLException; 
	
	
}