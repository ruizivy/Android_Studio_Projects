package com.npc.myGame.entities;

import java.awt.Graphics;
import java.awt.Image;

import com.npc.myGame.engine.GameEngine;
import com.npc.myGame.utilities.Util;


public class Hero 
{
	private int heroWidth = 32;
	private int heroHeight = 54;
	private int heroX;
	private int heroY;
	public int heroXX;
	public static int index;
	public static boolean block1B = false;
	public static boolean block1T = false;
	public boolean isInTop = false;
	public boolean isInSide = false;
	public boolean isInBottom = false;
	Image heroImage;
	String heroLPath = "src/image/mLStand.png";
	String heroRPath = "src/image/mRStand.png";
	String heroRRun1Path = "src/image/mRRun1.png";
	String heroRRun2Path = "src/image/mRRun2.png";
	String heroLRun1Path = "src/image/mLRun1.png";
	String heroLRun2Path = "src/image/mLRun2.png";
	String heroRJumpPath = "src/image/mRJump.png";
	String heroLJumpPath = "src/image/mLJump.png";
	String heroDeadPath = "src/image/mDead.png";
	public Hero()

	{
		this.heroX = 0;
		this.heroY = 0;
	}
	
	public void drawHero(Graphics g) 
	{
		if(GameEngine.heroState == 1)
		{
			heroImage = Util.LoadImage(heroRPath);
		}
		else  if(GameEngine.heroState == 2 && GameEngine.right ==false)
		{
			heroImage = Util.LoadImage(heroLPath);
		}
		if(GameEngine.heroRRunState == 0 && GameEngine.right == true)
		{
			heroImage = Util.LoadImage(heroRRun1Path);
		}
		else if(GameEngine.heroRRunState == 1 && GameEngine.right ==true)
		{
			heroImage = Util.LoadImage(heroRRun2Path);
		}
		else if(GameEngine.heroRRunState == 2 && GameEngine.right ==true)
		{
			heroImage = Util.LoadImage(heroRRun1Path);
		}
		else if(GameEngine.heroRRunState == 3 && GameEngine.right ==true)
		{
			heroImage = Util.LoadImage(heroRPath);
		}
		if(GameEngine.heroLRunState == 0 && GameEngine.left == true)
		{
			heroImage = Util.LoadImage(heroLRun1Path);
		}
		else if(GameEngine.heroLRunState == 1 && GameEngine.left ==true )
		{
			heroImage = Util.LoadImage(heroLRun2Path);
		}
		else if(GameEngine.heroLRunState == 2 && GameEngine.left ==true)
		{
			heroImage = Util.LoadImage(heroLRun1Path);
		}
		else if(GameEngine.heroLRunState == 3 && GameEngine.left ==true)
		{
			heroImage = Util.LoadImage(heroLPath);
		}
		if( GameEngine.jump ==true && GameEngine.right == true)
		{
			heroImage = Util.LoadImage(heroRJumpPath);
		}
		else if( GameEngine.jump ==true && GameEngine.heroState == 1)
		{
			heroImage = Util.LoadImage(heroRJumpPath);
		}
		if( GameEngine.jump ==true && GameEngine.left == true)
		{
			
			heroImage = Util.LoadImage(heroLJumpPath);
		}
		else if( GameEngine.jump ==true && GameEngine.heroState == 2 && GameEngine.right ==false)
		{
			heroImage = Util.LoadImage(heroLJumpPath);
		}
		if(GameEngine.gameOver == true)
		{
			heroImage = Util.LoadImage(heroDeadPath);
		}
		g.drawImage(heroImage, heroX, heroY, heroWidth, heroHeight, null);
	}
	public void setHero(int x,int y)
	{
		this.heroX = x;
		this.heroY = y;
	}
	
	public boolean isInTop()
	{
		for(int i = 0; i < Floor.floor.size();i++)
		{
			if(heroY+54 + GameEngine.vsp > Floor.floor.get(i).getLocation().y
				&& heroX + 32  > Floor.floor.get(i).getLocation().x
				&& heroX   < Floor.floor.get(i).getLocation().x + Floor.floorkWidth.get(i)
				&& heroY + GameEngine.vsp < Floor.floor.get(i).getLocation().y + Floor.floorHeight.get(i))
			{
				index = i;
				isInTop = true;
			}
		}
		for(int i = 0; i < Block.block.size();i++)
		{
			if(heroY+54 + GameEngine.vsp > Block.block.get(i).getLocation().y
				&& heroX + 32  > Block.block.get(i).getLocation().x
				&& heroX   < Block.block.get(i).getLocation().x + Block.blockkWidth.get(i)
				&& heroY + GameEngine.vsp < Block.block.get(i).getLocation().y + Block.blockHeight.get(i))
			{
				index = i;
				block1T = true;
				isInTop = true;
			}
		}
		return isInTop;
	}
	
