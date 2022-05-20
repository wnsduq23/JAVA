import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPlusMinusFrame extends JFrame 
{
	public KeyPlusMinusFrame() 
	{
		super("+,- 키로 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
	
		JLabel label = new JLabel("Love Java");
		c.add(label);
		
		label.setFont(new Font("TimesRoman", Font.PLAIN, 10)); // 10 픽셀 크기 , 폰트 이름, 폰트 스타일, 폰트크기,
		label.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyChar() == '+') 
				{
					JLabel la = (JLabel)e.getSource();//키이벤트가 레이블에 발생했을때
					Font f = la.getFont();//la의 폰트를 구함
					int size = f.getSize();//la의 사이즈를 구함
					la.setFont(new Font("TimesRoman", Font.PLAIN, size+5));//la의 폰트를 설정 					
				}
				else if(e.getKeyChar() == '-') 
				{
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if(size <= 5)
						return;
					la.setFont(new Font("TimesRoman", Font.PLAIN, size-5)); 					
				}				
			}
		});

		setSize(300,150);
		setVisible(true);
		
		label.setFocusable(true); // 레이블이 포커스를 받을 수 있도록 지정
		label.requestFocus(); // 레이블에 키 입력 포커스 서정
	}
	static public void main(String [] args) 
	{
		new KeyPlusMinusFrame();
	}
}