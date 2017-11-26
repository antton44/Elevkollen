package data.persistanceFacade.state;

import data.dataFacade.*;
import data.dataTransferObject.DataTransferObject;

public class NewDataState implements IDataState{

	@Override
	public void insert(DataTransferObject dto) {
		dto.state = this;
	}

	@Override
	public void save(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reload(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}
}
