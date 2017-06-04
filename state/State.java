package state;

import dto.DataTransferObject;

public interface State {
	public void doAction(DataTransferObject dto);
}
