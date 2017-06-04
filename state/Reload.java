package state;

import dto.DataTransferObject;

public class Reload  implements State{

	@Override
	public void doAction(DataTransferObject dto) {
		dto.setState(this);
	}

}