	public boolean isInSide()
	{
		for(int i = 0; i < Floor.floor.size();i++)
		{
			
			if(heroX + 32 - GameEngine.hsp > Floor.floor.get(i).getLocation().x
				&& heroX - GameEngine.hsp < Floor.floor.get(i).getLocation().x + Floor.floorkWidth.get(i)
				&& heroY < Floor.floor.get(i).getLocation().y + Floor.floorHeight.get(i)
				&& heroY + 54 > Floor.floor.get(i).getLocation().y )
			{
				if(heroX + 32 - GameEngine.hsp > Floor.floor.get(i).getLocation().x && GameEngine.right == true)
				{
					GameEngine.floorX += 1;
					GameEngine.heroX += 1;
					
				}
				if(heroX - GameEngine.hsp < Floor.floor.get(i).getLocation().x + Floor.floorkWidth.get(i)&&GameEngine.left == true)
				{
					GameEngine.floorX -= 1;
					GameEngine.heroX -= 1;
				}
			
				isInSide = true;
			}	
			
		}
		for(int i = 0; i < Block.block.size();i++)
		{
			
			if(heroX + 32 - GameEngine.hsp > Block.block.get(i).getLocation().x
				&& heroX - GameEngine.hsp < Block.block.get(i).getLocation().x + Block.blockkWidth.get(i)
				&& heroY < Block.block.get(i).getLocation().y + Block.blockHeight.get(i)
				&& heroY + 54 > Block.block.get(i).getLocation().y )
			{
				if(heroX + 32 - GameEngine.hsp > Block.block.get(i).getLocation().x && GameEngine.right == true)
				{
					GameEngine.floorX += 1;
					GameEngine.heroX += 1;
					GameEngine.temp += 1;
					
				}
				if(heroX - GameEngine.hsp < Block.block.get(i).getLocation().x + Block.blockkWidth.get(i)&&GameEngine.left == true)
				{
					GameEngine.floorX -= 1;
					GameEngine.heroX -= 1;
					GameEngine.temp -= 1;
				}
			
				isInSide = true;
			}	
			
		}
		return isInSide;
	}
	
	public boolean isInBottom()
	{
		for(int i = 0; i < Floor.floor.size();i++)
		{
			if(heroY + GameEngine.vsp  < Floor.floor.get(i).getLocation().y + Floor.floorHeight.get(i)
				&& heroX + 32 > Floor.floor.get(i).getLocation().x
				&& heroX < Floor.floor.get(i).getLocation().x + Floor.floorkWidth.get(i)
				&& heroY+54  > Floor.floor.get(i).getLocation().y )
			{
				index = i;
				isInBottom = true;
			}
		}
		for(int i = 0; i < Block.block.size();i++)
		{
			if(heroY + GameEngine.vsp  < Block.block.get(i).getLocation().y + Block.blockHeight.get(i)
			&& heroX + 32 > Block.block.get(i).getLocation().x
			&& heroX < Block.block.get(i).getLocation().x + Block.blockkWidth.get(i)
			&& heroY+54  > Block.block.get(i).getLocation().y )
			{
				index = i;
				block1B = true;
				isInBottom = true;
			}
		}
		return isInBottom;
	}
	
	public boolean isDead()
	{
		for(int i = 0 ; i < Enemy.enemy.size();i++)
		{
			if(heroY < Enemy.enemy.get(i).getLocation().y + Enemy.enemyHeight.get(i)
			&& heroY + 54 > Enemy.enemy.get(i).getLocation().y
			&& heroX < Enemy.enemy.get(i).getLocation().x + Enemy.enemyWidth.get(i)
			&& heroX + 32 > Enemy.enemy.get(i).getLocation().x )
			{
			return true;
			}
		}
		return false;
	}
}
