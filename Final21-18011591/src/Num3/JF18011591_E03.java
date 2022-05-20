package Num3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JF18011591_E03 extends JFrame
{
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	private JLabel la = new JLabel("No Mouse Event"); // �޽��� ��� ���̺� ������Ʈ
	private JLabel l3= new JLabel("18011591");
	public JF18011591_E03()
	{
		setTitle("��Ƽ������ ���� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c =getContentPane();
		
		c.setLayout(new GridLayout(2,2,12,12));
		p1.addKeyListener(new MyKeyListener());
		c.add(p1);

		c.add(p2);
		p2.addMouseListener(new MyMouseListener());
		p2.addMouseMotionListener(new MyMouseListener());
		p2.add(la);
		c.add(p3);
		l3.addMouseListener(new MMA());
		p3.add(l3);
		p4.addMouseMotionListener(new MMA1());
		p4.addMouseListener(new MMA2());
		c.add(p4);
		
		
		
		setSize(720,720);
		setVisible(true);
		p1.setFocusable(true);
		p1.requestFocus();
	}
	class MyKeyListener extends KeyAdapter 
	{
		public void keyPressed(KeyEvent e) 
		{
			Container contentPane = (Container)e.getSource();

			if(e.getKeyCode() == KeyEvent.VK_1) // �Էµ� Ű��  % �� ���
				contentPane.setBackground(Color.RED);
			else if(e.getKeyCode() == KeyEvent.VK_F1) // �Էµ� Ű�� <F1> �ΰ�
				contentPane.setBackground(Color.GREEN);
			else if(e.getKeyCode() == KeyEvent.VK_2) 
				contentPane.setBackground(Color.BLUE);
			else if(e.getKeyCode() == KeyEvent.VK_3) 
				contentPane.setBackground(Color.YELLOW);
		}
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener 
	{
		// MouseListener�� 5�� �޼ҵ� ����
		public void mousePressed(MouseEvent e) 
		{
			la.setText("mousePressed ("+e.getX()+","+e.getY()+")"); // ���콺�� ������ ��ġ (x,y) ���� ���
		}
		public void mouseReleased(MouseEvent e) 
		{
			la.setText("MouseReleased("+e.getX()+","+e.getY()+")"); // ���콺�� ������ ��ġ (x,y) ���� ���
		}
		public void mouseClicked(MouseEvent e) 
		{}
		public void mouseEntered(MouseEvent e) 
		{
			Component c = (Component)e.getSource(); // ���콺�� �ö� ������Ʈ�� �˾Ƴ���.
			c.setBackground(Color.CYAN);
		}
		public void mouseExited(MouseEvent e) 
		{
			Component c = (Component)e.getSource(); // ���콺�� ������ ������Ʈ�� �˾Ƴ���.
			c.setBackground(Color.YELLOW);
		}
		
		// MouseMotionListener�� 2�� �޼ҵ� ����
		public void mouseDragged(MouseEvent e) 
		{ // ���콺�� �巡��Ǵ� ���� ��� ȣ��
			la.setText("MouseDragged ("+e.getX()+","+e.getY()+")");
		}
		public void mouseMoved(MouseEvent e) 
		{ // ���콺�� �����̴� ���� ��� ȣ��
			la.setText("MouseMoved ("+e.getX()+","+e.getY()+")");
		}
	}
	class MMA extends MouseAdapter
	{
		public void mousePressed(MouseEvent e) 
		{
			int x = (int)(Math.random()*300);//���� ���� 
			int y = (int)(Math.random()*500);
			l3.setLocation(x,y);
		}
	}
	class MMA1 extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e) 
		{
			p4.setBackground(Color.YELLOW);
		}
	}
	class MMA2 extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e) 
		{
			// ������ ���콺 ��ư�� ������ ��
			p4.setBackground(Color.GREEN);
		}
	}
	public static void main(String [] args)
	{
		new JF18011591_E03();
	}
}
