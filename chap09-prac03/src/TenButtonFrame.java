import java.awt.*;
import javax.swing.*;

public class TenButtonFrame extends JFrame 
{
	public TenButtonFrame() 
	{
		super("Ten Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 10));// 가로개수, 세로개수, 수평간격, 수직간격
		
		JButton [] btn = new JButton [10];
		
		for(int i=0; i<btn.length; i++) 
		{
			btn[i] = new JButton(Integer.toString(i));
			c.add(btn[i]);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new TenButtonFrame();
	}
}
