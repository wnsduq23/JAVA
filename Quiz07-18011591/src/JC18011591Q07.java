import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JC18011591Q07 extends JFrame
{
	JPanel con = new JPanel();
	JC18011591Q07()
	{
		setTitle("�巡�뵿�� YELLOW...");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(con);
		con.setBackground(Color.GREEN);
		con.addMouseMotionListener(new MMA1());
		con.addMouseListener(new MMA2());
		setSize(400,640);
		
		setVisible(true);
	}
	class MMA1 extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e) 
		{
			con.setBackground(Color.YELLOW);
		}
	}
	//MouseAdapter�� ��� �޴� Ŭ����
	class MMA2 extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e) 
		{
			// ������ ���콺 ��ư�� ������ ��
			con.setBackground(Color.GREEN);
		}
	}
	public static void main(String [] args)
	{
		new JC18011591Q07();
	}
}