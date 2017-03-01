import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Tile
{
	private int width;
	private int height;
	private Image img;
	private boolean passable;
	
	public Tile()
	{
		width = 0;
		height = 0;
		img = null;
		passable = false;
	}
	
	public Tile(int width, int height, String imgSrc, boolean passable)
	{
		this.width = width;
		this.height = height;
		this.img = getImage(imgSrc);
		this.passable = passable;
	}
	
	public Image getImage(String img) //Laddar in Tilens texture
	{
		return Toolkit.getDefaultToolkit().getImage(img);
	}
	
	public boolean isPassable()
	{
		return passable;
	}
}
