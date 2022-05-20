import java.awt.*;
import java.util.Vector;
import javax.swing.*;
 
public class chap13_08 extends JFrame
{
    private MyPanel panel;
    public chap13_08(){
        super("눈 내리는 샤갈의 마을");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        panel = new MyPanel(this);
        setContentPane(panel);
        setVisible(true);
        //setResizable(false);
    }
    class MyPanel extends JPanel
    {
        private ImageIcon icon = new ImageIcon("images/back.jpg");
        private Image img = icon.getImage();
        private Vector<Point> pointVector = new Vector<Point>();
        private MyRunnable runnable;
        public MyPanel(Component c)
        {
            runnable = new MyRunnable();
            Thread th = new Thread(runnable);
            th.start();
        }
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);    // 오버라이딩 되고 나서 this.getWidth, this.getHeight 동작.
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            g.setColor(Color.WHITE);
            makeSnow();
            for(int i=0; i<pointVector.size(); i++)
            {
                Point p = pointVector.elementAt(i);
                g.fillOval(p.x, p.y, 10, 10);
            }
        }
        public void makeSnow(){
 
            if(pointVector.size() == 0)
            {
                for(int i=pointVector.size(); i<(this.getWidth()+this.getHeight())/10; i++){
                    int x = (int)(Math.random()*this.getWidth());
                    int y = (int)(Math.random()*this.getHeight());
                    pointVector.add(new Point(x, y));
                }
            }
            else
            {
                for(int i=pointVector.size(); i<(this.getWidth()+this.getHeight())/10; i++){
                    int x = (int)(Math.random()*this.getWidth());
                    int y = (int)(Math.random()*this.getHeight()/3);
                    pointVector.add(new Point(x, y));
                }
            }
        }
        class MyRunnable implements Runnable
        {
            @Override
            public void run() 
            {
                while(true){
                    try{
                        Thread.sleep(20);
                        for(int i=0; i<pointVector.size(); i++)
                        {
                            Point p = pointVector.elementAt(i);
                            if(p.y+10 > panel.getHeight())
                            {
                                pointVector.remove(i);
                            }
                            else{
                                p.setLocation(p.x, p.y+5);
                                pointVector.set(i, p);
                            }
                        }
                        repaint();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        new chap13_08();
    }
}
