import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class BlockObject
{
	int x;
	int y;
	int width;
	int height;
	BufferedImage image;
	Rectangle cBox;
	boolean isFalling = true;

	BlockObject(int x, int y, int width, int height, String image)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isFalling = true;
		try
		{
			this.image = ImageIO.read(this.getClass().getResourceAsStream(image));
		} 
		catch (IOException e)
		{
			System.out.println("Error Loading Image");
		}
		cBox = new Rectangle(x, y + 16, width, height);
	}
	public void paint(Graphics g)
	{
		g.drawImage(image, x, y, width, height, null);
	}
	public void refresh()
	{
		if (isFalling)
		{
		y = y + 16;
		if(y >= 480 - 16)
		{
			y = 480 - 16;
			isFalling = false;
		}
		else{
		cBox.setBounds(x, y + 16, width, height);
		}}
		else
		{			
			cBox.setBounds(x, y, width, height);
		}
	}
	public Rectangle getBox()
	{
		return cBox;
	}
	public void setX(int a)
	{
		x = a;
	}
	public void setY(int b)
	{
		y = b;
	}
	int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setIsFalling(boolean b)
	{
		isFalling = b;
	}
	public boolean getisFalling()
	{
		return isFalling;
	}
	public boolean checkcoords(int x, int y, ArrayList <BlockObject> blocks)
	{
	for (BlockObject b: blocks)
	{
		if(b.getX()== x && b.getY()== y)
		{
			return true;
		}
	}
	return false;
	}
	boolean isFalling()
	{
		return isFalling;
	}
	public void checkCollision(ArrayList<BlockObject> list)
	{
		for(BlockObject b : list){
			if (b.isFalling)
			{
				continue;
			}
			else if(cBox.intersects(b.getBox()))
			{
				isFalling = false;
			}
	}

}
}