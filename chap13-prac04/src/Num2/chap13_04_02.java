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
    
    private JLabel label = new JLabel("진동 레이블");
    
    public chap13_04_02()
    {
        setTitle("진동하는 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(null);
        setSize(400, 400);
        setVisible(true);
        
        label.setLocation(this.getWidth()/2-60, this.getWidth()/2-50);//초기 로케이션 
        label.setSize(130, 50);
        label.setFont(new Font("고딕", Font.ITALIC, 20));
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
//this. 없어도 다 정상 작동함 ㄷ.ㄷ 컨텐트팬 설정 안해줘도 알아서  JFrame이 만드나 봄 