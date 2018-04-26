package com.npc.myGame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.npc.myGame.utilities.Util;

public class Floor {
	public static ArrayList<Point> floor;
	public static List<Integer> floorkWidth;
	public static List<Integer> floorHeight;
	Image floorImage;
	String floorPath = "src/image/mFloor.png";
	public Floor()
	{
		
		floorkWidth = new ArrayList<Integer>();
		floorHeight = new ArrayList<Integer>();
		floor = new ArrayList<Point>();
		initFloor();
	}
	
	public void initFloor()
	{
		for(int i = 0; i < 6;i++)
		{
			floorkWidth.add(500);
			floorHeight.add(32);
			floor.add(new Point(0,-32));
		}
		//floor.add(new Point(GetRandomOnGrid(PlayGame.frame.getSize().width / 20 -5, 1),
			//	 GetRandomOnGrid(PlayGame.frame.getSize().height / 20 -5, 1)));
	}
	
	public void setFloorLocation(double x, int y,int index)
	{
		floor.get(index).setLocation(x,y);
	}

	public void drawFloor(Graphics g)
	{
		for (int i = 0; i < floor.size();i++)
		{
			floorImage = Util.LoadImage(floorPath);	
			g.drawImage(floorImage, (int)floor.get(i).getX(), (int)floor.get(i).getY(), floorkWidth.get(i), floorHeight.get(i), null);
			//g.setColor(Color.white);
			//g.fillRect((int)floor.get(i).getX(), (int)floor.get(i).getY(), floorkWidth.get(i), floorHeight.get(i));
			//g.setColor(Color.blue);
			//g.drawRect((int)floor.get(i).getX(), (int)floor.get(i).getY(), floorkWidth.get(i), floorHeight.get(i));
		}
	}

}
