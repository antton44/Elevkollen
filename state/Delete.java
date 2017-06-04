package state;

import dto.DataTransferObject;

public class Delete  implements State{

	@Override
	public void doAction(DataTransferObject dto) {
		dto.setState(this);
	}

}
