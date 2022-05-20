import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxPracticeFrame extends JFrame 
{
	private JButton btn = new JButton("test button");
	public CheckBoxPracticeFrame() 
	{
		super("CheckBox Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox a = new JCheckBox("버튼 비활성화");
		JCheckBox b = new JCheckBox("버튼 감추기");
		c.add(a);
		c.add(b);		
		c.add(btn);
		
		a.addItemListener(new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange() == ItemEvent.SELECTED)//체크박스인 경우 선택되었을때
					btn.setEnabled(false);//비활성화
				else
					btn.setEnabled(true);//활성화
			}
		});
		b.addItemListener(new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange() == ItemEvent.SELECTED)//선택되었을때
					btn.setVisible(false);//감추기
				else
					btn.setVisible(true);//보이기
			}
		});

		setSize(250,150);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new CheckBoxPracticeFrame();
	}
}
