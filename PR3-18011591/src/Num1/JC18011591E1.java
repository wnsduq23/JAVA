package Num1;

import java.awt.*;
import javax.swing.*;

public class JC18011591E1 extends JFrame
{

	JC18011591E1()
	{

		setTitle("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);

		
		Container dot = getContentPane();
		dot.setLayout(null);
		
		for (int i = 0; i < 20; i++) 
		{ 
			int x = (int) (Math.random() * 200) + 50; 
			int y = (int) (Math.random() * 200) + 50; 
			JLabel l = new JLabel(); 
			l.setLocation(x,y);
			l.setSize(10,10);
			l.setBackground(Color.blue); 
			l.setOpaque(true);
			dot.add(l);
		}
		setVisible(true);
	}
	public static void main(String [] args)
	{
		new JC18011591E1();
	}
}
