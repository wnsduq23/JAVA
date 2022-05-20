import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class chap11_02 extends JFrame
{
	private JTextField tF;
	private JComboBox cB;
	
	public chap11_02()
	{
		super("JTextFiled and JComponent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        tF = new JTextField(10);
        cB = new JComboBox<String>();//콤보박스의 입력값들이 문자형임을 알려줌
 
        tF.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JTextField tf = (JTextField)e.getSource();
                cB.addItem(tf.getText());
                tf.setText("");//초기화 시킨다
            }
        });
        
        c.add(tF);
        c.add(cB);
 
        setSize(300, 300);
        setVisible(true);

	}
	public static void main (String [] args)
	{
		new chap11_02();
	}

}
