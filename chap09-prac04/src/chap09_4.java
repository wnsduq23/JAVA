import java.awt.*;
import javax.swing.*;

public class chap09_4 extends JFrame
{
	chap09_4()
	{
		setTitle("Ten Color Buttons Frame"); 
		setSize(500, 400); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container b=getContentPane(); 
		b.setLayout(new GridLayout(1,10));
		
		for(int i=0; i<10; i++) 
		{ 
			Color[] col= {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY};
			String text=Integer.toString(i); 
			JButton box=new JButton(text); 
			box.setBackground(col[i]); 
			b.add(box);
		} 
		
		setVisible(true);
	}
	public static void main(String[] args) 
	{ 
		new chap09_4(); 
	}

}
