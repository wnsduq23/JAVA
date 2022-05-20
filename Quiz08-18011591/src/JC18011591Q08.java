import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JC18011591Q08 extends JFrame
{
	JTextField tF;
	JComboBox<String> cB;
	
	public JC18011591Q08()
	{
		setTitle("JTextField and JComponent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container e=getContentPane();
		e.setLayout(new FlowLayout());
		
		//tF, cB 정의부
		tF= new JTextField(10);//textField의 크기 결정
		cB= new JComboBox<String>();
		
		tF.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JTextField textF = (JTextField)e.getSource();
				cB.addItem(textF.getText());
				textF.setText("");
			}
		});
		
		e.add(tF);
		e.add(cB);
		
		setSize(350,400);
		setVisible(true);
	}
	
	//class ActionListener extends ActionListener
	public static void main (String [] args)
	{
		new JC18011591Q08();
	}

}
