import java.awt.Graphics;
import java.awt.Image;

public abstract class Entity
{
	protected Image img;
	protected int xPos;
	protected int yPos;
	protected int height;
	protected int width;
	
	public Entity() //Default Konstruktor
	{
		this.xPos = 0;
		this.yPos = 0;
		this.img = null;
		this.height = 0;
		this.width = 0;
	}
	
	public Entity(int xPos, int yPos, String imgSrc, int width, int height) //Konstruktor
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.img = getImage(imgSrc);	//imgSrc �r l�nken till bilden och bilden h�mtas fr�n metoden getImage
		this.height = height;
		this.width = width;
	}
	
	//Abstracta metoder
	abstract void draw(Graphics g);
	abstract void update(Game game, Map map);
	abstract Image getImage(String img);
	
	
	//Get och Set metoder
	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public Image getImg()
	{
		return img;
	}

	public void setImg(Image img)
	{
		this.img = img;
	}

	public int getxPos()
	{
		return xPos;
	}

	public void setxPos(int xPos)
	{
		this.xPos = xPos;
	}

	public int getyPos()
	{
		return yPos;
	}

	public void setyPos(int yPos)
	{
		this.yPos = yPos;
	}
	
	
}
