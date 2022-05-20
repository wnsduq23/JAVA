package Num5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TimerRunnable implements Runnable 
{
	private JLabel timerLabel; 
	
	public TimerRunnable(JLabel timerLabel) 
	{
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() 
	{
		int n=0; 
		while(true) 
		{ 
			timerLabel.setText(Integer.toString(n)); 
			n++; 
			try 
			{
				Thread.sleep(1000); // 1�� ���� ���� �ܴ�.
			}
			
			catch(InterruptedException e) 
			{
				return; // ���ܰ� �߻��ϸ� ������ ����
			}
		}
	}
}
public class JF18011591_E05 extends JFrame
{
	private JLabel a = new JLabel("Hello");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	public JF18011591_E05 ()
	{
		setTitle("��Ƽ������ ���� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c =getContentPane();
		
		c.setLayout(new GridLayout(2,1,12,12));//hgap, vgap
		c.add(p1);
		c.add(p2);


		JLabel timerL = new JLabel();
		timerL.setFont(new Font("Gothic",Font.ITALIC,80));
		
		TimerRunnable runnable = new TimerRunnable(timerL);
		Thread th = new Thread(runnable); // 
		p1.add(timerL);
		
		setSize(300,300);
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
		new JF18011591_E05 ();
	}
}
