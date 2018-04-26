package com.npc.myGame.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import com.npc.form.PlayGame;
import com.npc.myGame.entities.Block;
import com.npc.myGame.entities.Enemy;
import com.npc.myGame.entities.Floor;
import com.npc.myGame.entities.Hero;
import com.npc.myGame.utilities.Keyboard;
import com.npc.myGame.utilities.Util;



public class GameEngine extends JPanel implements Runnable,KeyListener 
{
	private static final long serialVersionUID = 1L;
	private Keyboard keys;
	//----Hero movement
	int l = 0;
    int r = 0;
    int j = 0;
    int blockMove=0;
    public static int hsp = 0;
    public static int vsp = 0;
    int velocity = 0;
    int jumpSpeed = 18;
    int grav = 1;
    int move = 0;
	int heroY = 0;
	int heroPositionX= 400;
	public static int heroX = 0;
    int moveSpeed = 5;
    //----
    double spikeX = 0;//----Enemy spike movement
    double score = 0;//----initial score
    double scorecount = 0;
    //----
    public static double floorX=0;//-----Background and Floor Movement
	int count=0;//----Frame Counter
	int state=0;//----Hero Image State sprite
	public static int heroState = 1;
	//----
	int eState=0;//----Enemy Image State sprite
	public static int enemyState = 0;
	//----
	int p = 0;//----Dead Counter
	Random rand = new Random();
	int random = 4;
	//----For Games and key presses
    public static boolean right = false;
    public static boolean left = false;
    public static boolean jump = false;
    public static boolean gameOver = false;
	public static boolean inStartMenu = true;
    public static int heroRRunState = 1;
    public static int heroLRunState = 1;
    boolean isDead=false;
    //----
    //----Class
    SoundEngine bgSound,jumpS,death,bump,themeSong;
	Hero hero;
	Floor floor;
	Block block;
	Enemy enemy;
	Image background,spikes,mainMenu;
	String backgroundPath = "src/image/mBG.png";
	String mainMenuPath = "src/image/mStartMenu.png";
	String spikePath = "src/image/mMainSpike.png";
	//----
	public GameEngine () 
	{
		hero = new Hero();
		floor = new Floor();
		block = new Block();
		enemy = new Enemy();
		keys = Keyboard.getInstance();
		PlayGame.frame.addKeyListener(this);
		
		new Thread(this).start();
		
	}
	@Override
	public void run() 
	{
		try 
		{	
			
			bgSound = new SoundEngine("src/sounds/mBgMusic.wav");
			jumpS = new SoundEngine("src/sounds/Jumping SFX.wav");
			death = new SoundEngine("src/sounds/Death.wav");
			bump = new SoundEngine("src/sounds/Bump V1 SFX.wav");
			themeSong = new SoundEngine("src/sounds/ThemeSong.wav");
			while (true) 
			{
	            Thread.sleep(1); 
	            update();
	        }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
	    }
	}
	int blinkCount= 0;
	protected void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		background = Util.LoadImage(backgroundPath);
		g.drawImage(background, heroX, 0, 1520, 500, null);
		g.drawImage(background, heroX+1500, 0, 1520, 500, null);
		spikes = Util.LoadImage(spikePath);
		g.drawImage(spikes,(int) (floorX + spikeX), 0, 50, 500,null);
		hero.drawHero(g);
		floor.drawFloor(g);
		block.drawBlock(g);
		enemy.drawEnemy(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", 1, 15));
		g.drawString("High Score : "+(int)PlayGame.highScore, 400, 20);
		g.drawString("SCORE: "+ (int)score , 250-100, 20);
		if(gameOver==true && inStartMenu == false)
		{
			g.setFont(new Font("Courier New", 1, 30));
			g.drawString("GAME OVER", 400-100, 250);
		}
		mainMenu = Util.LoadImage(mainMenuPath);
		
		if(inStartMenu == true)
		{
			g.drawImage(mainMenu,0,0,800,500,null);
			if(blinkCount <= 500)
			{	g.setColor(Color.black);
				g.drawString("Press R to Start", 400-70, 250);
				g.setFont(new Font("Courier New", 1, 30));
				g.drawString("GAME START", 400-90, 300);
			}
			if(blinkCount == 700)
				blinkCount=0;
			blinkCount++;
		}
	}
	public static int temp=0;
	private void update()
	{
		repaint();
		if(inStartMenu == true)
		{
			themeSong.Loop();
		}
		if(gameOver==true)
		{	
			
			jumpS.Stop();
			bgSound.Stop();
			isGameOver();
		}
		if(isDead == true)
		{
			
			death.Play();
			isDead = false;
		}
		
		if(gameOver==false && inStartMenu ==false)
		{	
			themeSong.Stop();
			death.Stop();
			if(count % 20 ==0)
			{
				List<String> s = new ArrayList<String>();
				if(score > (int)PlayGame.highScore)
				{
					s.add(score+"");
					try 
					{
						PlayGame.writeFile("src/Score/Score.txt",s);
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			    try 
			    {
			    	PlayGame.readFile("src/Score/Score.txt");
			    	//System.out.println(PlayGame.highScore);
				} 
			    catch (IOException e1) 
			    {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bgSound.Loop();
				p=0;
				collision();
				if(floorX + spikeX + 50 > heroPositionX || heroY > PlayGame.height-100 || hero.isDead())
				{
					count=0;
					gameOver = true;
					isDead=true;
				}
				heroY += vsp;
				heroX += hsp;
				floorX += hsp;
				scorecount += hsp;
				temp+=hsp;
				spikeX += 1;//4.5;//Speed of wall spike
				blockMove +=5;//Speed of Enemy Missile
				if(blockMove > 800+(int)floorX && floorX + 500 < 0)
				{
					blockMove=0+(int)floorX;
					random = rand.nextInt(3);
				}
				setEnemy();
				setTile();
				if(temp+12000 <0)
				{
					temp = temp+12500;
				}
				score = (int)-scorecount/100;
				if(floorX + 1000000 < 0)
				{
					floor.setFloorLocation(floorX+35*10+ 500 *10 , 300,0);
					floor.setFloorLocation(floorX+35*11+ 500 *11 , 300,1);
				}
			}
			if(count % 100 ==0)
			{
				if(right == true)
				{
					//System.out.println(state);
					heroRRunState = state;
				}
				if(left == true)
				{
					//System.out.println(state);
					heroLRunState = state;
				}
				state++;
				if(state == 4)
					state = 0;
			}
			if(count % 50== 0)
			{
				enemyState = eState;
				eState++;
				if(eState == 2)
				{
					eState = 0;
				}
			}
		}
		hero.setHero(heroPositionX,heroY);
		count++;
		changeMovement();
	}
	private void changeMovement() 
	{
		if (keys.isDown(KeyEvent.VK_A))
		{
			left = true;
			   l = 1;
		}
		else if (keys.isDown(KeyEvent.VK_D))
		{
			right = true;
			  r = -1;
		}
		if (keys.isDown(KeyEvent.VK_UP)) 
		{
		}
		else if (keys.isDown(KeyEvent.VK_DOWN)) 
		{
		
		}
	    if (keys.isDown(KeyEvent.VK_SPACE) && jump == false) 
		{
	    	jumpS.Play();
	    	jump = true;
	    	j = 1;
		}
	    if (keys.isDown(KeyEvent.VK_R) && gameOver == true) 
		{
	    	
	    	gameOver = false;
	    	restart();
		}
	    if (keys.isDown(KeyEvent.VK_R) && inStartMenu == true) 
		{
	    	
	    	inStartMenu = false;
		}
	    
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A )
		{
			left = false;
			heroState = 2;
			l = 0;
		}	
		if(key == KeyEvent.VK_D )
		{
			right = false;
			heroState = 1;
			r = 0;
		}
		if(key ==KeyEvent.VK_SPACE )
		{
			j = 0;
		}
	}
	
	private void collision()
	{
		move = l + r;
		hsp = move * moveSpeed;
		if (vsp < 30)
		{ 
			vsp += grav;
		}
		//BG
		if(heroX+1500 <= 0)
		{
			heroX = heroX+1500;
		}
		if(heroX >= 0)
		{
			heroX = heroX-1500;
		}
		if(hero.isInBottom())
		{
			jumpS.Stop();
			bump.Play();
			  j=0;
			  vsp = j * -jumpSpeed;
			  hero.isInBottom = false;
			  if(Hero.block1B==true) 
			  {
				  heroY = Block.block.get(Hero.index).getLocation().y + Block.blockHeight.get(Hero.index);
				  Hero.block1B =false;
			  }
			  else
				heroY = Floor.floor.get(Hero.index).getLocation().y + Floor.floorHeight.get(Hero.index);
		}
		if(hero.isInSide())
		{
			hsp=0;
			hero.isInSide=false;
		}
		if(hero.isInTop())
		{
			vsp = j * -jumpSpeed;
			jump = false;
			
			hero.isInTop=false;
			 if(Hero.block1T == true)
			  {
				 heroY = Block.block.get(Hero.index).getLocation().y - 54;
				 Hero.block1T = false;
			  }
			 else
				 heroY = Floor.floor.get(Hero.index).getLocation().y - 54;
		}
	}
	
	private void setTile()
	{
		floor.setFloorLocation(temp, 430,0);
		floor.setFloorLocation(temp + 500, 430,1);
		//E
		block.setBlockLocation(temp + 500 * 2, 270, 0);
		block.setBlockLocation(temp + 500 * 2, 302, 1);
		block.setBlockLocation(temp + 500 * 2, 334, 2);
		block.setBlockLocation(temp + 500 * 2, 366, 3);
		block.setBlockLocation(temp + 500 * 2, 398, 4);
		block.setBlockLocation(temp + 32 + 500 * 2, 270, 5);
		block.setBlockLocation(temp + 32*2 + 500 * 2, 270, 6);
		block.setBlockLocation(temp + 32 + 500 * 2, 334, 7);
		block.setBlockLocation(temp + 32 + 500 * 2, 398, 8);
		block.setBlockLocation(temp + 32*2 + 500 * 2, 398, 9);
		//R
		block.setBlockLocation(temp + 32*4 + 500 * 2, 270, 10);
		block.setBlockLocation(temp + 32*4 + 500 * 2, 302, 11);
		block.setBlockLocation(temp + 32*4 + 500 * 2, 334, 12);
		block.setBlockLocation(temp + 32*4 + 500 * 2, 366, 13);
		block.setBlockLocation(temp + 32*4 + 500 * 2, 398, 14);
		block.setBlockLocation(temp + 32*5 + 500 * 2, 270, 15);
		block.setBlockLocation(temp + 32*6 + 500 * 2, 270, 16);
		block.setBlockLocation(temp + 32*7 + 500 * 2, 302, 17);
		block.setBlockLocation(temp + 32*5 + 500 * 2, 334, 18);
		block.setBlockLocation(temp + 32*6 + 500 * 2, 334, 19);
		block.setBlockLocation(temp + 32*7 + 500 * 2, 366, 20);
		block.setBlockLocation(temp + 32*7 + 500 * 2, 398, 21);
		//N
		block.setBlockLocation(temp + 32*9 + 500 * 2, 270, 22);
		block.setBlockLocation(temp + 32*9 + 500 * 2, 302, 23);
		block.setBlockLocation(temp + 32*9 + 500 * 2, 334, 24);
		block.setBlockLocation(temp + 32*9 + 500 * 2, 366, 25);
		block.setBlockLocation(temp + 32*9 + 500 * 2, 398, 26);
		block.setBlockLocation(temp + 32*10 + 500 * 2, 302, 27);
		block.setBlockLocation(temp + 32*11 + 500 * 2, 334, 28);
		block.setBlockLocation(temp + 32*12 + 500 * 2, 366, 29);
		block.setBlockLocation(temp + 32*13 + 500 * 2, 270, 30);
		block.setBlockLocation(temp + 32*13 + 500 * 2, 302, 31);
		block.setBlockLocation(temp + 32*13 + 500 * 2, 334, 32);
		block.setBlockLocation(temp + 32*13 + 500 * 2, 366, 33);
		block.setBlockLocation(temp + 32*13 + 500 * 2, 398, 34);
		//I
		block.setBlockLocation(temp + 32*16 + 500 * 2, 270, 35);
		block.setBlockLocation(temp + 32*16 + 500 * 2, 302, 36);
		block.setBlockLocation(temp + 32*16 + 500 * 2, 334, 37);
		block.setBlockLocation(temp + 32*16 + 500 * 2, 366, 38);
		block.setBlockLocation(temp + 32*16 + 500 * 2, 398, 39);
		block.setBlockLocation(temp + 32*15 + 500 * 2, 270, 40);
		block.setBlockLocation(temp + 32*17 + 500 * 2, 270, 41);
		block.setBlockLocation(temp + 32*15 + 500 * 2, 398, 42);
		block.setBlockLocation(temp + 32*17 + 500 * 2, 398, 43);
		//E
		block.setBlockLocation(temp + 32*19 + 500 * 2, 270, 44);
		block.setBlockLocation(temp + 32*19 + 500 * 2, 302, 45);
		block.setBlockLocation(temp + 32*19 + 500 * 2, 334, 46);
		block.setBlockLocation(temp + 32*19 + 500 * 2, 366, 47);
		block.setBlockLocation(temp + 32*19 + 500 * 2, 398, 48);
		block.setBlockLocation(temp + 32*20 + 500 * 2, 270, 49);
		block.setBlockLocation(temp + 32*21 + 500 * 2, 270, 50);
		block.setBlockLocation(temp + 32*20 + 500 * 2, 334, 51);
		block.setBlockLocation(temp + 32*20 + 500 * 2, 398, 52);
		block.setBlockLocation(temp + 32*21 + 500 * 2, 398, 53);
		//System.out.println(32*9+ 500 *9);
		floor.setFloorLocation(temp + 32*23 + 500 * 2, 430, 2);
		floor.setFloorLocation(temp + 32*23 + 500 * 3, 430, 3);
		floor.setFloorLocation(temp + 32*23 + 500 * 4, 430, 4);
		block.setBlockLocation(temp + 32*23 + 500 * 5, 302, 54);
		block.setBlockLocation(temp +120+ 32*23 + 500 * 5, 302, 55);
		block.setBlockLocation(temp +120*2+ 32*23 + 500 * 5, 302, 56);
		block.setBlockLocation(temp +120*3+ 32*23 + 500 * 5, 302, 57);
		block.setBlockLocation(temp +120*4+ 32*23 + 500 * 5, 302, 58);
		block.setBlockLocation(temp +120*5+ 32*23 + 500 * 5, 302, 59);
		block.setBlockLocation(temp +120*6+ 32*23 + 500 * 5, 430, 60);
		block.setBlockLocation(temp +120*7+ 32*23 + 500 * 5, 302, 61);
		block.setBlockLocation(temp +120*8+ 32*23 + 500 * 5, 174, 62);
		block.setBlockLocation(temp +120*9+ 32*23 + 500 * 5, 302, 63);
		block.setBlockLocation(temp +120*10+ 32*23 + 500 * 5, 430, 64);
		block.setBlockLocation(temp +120*11+ 32*23 + 500 * 5, 302, 65);
		block.setBlockLocation(temp +120*12+ 32*23 + 500 * 5, 174, 66);
		block.setBlockLocation(temp +120*13+ 32*23 + 500 * 5, 302, 67);
		block.setBlockLocation(temp +120*14+ 32*23 + 500 * 5, 430, 68);
		block.setBlockLocation(temp +120*15+ 32*23 + 500 * 5, 302, 69);
		block.setBlockLocation(temp +120*16+ 32*23 + 500 * 5, 174, 70);
		block.setBlockLocation(temp +120*17+ 32*23 + 500 * 5, 302, 71);
		block.setBlockLocation(temp +120*18+ 32*23 + 500 * 5, 302, 72);
		block.setBlockLocation(temp +120*19+ 32*23 + 500 * 5, 174, 73);
		block.setBlockLocation(temp +120*20+ 32*23 + 500 * 5, 302, 74);
		block.setBlockLocation(temp +120*21+ 32*23 + 500 * 5, 430, 75);
		block.setBlockLocation(temp +120*22+ 32*23 + 500 * 5, 302, 76);
		block.setBlockLocation(temp +120*23+ 32*23 + 500 * 5, 174, 77);
		block.setBlockLocation(temp +120*24+ 32*23 + 500 * 5, 302, 78);
		block.setBlockLocation(temp +120*25+ 32*23 + 500 * 5, 430, 79);
		block.setBlockLocation(temp +120*26+ 32*23 + 500 * 5, 302, 80);
		block.setBlockLocation(temp +120*27+ 32*23 + 500 * 5, 174, 81);
		block.setBlockLocation(temp +120*28+ 32*23 + 500 * 5, 302, 82);
		block.setBlockLocation(temp +120*29+ 32*23 + 500 * 5, 302, 83);
		block.setBlockLocation(temp +120*30+ 32*23 + 500 * 5, 174, 84);
		block.setBlockLocation(temp +120*31+ 32*23 + 500 * 5, 302, 85);
		
		block.setBlockLocation(temp +120*32+ 32*23 + 500 * 5, 430, 86);
		block.setBlockLocation(temp +120*33+ 32*23 + 500 * 5, 302, 87);
		block.setBlockLocation(temp +120*34+ 32*23 + 500 * 5, 174, 88);
		block.setBlockLocation(temp +120*35+ 32*23 + 500 * 5, 302, 89);
		block.setBlockLocation(temp +120*36+ 32*23 + 500 * 5, 430, 90);
		block.setBlockLocation(temp +120*37+ 32*23 + 500 * 5, 302, 91);
		block.setBlockLocation(temp +120*38+ 32*23 + 500 * 5, 174, 92);
		block.setBlockLocation(temp +120*39+ 32*23 + 500 * 5, 302, 93);
		block.setBlockLocation(temp +120*40+ 32*23 + 500 * 5, 302, 94);
		block.setBlockLocation(temp +120*41+ 32*23 + 500 * 5, 174, 95);
		block.setBlockLocation(temp +120*42+ 32*23 + 500 * 5, 302, 96);
		block.setBlockLocation(temp +120*43+ 32*23 + 500 * 5, 430, 97);
		block.setBlockLocation(temp +120*44+ 32*23 + 500 * 5, 302, 98);
		block.setBlockLocation(temp +120*45+ 32*23 + 500 * 5, 174, 99);
		block.setBlockLocation(temp +120*46+ 32*23 + 500 * 5, 302, 100);
		block.setBlockLocation(temp +120*47+ 32*23 + 500 * 5, 430, 101);
		block.setBlockLocation(temp +120*48+ 32*23 + 500 * 5, 302, 102);
		block.setBlockLocation(temp +120*49+ 32*23 + 500 * 5, 174, 103);
		block.setBlockLocation(temp +120*50+ 32*23 + 500 * 5, 302, 104);
		block.setBlockLocation(temp +120*51+ 32*23 + 500 * 5, 302, 105);
		block.setBlockLocation(temp +120*52+ 32*23 + 500 * 5, 174, 106);
		block.setBlockLocation(temp +120*53+ 32*23 + 500 * 5, 302, 107);
		block.setBlockLocation(temp +120*54+ 32*23 + 500 * 5, 430, 108);
		block.setBlockLocation(temp +120*55+ 32*23 + 500 * 5, 302, 109);
		block.setBlockLocation(temp +120*56+ 32*23 + 500 * 5, 174, 110);
		block.setBlockLocation(temp +120*57+ 32*23 + 500 * 5, 302, 111);
		block.setBlockLocation(temp +120*58+ 32*23 + 500 * 5, 430, 112);
		block.setBlockLocation(temp +120*59+ 32*23 + 500 * 5, 302, 113);
		block.setBlockLocation(temp +120*60+ 32*23 + 500 * 5, 174, 114);
		block.setBlockLocation(temp +120*61+ 32*23 + 500 * 5, 302, 115);
		block.setBlockLocation(temp +120*62+ 32*23 + 500 * 5, 302, 116);
		block.setBlockLocation(temp +120*63+ 32*23 + 500 * 5, 174, 117);
		block.setBlockLocation(temp +120*64+ 32*23 + 500 * 5, 302, 118);
		block.setBlockLocation(temp +120*65+ 32*23 + 500 * 5, 430, 119);
		block.setBlockLocation(temp +120*66+ 32*23 + 500 * 5, 302, 120);
		block.setBlockLocation(temp +120*67+ 32*23 + 500 * 5, 174, 121);
		block.setBlockLocation(temp +120*68+ 32*23 + 500 * 5, 302, 122);
		block.setBlockLocation(temp +120*69+ 32*23 + 500 * 5, 430, 123);
		block.setBlockLocation(temp +120*70+ 32*23 + 500 * 5, 302, 124);
		block.setBlockLocation(temp +120*71+ 32*23 + 500 * 5, 174, 125);
		block.setBlockLocation(temp +120*72+ 32*23 + 500 * 5, 302, 126);
		block.setBlockLocation(temp +120*73+ 32*23 + 500 * 5, 302, 127);
		block.setBlockLocation(temp +120*74+ 32*23 + 500 * 5, 174, 128);
		block.setBlockLocation(temp +120*75+ 32*23 + 500 * 5, 302, 129);
		block.setBlockLocation(temp +120*76+ 32*23 + 500 * 5, 302, 130);
		floor.setFloorLocation(temp +120*77+ 32*23 + 500 * 5, 430,5);
		
	}
	
	private void setEnemy()
	{
		if(random==0)
		{
			enemy.setEnemyLocation(-blockMove+floorX+850, 398, 0);
		}
		if(random==1)
		{
			enemy.setEnemyLocation(-blockMove+floorX+800, 366, 0);
		}
		if(random==2)
		{
			enemy.setEnemyLocation(-blockMove+floorX+800, 270, 0);
		}
		if(random==0)
		{
			enemy.setEnemyLocation(-blockMove+floorX+800, 206, 1);//206
		}
		if(random==1)
		{
			enemy.setEnemyLocation(-blockMove+floorX+800, 142, 1);
		}
		if(random==2)
		{
			enemy.setEnemyLocation(-blockMove+floorX+800, 270, 1);
		}
	}
	
	private void restart()//----Restart Game
	{
		setTile();
		enemy.setEnemyLocation(0, -32, 0);
		enemy.setEnemyLocation(0, -32, 1);
		scorecount = 0;
		random = 4;
		blockMove =0;
		temp=0;
		floorX = 0;
		spikeX = 0;
		heroY = 0;
	}
	
	private void isGameOver()
	{
		if(count % 20 ==0)
		{
			if(p < 10)
			{
				heroY -= vsp+10;
			}
			if (vsp < 30 && p >= 10)
			{ 
				vsp += grav;
			}
			heroY += vsp;
			p++;
		}
	}
}


