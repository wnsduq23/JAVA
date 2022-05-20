import java.awt.*;
import javax.swing.*;

public class chap09_2 extends JFrame
{
	chap09_2()
	{
		setTitle("BorderLayout Practice");//JFrame 형성시 기본적인 것 1
		setDefaultCloseOperation(EXIT_ON_CLOSE);//1
		
		Container box=getContentPane();//컨테이너가 JFrame 내의 컨텐트팬을 가리키게 한 후
		box.setLayout(new BorderLayout(5,7));//컨테이너 내의 컴포넌트들이 어떻게 배치될건지 설정.(수평간격:5,수직간격:7)
		
		//컴포넌트를 컨테이너 내에 넣는 과정
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

// JFrame 형성 ->JPanel 있을 시 형성-> 컴포넌트 배치 설정->컴포넌트 자체 설정 -> 컴포넌트 대입 