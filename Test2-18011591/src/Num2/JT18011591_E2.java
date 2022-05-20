package Num2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TimerRunnable implements Runnable//
{
	private JLabel timerL;
	
	public TimerRunnable(JLabel timerL)
	{
		this.timerL= timerL;
	}
	public void run() 
	{
		int n=0; 
		while(true) 
		{
			timerL.setText(Integer.toString(n)); 
			n++;
			try 
			{
				Thread.sleep(1000);//
			}
			catch(InterruptedException e) 
			{
				return;
			}
		}
	}
}
public class JT18011591_E2 extends JFrame
{
	private JLabel a = new JLabel("Hello");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	public JT18011591_E2()
	{
		setTitle("멀티쓰레드 스윙 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c =getContentPane();
		
		c.setLayout(new GridLayout(2,1,12,12));//hgap, vgap
		c.add(p1);
		c.add(p2);
		p1.addMouseListener(new MMA());
		p1.setLayout(null);

		
		a.setSize(50,20);
		a.setLocation(30,30);
		p1.add(a);
		
		JLabel timerL = new JLabel();
		timerL.setFont(new Font("Gothic",Font.ITALIC,80));
		
		TimerRunnable runnable = new TimerRunnable(timerL);
		Thread th = new Thread(runnable); // 
		p2.add(timerL);
		
		setSize(350,400);
		setVisible(true);
		
		th.start();
	}
	class MMA extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			int x=e.getX();
			int y=e.getY();
			a.setLocation(x,y);
		}
	}
	public static void main(String [] args)
	{
		new JT18011591_E2();
	}

}
//thread와 다른 점 
