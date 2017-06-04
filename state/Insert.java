package state;

import dto.DataTransferObject;

public class Insert implements State{

	@Override
	public void doAction(DataTransferObject dto) {
		dto.setState(this);
	}
	
}
