package Num2;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class MR implements Runnable
{
	private JPanel p;
	private int flag=1;
	public MR(JPanel p)
	{
		this.p=p;
	}
	public void setFlag(int flag)
	{
		this.flag=flag;
	}
	
	synchronized public void start()
	{
		flag=1;
		this.notify();
	}
	
	synchronized public void waitI()
	{
		if(flag==0)
		{
			try
			{
				this.wait();
			}catch(Exception e)
			{
				e.printStackTrace(); 
			}
		}
	}
	
	public void run()
	{
		synchronized (this)
		{
			try {
				wait();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		while(true)
		{
			try
			{
				waitI();
				
				p.repaint();
				
				Thread.sleep(300);//300ms �ð� ����
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
class MP extends JPanel
{
	private int x,y,width,height;
	public void paintComponent(Graphics g)//������ �׷��ִ� �޼ҵ�
	{
		super.paintComponent(g);//������Ʈ �ڽ��� ���� ����� �׸��� ��ɾ�
		g.setColor(Color.MAGENTA);
		randomCircle();
		g.fillOval(x, y, width, height);
	}
	
	public void randomCircle()//�������� ���� ���� ���� ���̸� �����ϴ� �޼ҵ�
	{
		x= (int)(Math.random()*getWidth());
		y=(int)(Math.random()*getHeight());
		width=(int)(Math.random()*getWidth()/2);
		height=(int)(Math.random()*getHeight()/2);
	}
}

public class JC18011591E2 extends JFrame
{
	private MR run;
	private MP p;
	Thread th;
	public JC18011591E2()
	{
		setTitle("Make Drawing to Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p=new MP();
		setContentPane(p);
		MMAL l = new MMAL();
		
		addMouseListener(l);
		
		run = new MR(p);
		th = new Thread(run);
		
		setSize(400,500);
		setVisible(true);
		th.start();
	}
	class MMAL extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			run.start();
		}
		public void mouseExited(MouseEvent e)
		{
			run.setFlag(0);
		}
	}
	public static void main(String [] args)
	{
		new JC18011591E2();
	}

}
