package data.persistanceFacade.state;

import data.dataFacade.*;
import data.dataTransferObject.DataTransferObject;

public class NewDataState implements IDataState{

	@Override
	public void insert(DataTransferObject dto) {
	}

	@Override
	public void save(DataTransferObject dto) {}

	@Override
	public void reload(DataTransferObject dto) {}

	@Override
	public void update(DataTransferObject dto) {}

	@Override
	public void delete(DataTransferObject dto) {
		dto.setState(this);
	}
	public String toString(){
		return "Deleted Data State";
	}
}
