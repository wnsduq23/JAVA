import javax.swing.*;
import java.awt.*;

public class SliderEx extends JFrame 
{
	public SliderEx() 
	{
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);//수평or수직, 최소,최대,초깃값
		slider.setPaintLabels(true);//레이블 보이기/ 감추기
		slider.setPaintTicks(true);//tick 보이기/감추기
		slider.setPaintTrack(true); // track보이기/감추기
		slider.setMajorTickSpacing(50);//큰 눈금 간격 지정
		slider.setMinorTickSpacing(10);//작은 눈금 간격 지정
		c.add(slider);
		
		setSize(300,100);
		setVisible(true);
	}

	public static void main(String [] args) 
	{
		new SliderEx();
	}
}