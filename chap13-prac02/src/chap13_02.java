import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
 
class MyPanel extends JPanel
{
    private int x = 0;
    private int y = 0;
    public void paintComponent(Graphics g)//도형을 그려주는 메소드
    {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.drawOval(this.x, this.y, 50, 50);
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
}
class MyRunnable implements Runnable
{
    private MyPanel panel;
    public MyRunnable(MyPanel panel)// 생성자 
    {
        this.panel = panel;
    }
    @Override
    public void run() // runnable에 기본으로 내재되어있는 메소드
    {
        while(true)
        {
            try
            {
                int x = (int)(Math.random()*panel.getWidth());
                int y = (int)(Math.random()*panel.getHeight());
                panel.setX(x);
                panel.setY(y);
                panel.repaint();
                Thread.sleep(500);
            }catch (Exception e)
            {
                return;
            }
        }
    }
}
public class chap13_02 extends JFrame
{
    private MyPanel panel = new MyPanel();
    private MyRunnable runnable;
    public chap13_02(){
        super("원을 0.5초 간격으로 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        
        runnable = new MyRunnable(panel);
        Thread th = new Thread(runnable);
        
        setSize(400, 400);
        setVisible(true);
        
        panel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                super.mouseClicked(e);
                th.start();
            }
        });
    }
    public static void main(String[] args)
    {
        new chap13_02();
    }
}
