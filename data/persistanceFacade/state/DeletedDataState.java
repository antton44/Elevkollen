package data.persistanceFacade.state;

import data.dataFacade.IDataState;
import data.dataTransferObject.DataTransferObject;

public class DeletedDataState implements IDataState{
	//#USELESS
	@Override
	public void insert(DataTransferObject dto) {
	}

	@Override
	public void save(DataTransferObject dto) {
	}

	@Override
	public void reload(DataTransferObject dto) {
	}

	@Override
	public void update(DataTransferObject dto) {
	}

	@Override
	public void delete(DataTransferObject dto) {
	}
}
