package com.npc.form;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFrame;

import com.npc.myGame.engine.GameEngine;
import com.npc.myGame.utilities.Keyboard;
public class PlayGame 
{
	public static int width = 800;
    public static int height = 490;
    public static double highScore =0;
    public static JFrame frame = new JFrame();
	public static void main(String[] args) throws IOException 
	{
		frame.setTitle("My Game");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);
        GameEngine panel = new GameEngine();
        frame.add(panel);
        readFile("src/Score/Score.txt");
	}
	
	public static void readFile(String fileName) throws IOException
    {
		Path path = Paths.get(fileName);
		String line = null;
		try(BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset()))
		{
			
			while((line = reader.readLine())!= null)
			{
				//System.out.println(line);
				highScore = Double.parseDouble(line);
			}
		}catch(Exception e)
		{
			
		}
		
    }
    
    public static void writeFile(String fileName,List<String> lines)throws IOException
    {
    	Path path = Paths.get(fileName);
    	try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset()))
    	{
    		for (String line :lines)
    		{
    		writer.write(line);
    		writer.newLine();
    		}
    		writer.close();
    	}
    	catch(Exception e)
		{
			
		}
    	
    }

}
