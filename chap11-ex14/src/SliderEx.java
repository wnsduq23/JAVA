import javax.swing.*;
import java.awt.*;

public class SliderEx extends JFrame 
{
	public SliderEx() 
	{
		setTitle("�����̴� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);//����or����, �ּ�,�ִ�,�ʱ갪
		slider.setPaintLabels(true);//���̺� ���̱�/ ���߱�
		slider.setPaintTicks(true);//tick ���̱�/���߱�
		slider.setPaintTrack(true); // track���̱�/���߱�
		slider.setMajorTickSpacing(50);//ū ���� ���� ����
		slider.setMinorTickSpacing(10);//���� ���� ���� ����
		c.add(slider);
		
		setSize(300,100);
		setVisible(true);
	}

	public static void main(String [] args) 
	{
		new SliderEx();
	}
}