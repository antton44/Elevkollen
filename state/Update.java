package state;

import dto.DataTransferObject;

public class Update  implements State{

	@Override
	public void doAction(DataTransferObject dto) {
		dto.setState(this);
	}

}
