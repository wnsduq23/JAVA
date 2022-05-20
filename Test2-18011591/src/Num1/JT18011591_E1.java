package Num1;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JT18011591_E1 extends JFrame
{
	private JLabel la = new JLabel("Hello"); 
	
	public JT18011591_E1()
	{
		setTitle("버튼에 Mouse 이벤트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		c.add(p,BorderLayout.CENTER);
		
		JButton btn = new JButton("Mouse Event 테스트 버튼");
		btn.addMouseListener(new MAL()); 
		c.add(btn,BorderLayout.NORTH);
	
		p.addMouseListener(new MML());
		la.setSize(50, 20);
		la.setLocation(200, 300);
		p.add(la);
		
		setSize(350, 500);
		setVisible(true);
	}
	class MML extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			int x=e.getX();
			int y=e.getY();
			la.setLocation(x,y);
		}
	}
	class MAL extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e) 
		{
			JButton btn = (JButton)e.getSource();
			btn.setBackground(Color.red);
		}
		
		public void mouseExited(MouseEvent e) 
		{
			JButton btn = (JButton)e.getSource();
			btn.setBackground(Color.yellow);
		}
	}
	public static void main(String [] args)
	{
		new JT18011591_E1();
	}


}

//컨텐트팬에 판넬도 넣는거임!!