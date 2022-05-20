package Num2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JC18011591E2 extends JFrame
{
	JLabel l= new JLabel("C");

	public JC18011591E2()
	{
		setTitle("클릭 연습 용 응용프로그램..");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l.setSize(150,100);
		l.setLocation(100,100);
		l.addMouseListener(new MMA());
		
		add(l);
		
		setSize(400,650);
		setVisible(true);
	}
	class MMA extends MouseAdapter
	{
		public void mousePressed(MouseEvent e) 
		{
			int x = (int)(Math.random()*300);//여백 남김 
			int y = (int)(Math.random()*500);
			l.setLocation(x,y);
		}
	}
	public static void main(String [] args)
	{
		new JC18011591E2();
	}

	
}
