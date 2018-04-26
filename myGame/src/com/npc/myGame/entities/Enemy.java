package com.npc.myGame.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.npc.myGame.engine.GameEngine;
import com.npc.myGame.utilities.Util;

public class Enemy 
{

	public static ArrayList<Point> enemy;
	public static List<Integer> enemyWidth;
	public static List<Integer> enemyHeight;
	Image enemyImage;
	String enemyPath = "src/Enemy/missile1.png";
	String enemyPath2 = "src/Enemy/missile2.png";
	public Enemy()
	{
		enemyWidth = new ArrayList<Integer>();
		enemyHeight = new ArrayList<Integer>();
		enemy = new ArrayList<Point>();
		initEnemy();
	}
	
	public void initEnemy()
	{
		for(int i = 0; i < 2;i++)
		{
			enemyWidth.add(64);
			enemyHeight.add(32);
			enemy.add(new Point(0,-32));
		}
		//floor.add(new Point(GetRandomOnGrid(PlayGame.frame.getSize().width / 20 -5, 1),
			//	 GetRandomOnGrid(PlayGame.frame.getSize().height / 20 -5, 1)));
	}	
	public void setEnemyLocation(double x, int y,int index)
	{
		enemy.get(index).setLocation(x,y);
	}
	
	public void drawEnemy(Graphics g)
	{
		for (int i = 0; i < enemy.size();i++)
		{
			if(GameEngine.enemyState == 0)
			{
				enemyImage = Util.LoadImage(enemyPath);
			}
			if(GameEngine.enemyState == 1)
			{
				enemyImage = Util.LoadImage(enemyPath2);
			}
			
			g.drawImage(enemyImage, (int)enemy.get(i).getX(), (int)enemy.get(i).getY(), enemyWidth.get(i), enemyHeight.get(i), null);
			//g.setColor(Color.white);
			//g.fillRect((int)floor.get(i).getX(), (int)floor.get(i).getY(), floorkWidth.get(i), floorHeight.get(i));
			//g.setColor(Color.blue);
			//g.drawRect((int)floor.get(i).getX(), (int)floor.get(i).getY(), floorkWidth.get(i), floorHeight.get(i));
		}
	}
	
}
