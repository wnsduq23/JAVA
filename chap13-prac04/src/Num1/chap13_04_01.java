package Num1;
import java.awt.*;
import javax.swing.*;
 
class MyRunnable implements Runnable
{
    private Container c;
    
    public MyRunnable(Container c)
    {
        this.c = c;
    }
    @Override
    public void run() 
    {
        while(true)
        {
            try
            {
                c.setLocation(c.getX()-5, c.getY()-5);
                c.setLocation(c.getX(), c.getY());
                c.setLocation(c.getX()+5, c.getY()+5);
                c.setLocation(c.getX(), c.getY());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class chap13_04_01 extends JFrame
{
    private MyRunnable runnable;
    
    public chap13_04_01()
    {
        super("진동하는 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100, 100);
        setSize(400, 400);
        setVisible(true);
        runnable = new MyRunnable(this);
        Thread th = new Thread(runnable);
        th.start();
    }
    public static void main(String[] args)
    {
        new chap13_04_01();
    }
}
