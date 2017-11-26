package data.dataFacade;

import data.dataTransferObject.DataTransferObject;

public interface IDataState {
	public abstract void insert(DataTransferObject dto);
	public abstract void save(DataTransferObject dto);
	public abstract void reload(DataTransferObject dto);
	public abstract void update(DataTransferObject dto);
	public abstract void delete(DataTransferObject dto);
}
