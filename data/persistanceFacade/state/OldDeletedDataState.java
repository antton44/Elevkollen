package data.persistanceFacade.state;

import data.dataFacade.IDataState;
import data.dataTransferObject.DataTransferObject;

public class OldDeletedDataState implements IDataState{

	@Override
	public void insert(DataTransferObject dto) {
	}

	@Override
	public void save(DataTransferObject dto) {
	}

	@Override
	public void reload(DataTransferObject dto) {
		dto.setState(this);
	}

	@Override
	public void update(DataTransferObject dto) {
	}

	@Override
	public void delete(DataTransferObject dto) {
		dto.setState(this);
	}
	public String toString(){
		return "Old Deleted Data State";
	}
}
