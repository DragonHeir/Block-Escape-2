import java.awt.Color;
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
	public Rectangle cBox;
	public Rectangle eBox;
	boolean isFalling = true;
	float val = 0.0f;
	int val2 = 0;

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
		eBox = new Rectangle(x, y + 16, width/2, height/2);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(cBox.x, cBox.y, cBox.width, cBox.height);
		g.drawRect(eBox.x, eBox.y, eBox.width, eBox.height);
		g.drawImage(image, x, y, width, height, null);
	}
//	public void scroll() {
////		if (!isFalling){
//			val = val + 0.1f;
//		if (val >= 8) {
//			cBox.y = (int) (cBox.y + 16);
//			y = (int) (y + 16);
//			val = 0.0f;
//			val2 = val2 + 1;
//		}
//		}
//	}
	public void refresh()
	{
		if (isFalling)
		{
		y = y + 8;
		if(y >= 480 - 16)
		{
			y = 480 - 16;
			isFalling = false;
		}
		else{
		cBox.setBounds(x, y + 8, width, height);
		eBox.setBounds(x + 4, y + 16, width/2, height/2);
		}}
		else
		{			
			cBox.setBounds(x, y, width, height);
			eBox.setBounds(x + 4, y + 8, width/2, height/2);
		}
	}
	public Rectangle getBox()
	{
		return cBox;
	}
	public Rectangle getDeathBox(){
		return eBox;
	}
	public void setX(int a)
	{
		x = a;
		eBox.x = x + 4;
	}
	public void setY(int b)
	{
		y = b;
		cBox.y = y;
		eBox.y = y + 8;
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