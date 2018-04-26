package com.npc.myGame.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.npc.myGame.utilities.Util;

public class Block 
{
	public static ArrayList<Point> block;
	public static List<Integer> blockkWidth;
	public static List<Integer> blockHeight;
	Image blockImage;
	String blockPath = "src/imageBlocks/block1.png";
	public Block()
	{
		blockkWidth = new ArrayList<Integer>();
		blockHeight = new ArrayList<Integer>();
		block = new ArrayList<Point>();
		initBlock();
	}
	
	public void initBlock()
	{
		for(int i = 0; i < 135;i++)
		{
			blockkWidth.add(32);
			blockHeight.add(32);
			block.add(new Point(0,-32));
		}
		//floor.add(new Point(GetRandomOnGrid(PlayGame.frame.getSize().width / 20 -5, 1),
			//	 GetRandomOnGrid(PlayGame.frame.getSize().height / 20 -5, 1)));
	}
	
	public void setBlockLocation(double x, int y,int index)
	{
		block.get(index).setLocation(x,y);
	}
	
	public void drawBlock(Graphics g)
	{
		for (int i = 0; i < block.size();i++)
		{
			blockImage = Util.LoadImage(blockPath);	
			g.drawImage(blockImage, (int)block.get(i).getX(), (int)block.get(i).getY(), blockkWidth.get(i), blockHeight.get(i), null);
			//g.setColor(Color.white);
			//g.fillRect((int)floor.get(i).getX(), (int)floor.get(i).getY(), floorkWidth.get(i), floorHeight.get(i));
			//g.setColor(Color.blue);
			//g.drawRect((int)floor.get(i).getX(), (int)floor.get(i).getY(), floorkWidth.get(i), floorHeight.get(i));
		}
	}
	
}
