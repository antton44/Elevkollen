import java.awt.Color;
import java.awt.Graphics;
import java.io.*;

public class Map
{
	private int[][] tilemap;
	private int width;
	private int height;
	private Tile[] tiles;
	private int x;
	private int y;
	
	public Map()
	{
		width = 0;
		height = 0;
		tilemap = new int[width][height];
		tiles = new Tile[0];
		x = 0;
		y = 0;
	}
	
	public Map(int width, int height, int nrOfMaxTiles, String s)
	{
		this.width = width;
		this.height = height;
		tilemap = new int[width][height];
		tiles = new Tile[nrOfMaxTiles];
		
		tiles[0] = new Tile(50, 50, "images/wall1.png", false);
		tiles[1] = new Tile(50, 50, "images/grass.png", true);
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(s));
			String delimiters = " ";
			for(int row = 0; row < height; row++) 
			{
				String line = br.readLine();
				String[] tokens = line.split(delimiters);
				for(int col = 0; col < width; col++)
				{
					tilemap[col][row] = Integer.parseInt(tokens[col]);
				}
			}
			br.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initMap(String s) throws IOException
	{
		
		
		/*
		for(int i = 0; i < height - 1; i++)
		{
			for(int j = 0; j < width - 1; j++)
			{
				if(i == 0 || i == 15 || j == 0 || j == 23)
				{
					tilemap[j][i] = 0;
				}
				else
				{
					tilemap[j][i] = 1;
				}
				
			}
		}*/
	}
	
	public void draw(Graphics g)
	{
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				int nr = tilemap[j][i];
				
				if(nr == 0)
				{
					g.setColor(Color.red);
				}
				else if(nr == 1)
				{
					g.setColor(Color.white);
				}
				
				g.fillRect(x + j * 50, y + i * 50, 50, 50);
			}
		}
	}
	
	public boolean validLocation(int x, int y)
	{
		int tile = tilemap[x][y];
		if(tiles[tile].isPassable())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
