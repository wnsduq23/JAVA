import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventFrame extends JFrame 
{
	public MouseEventFrame() 
	{
		super("마우스 올리기 내리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		c.add(label); // 컨텐트팬에 붙이기
		
		label.addMouseListener(new MouseAdapter() //익명 클래스
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				JLabel la = (JLabel)e.getSource();//레이블 la에 mouseEntered가 된 경우
				la.setText("Love Java");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				JLabel la = (JLabel)e.getSource();
				la.setText("사랑해");
			}			
		});

		setSize(250,150);
		setVisible(true);
	}
	static public void main(String [] args) 
	{
		new MouseEventFrame();
	}
}
