import java.awt.*;
import javax.swing.*;

public class chap09_2 extends JFrame
{
	chap09_2()
	{
		setTitle("BorderLayout Practice");//JFrame ������ �⺻���� �� 1
		setDefaultCloseOperation(EXIT_ON_CLOSE);//1
		
		Container box=getContentPane();//�����̳ʰ� JFrame ���� ����Ʈ���� ����Ű�� �� ��
		box.setLayout(new BorderLayout(5,7));//�����̳� ���� ������Ʈ���� ��� ��ġ�ɰ��� ����.(���򰣰�:5,��������:7)
		
		//������Ʈ�� �����̳� ���� �ִ� ����
		box.add(new JButton("North"), BorderLayout.NORTH);
		box.add(new JButton("West"), BorderLayout.WEST); 
		box.add(new JButton("Center"), BorderLayout.CENTER); 
		box.add(new JButton("East"), BorderLayout.EAST); 
		box.add(new JButton("South"), BorderLayout.SOUTH);
		
		setSize(500,300);//1
		setVisible(true);//1

	}
	public static void main(String []args)
	{
		new chap09_2();
	}

}

// JFrame ���� ->JPanel ���� �� ����-> ������Ʈ ��ġ ����->������Ʈ ��ü ���� -> ������Ʈ ���� 