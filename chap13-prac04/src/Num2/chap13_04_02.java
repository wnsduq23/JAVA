package Num2;
import java.awt.*;
import javax.swing.*;
 
class MyRunnable implements Runnable
{
    private JLabel label;
    public MyRunnable(JLabel label)
    {
        this.label = label;
    }
    @Override
    public void run() 
    {
        while(true)
        {
            try
            {
                label.setLocation(label.getX()-5, label.getY()-5);
                label.setLocation(label.getX(), label.getY());
                label.setLocation(label.getX()+5, label.getY()+5);
                label.setLocation(label.getX(), label.getY());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class chap13_04_02 extends JFrame
{
    private MyRunnable runnable;
    
    private JLabel label = new JLabel("���� ���̺�");
    
    public chap13_04_02()
    {
        setTitle("�����ϴ� ������ �����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(null);
        setSize(400, 400);
        setVisible(true);
        
        label.setLocation(this.getWidth()/2-60, this.getWidth()/2-50);//�ʱ� �����̼� 
        label.setSize(130, 50);
        label.setFont(new Font("���", Font.ITALIC, 20));
        this.add(label);
        
        runnable = new MyRunnable(label);
        Thread th = new Thread(runnable);
        th.start();
    }
    
    public static void main(String[] args)
    {
        new chap13_04_02();
    }
}
//this. ��� �� ���� �۵��� ��.�� ����Ʈ�� ���� �����൵ �˾Ƽ�  JFrame�� ���峪 �� 