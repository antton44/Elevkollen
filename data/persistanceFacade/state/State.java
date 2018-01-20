package data.persistanceFacade.state;

import java.awt.event.ActionEvent;

import gui.minterface.Login;
import data.dataFacade.DataFacade;

public class State {
	protected DataFacade dFacade;
	protected Object obj;
	public void build(Login ls)
	{}
	public void Handle(Login ls, ActionEvent e)
	{}
	public void logout(Login ls)
	{
		ls.remove(ls.jp1);
		ls.remove(ls.jp2);
		ls.remove(ls.jp3);
		ls.setSize(360, 600);
		ls.revalidate();
		ls.repaint();
	}
}
