import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L; //Vet inte vad detta �r, men slipper se en varning om denna finns h�r
	private Player player;
	private Map map1;
	private Image image;
	private Graphics graphics;
	private boolean playerLeft;
	private boolean playerRight;
	private boolean playerUp;
	private boolean playerDown;
	
	public Game() //Deafault konstruktor
	{
		//Program f�nstret
		setTitle("Projekt"); //Titeln p� f�nstret
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //St�nger av programmet om man trycker p� krysset
		setSize(1200, 800); //F�nstrets storlek
		setResizable(false); //M�jligheten att �ndra f�nstrets storlek
		setBackground(Color.black); //F�nstrets bakgrund
		
		addKeyListener(this); //L�gger till en keyListener
		
		playerLeft = false;
		playerRight = false;
		playerUp = false;
		playerDown = false;
		player = new Player(200, 200, "images/player1.png", 30, 30); //Skapar spelaren
		
		map1 = new Map(24, 16, 2, "map1.txt");
		
		setVisible(true); //Denna ska vara sist
	}
	
	public void paint(Graphics g)
	{
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		map1.draw(g);
		player.draw(g);
		player.update(this, map1);
	}
	
	public static void main(String[] args)
	{
		new Game();
	}

	//Tagentbords intagningen
	public void keyPressed(KeyEvent e) //Booleans �ndras till true om knappen trycks ner
	{
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			playerUp = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			playerDown = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			playerLeft = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			playerRight = true;
		}
		
	}

	public void keyReleased(KeyEvent e) //Booleans �ndras till false n�r de sl�pps
	{
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			playerUp = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			playerDown = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			playerLeft = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			playerRight = false;
		}
	}

	public void keyTyped(KeyEvent arg0) //Denna m�ste vara med men kommer nog inte anv�ndas
	{
		
	}

	//Set och Get metoder
	public boolean isPlayerLeft()
	{
		return playerLeft;
	}

	public void setPlayerLeft(boolean playerLeft)
	{
		this.playerLeft = playerLeft;
	}

	public boolean isPlayerRight()
	{
		return playerRight;
	}

	public void setPlayerRight(boolean playerRight)
	{
		this.playerRight = playerRight;
	}

	public boolean isPlayerUp()
	{
		return playerUp;
	}

	public void setPlayerUp(boolean playerUp)
	{
		this.playerUp = playerUp;
	}

	public boolean isPlayerDown()
	{
		return playerDown;
	}

	public void setPlayerDown(boolean playerDown)
	{
		this.playerDown = playerDown;
	}
	
}
