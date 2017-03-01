import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Player extends Entity
{
	private int score;
	
	
	
	public Player() //Default konstruktor
	{
		super();
		score = 0;
	}
	
	public Player(int xPos, int yPos, String imgSrc, int width, int height) //Konstruktor
	{
		super(xPos, yPos, imgSrc, width, height);
		score = 0;
	}
	
	
	//Override fr�n Entity
	public void draw(Graphics g) //Players draw metod
	{
		g.drawImage(img, xPos, yPos, width, height, null);
	}
	
	public void update(Game game, Map map)
	{
		float dx = 0;
		float dy = 0;
		int velocity = 1;
		//Spelarens r�relse
		if(game.isPlayerUp()) 
		{	//F�rklaring av nedanst�ende if sats: F�rst kollar vi om spelaren �r utanf�r f�nstret. Sen kollar vi om spelarens (i nedanst�ende fall) v�nstra kant r�r en v�gg. Sist kollar vi om spelarens h�gra kant r�r en v�gg.
			if(yPos > 0 && map.validLocation(((xPos + 1) / 50), ((yPos - 1) / 50)) && map.validLocation(((xPos + width - 1) / 50), ((yPos - 1) / 50))) //-1 i detta fall �r f�r spelarens texture kunde g� in i v�ggen en smula
			{
				dy -= velocity;
				//yPos -= (10 * 100) / 1000;	//1000 �r f�r milisekunder, har vi 1000 ska det tydligen flyta p� b�ttre. (10 * 100) �r oklart, men summan m�ste vara >= med 1000
			}
		}
		if(game.isPlayerDown()) //Har vi if else kan man bara g� �t ett h�ll i taget, vilket bara blir totalt 4 riktningar. Har vi 4 if satser kan vi g� �t alla 8 riktningar
		{
			if(yPos < 800 - height && map.validLocation(((xPos + width - 1) / 50), ((yPos + height) / 50)) && map.validLocation(((xPos + 1) / 50), ((yPos + height) / 50)))	//Denna st�mmer inte helt, en liten bit av spelaren hamnar utanf�r
			{
				dy += velocity;
				//yPos += (10 * 100) / 1000;
			}
		}
		if(game.isPlayerLeft())
		{
			if(xPos > 0 && map.validLocation((xPos / 50), ((yPos + 1) / 50)) && map.validLocation((xPos / 50), ((yPos +  height -1) / 50))) //+1 och -1 �r f�r att spelaren ska kunna r�ra sig till v�nster om han r�r en v�gg ovanifr�n
			{
				dx -= velocity;
				//xPos -= (10 * 100) / 1000;
			}
			
		}
		if(game.isPlayerRight())
		{
			if(xPos < 1200 - width && map.validLocation(((xPos + width) / 50), ((yPos + height -1) / 50)) && map.validLocation(((xPos + width) / 50), ((yPos + 1) / 50))) //+1 och -1 �r f�r att spelaren ska kunna r�ra sig till h�ger om han r�r en v�gg underifr�n
			{
				dx += velocity;
				//xPos += (10 * 100) / 1000;
			}
		}
		
		if(dx != 0) //Spelarens r�relse �t h�ger och v�nster
		{
			xPos += dx;
		}
		if(dy != 0) //Spelarens r�relse upp eller ner
		{
			yPos += dy;
		}
	}
	
	public Image getImage(String img) //Laddar in spelarens texture
	{
		return Toolkit.getDefaultToolkit().getImage(img);
	}
	
	//Get och Set
	public int getScore()
	{
		return score;
	}

	public void addScore(int score)
	{
		this.score += score;
	}

	

	
}
