package gui.state;

import gui.minterface.LoginWindow;

import java.awt.event.ActionEvent;

import domain.domainFacade.DomainFacade;
import domain.entities.Login;

public abstract class State {
	protected DomainFacade dFacade;
	protected Login obj;
	abstract public void build(LoginWindow ls);
	
	abstract public void Handle(LoginWindow ls, ActionEvent e);
	
	public void logout(LoginWindow ls)
	{
		ls.remove(ls.jp1);
		ls.remove(ls.jp2);
		ls.remove(ls.jp3);
		ls.setSize(360, 600);
		ls.revalidate();
		ls.repaint();
	}
}
