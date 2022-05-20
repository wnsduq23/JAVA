import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class chap11_04 extends JFrame 
{
    public chap11_04() 
    {
        setTitle("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
 
        setSize(300,300);
        setVisible(true);
    }
 
    class MyPanel extends JPanel 
    {
        private int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; // ȯ���� ���� ����
        private String [] text = {"������", "����", "õ��", "500��", "100��", "50��", "10��", "1��"}; // ȯ���� ���� �̸�. ���̺�� ��µ�
        private JTextField source; // ����ڷκ��� �ݾ��� �Էµ� �ؽ�Ʈ �ʵ�
        private JTextField [] tf = new JTextField [8]; // ȯ��� ���� ������ ��µ� �ؽ�Ʈ�ʵ�
        private JCheckBox[] checkBoxes = new JCheckBox[7];
        private boolean checking[] = {false, false, false, false, false, false, false, true};
 
        public MyPanel() 
        {
            setBackground(Color.PINK);
            setLayout(null); // �г��� ��ġ������ ����
 
            // �ݾ� ���̺�
            JLabel la = new JLabel("�ݾ�");
            la.setHorizontalAlignment(JLabel.RIGHT);
            la.setSize(50, 20);
            la.setLocation(20, 20);
            add(la);
 
            // �ݾ��� �Է��ϴ� JTextField
            source = new JTextField(30);
            source.setSize(100, 20);
            source.setLocation(100, 20);
            add(source);
 
            // ��� ��ư
            JButton calcBtn = new JButton("���");
            calcBtn.setSize(70, 20);
            calcBtn.setLocation(210, 20);
            add(calcBtn);
 
            // ���� �׼��� ���� ����
            for(int i=0; i<text.length; i++) 
            {
                la = new JLabel(text[i]);
                la.setHorizontalAlignment(JLabel.RIGHT);
                la.setSize(50, 20);
                la.setLocation(50, 50+i*20);
                add(la);
                tf[i] = new JTextField(30);
                tf[i].setHorizontalAlignment(JTextField.CENTER);
                tf[i].setSize(70, 20);
                tf[i].setLocation(120, 50+i*20);
                add(tf[i]);
            }
            
            MyItemListener myItemListener = new MyItemListener();
            for(int i=0; i<checkBoxes.length; i++){
                checkBoxes[i] = new JCheckBox();
                checkBoxes[i].setBackground(Color.PINK);
                checkBoxes[i].setSize(30, 15);
                checkBoxes[i].setLocation(200, 50+i*20);
                add(checkBoxes[i]);
                checkBoxes[i].addItemListener(myItemListener);
            }
 
            // ��� ��ư�� Action ������
            calcBtn.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    String str = source.getText(); // �Էµ� �ݾ� ���ڿ�
                    if(str.length() == 0) return; // �Էµ� �ݾ��� ����
 
                    for(int i=0; i<unit.length; i++)
                    {
                        tf[i].setText("");
                    }
 
                    int money = Integer.parseInt(str); // �Էµ� �ݾ��� ������ ��ȯ
                    int res;
                    for(int i=0; i<unit.length; i++) 
                    {
                        if(checking[i] == true){
                            res = money/unit[i]; // unit[i]�� ���� ���
                            tf[i].setText(Integer.toString(res));
                            if(res > 0)
                                money = money%unit[i]; // money ����
                        }
                    }
                }
            });
        }
        class MyItemListener implements ItemListener
        {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    for(int i=0; i<checkBoxes.length; i++)
                    {
                        if(e.getItem() == checkBoxes[i])
                        {
                            checking[i] = true;
                        }
                    }
                }
                else{
                    for(int i=0; i<checkBoxes.length; i++)
                    {
                        if(e.getItem() == checkBoxes[i])
                        {
                            checking[i] = false;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        new chap11_04();
    }
}