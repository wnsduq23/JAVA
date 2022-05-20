import javax.swing.*;
import java.awt.*;

public class ButtonEx extends JFrame 
{
	public ButtonEx() 
	{
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// 3개의 이미지를 파일로부터 읽어들인다.
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif"); 
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif"); 
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif"); 
		
		// 3개의 이미지를 가진 버튼 생성
		JButton btn = new JButton("call~~", normalIcon); // normalIcon용 이미지 등록
		btn.setPressedIcon(pressedIcon); // pressedIcon용 이미지 등록, 버튼을 누르고 있는 동안 출력되는 이미지
		btn.setRolloverIcon(rolloverIcon); // rolloverIcon용 이미지 등록 , 버튼에 마우스가 올라갈 때 출력되는 이미지
		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) 
	{
		new ButtonEx();
	}
}