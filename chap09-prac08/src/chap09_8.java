import java.awt.*;
import javax.swing.*;

class NorthPanel extends JPanel
{ 
	public NorthPanel() 
	{ 
		setBackground(Color.LIGHT_GRAY); 
		setLayout(new FlowLayout());
		add(new JButton("열기")); 
		add(new JButton("닫기")); 
		add(new JButton("나가기"));  
	}
}
class CenterPanel extends JPanel
{ 
	public CenterPanel() 
	{ 
		setLayout(null); 
		for (int i = 0; i < 20; i++) 
		{ 
			int x = (int)(Math.random()*250); 
			int y = (int)(Math.random()*250); 
			JLabel l=new JLabel("*"); 
			l.setForeground(Color.GREEN); 
			l.setBounds(x,y,20,20);//setLocation+setSize
			l.setOpaque(true); 
			add(l); 
		} 
	} 
}
class SouthPanel extends JPanel
{ 
	public SouthPanel() 
	{ 
		setBackground(Color.YELLOW); 
		add(new JButton("Word Input")); 
		add(new TextField(15));
	} 
}

public class chap09_8 extends JFrame
{
	chap09_8()
	{
		setTitle("여러 개의 패널을 가진 프레임");
		setSize(400, 400); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		NorthPanel nP=new NorthPanel(); 
		CenterPanel nC=new CenterPanel(); 
		SouthPanel nS=new SouthPanel(); 
		
		add(nP, BorderLayout.NORTH); 
		add(nS, BorderLayout.SOUTH); 
		add(nC); 
		
		setVisible(true);
	}
	public static void main(String [] args)
	{
		new chap09_8();
	}

}
