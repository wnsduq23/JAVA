import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chap10_4 extends JFrame
{
	String text;
	public chap10_4()
	{
		setTitle("Left Ű�� ���ڿ� �̵�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel j=new JLabel("Love Java");
		c.add(j);
		
		c.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) 
			{
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_LEFT) 
				{
					String text=j.getText();
					j.setText(text.substring(1)+text.charAt(0));//���ڿ� �ڸ���+�ڿ� ù�Ӹ� ���� ���̱�
				}
			}
		});
		
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	public static void main (String [] args)
	{
		new chap10_4();
	}

}
