package Num2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JF18011591_E02 extends JFrame 
{
	public JF18011591_E02() 
	{
		super("기말고사 2번문제, 18011591");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JButton p1 = new JButton("CENTER");
		JButton p2 = new JButton("North");
		JButton p3 = new JButton("South");

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Love Java");
		c.add(label); // 컨텐트팬에 붙이기
		
		p2.setBackground(Color.RED);
		p3.setBackground(Color.RED);
		p1.setBackground(Color.YELLOW);
		c.add(p1, BorderLayout.CENTER);
		
		c.add(p2, BorderLayout.NORTH);
		c.add(p3, BorderLayout.SOUTH);
		

		p2.addMouseListener(new MouseAdapter() //북쪽
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				JButton p2= (JButton)e.getSource();
				p2.setBackground(Color.MAGENTA);
				p1.setBackground(Color.YELLOW);
				p3.setBackground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JButton p2= (JButton)e.getSource();
				p3.setBackground(Color.MAGENTA);
				p2.setBackground(Color.MAGENTA);
				p1.setBackground(Color.YELLOW);
			}			
		});
		p3.addMouseListener(new MouseAdapter() //남쪽
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				JButton p3= (JButton)e.getSource();
				p3.setBackground(Color.GREEN);
				p1.setBackground(Color.YELLOW);
				p2.setBackground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JButton p3= (JButton)e.getSource();
				p2.setBackground(Color.GREEN);
				p3.setBackground(Color.GREEN);
				p1.setBackground(Color.YELLOW);;
			}			
		});
		p1.addMouseListener(new MouseAdapter() //센터
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						JButton p1= (JButton)e.getSource();
						p1.setBackground(Color.PINK);
						p2.setBackground(Color.RED);
						p3.setBackground(Color.RED);
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						JButton p1= (JButton)e.getSource();
						p2.setBackground(Color.PINK);
						p3.setBackground(Color.PINK);
					}			
				});

		setSize(500,300);
		setVisible(true);
	}
	static public void main(String [] args) 
	{
		new JF18011591_E02();
	}
}
