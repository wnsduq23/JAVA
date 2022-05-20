import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class chap11_06 extends JFrame
{
    private JTextArea textArea = new JTextArea(7, 20);
    private JSlider sl = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
    public chap11_06()
    {
        super("TextArea Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        this.setLayout(new BorderLayout());
        textArea.setLineWrap(true);
        this.add(textArea, BorderLayout.NORTH);
        this.add(sl, BorderLayout.SOUTH);
 
        // label ���̱�/ ���߱�
        sl.setPaintLabels(true);
        // track ���̱�(ū��)
        sl.setPaintTrack(true);
        // tick ���̱�(������)
        sl.setPaintTicks(true);
        // ū ���� ����
        sl.setMajorTickSpacing(20);
        // ���� ���� ����
        sl.setMinorTickSpacing(5);
 
        textArea.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
                super.keyTyped(e);
                if(textArea.getText().length() >= 100)
                {
                    textArea.setText(textArea.getText().substring(0, 99));
                }
                else{
                    sl.setValue(textArea.getText().length());
                }
            }
        });
 
        sl.addChangeListener(new ChangeListener() 
        {
            @Override
            public void stateChanged(ChangeEvent e) 
            {
                // ���ڼ����� ���� �þ�� ���ϵ��� �ϴ� �ڵ�
                if(textArea.getText().length() < sl.getValue())
                {
                    sl.setValue(textArea.getText().length());
                }
                else{
                    textArea.setText(textArea.getText().substring(0, sl.getValue()));
                }
            }
        });
 
        setSize(300, 300);
        setVisible(true);
 
    }
    public static void main(String[] args)
    {
        new chap11_06();
    }
}