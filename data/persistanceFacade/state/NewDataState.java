package data.persistanceFacade.state;

import data.dataFacade.*;
import data.dataTransferObject.DataTransferObject;

public class NewDataState implements IDataState{

	@Override
	public void insert(DataTransferObject dto) {
		dto.state = this;
	}

	@Override
	public void save(DataTransferObject dto) {}

	@Override
	public void reload(DataTransferObject dto) {}

	@Override
	public void update(DataTransferObject dto) {}

	@Override
	public void delete(DataTransferObject dto) {}
	public String toString(){
		return "New Data State";
	}
}
