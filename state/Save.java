package state;

import dto.DataTransferObject;

public class Save  implements State{

	@Override
	public void doAction(DataTransferObject dto) {
		dto.setState(this);
	}
	
}
