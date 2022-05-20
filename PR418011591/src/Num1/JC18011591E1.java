package Num1;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;
import javax.swing.*;
 
public class JC18011591E1 extends JFrame
{
    private JPanel RadioP = new JPanel();
    private JPanel PngP = new JPanel();
    
    private Vector<ImageIcon> imageIconVector = new Vector<ImageIcon>();
    
    private JRadioButton left;
    private JRadioButton right;
    
    private JLabel iL;
    private int count = -1;
    private int now = 0;
    
    public JC18011591E1()
    {
        super("Image Gallery Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
 
        c.add(RadioP, BorderLayout.NORTH);
        c.add(PngP, BorderLayout.CENTER);
 
        ButtonGroup G = new ButtonGroup();
        left = new JRadioButton("left", true);
        right = new JRadioButton("right");
        G.add(left);
        G.add(right);
 
        left.addItemListener(new MIL());
        right.addItemListener(new MIL());
        
        RadioP.add(left);
        RadioP.add(right);
 
        File f = new File("C:\\Users\\김준엽\\eclipse-workspace\\PR418011591\\src\\images");
        File files[] = f.listFiles();
 
        for(int i=0; i<files.length; i++)
        {
            ImageIcon PNG = new ImageIcon(files[i].getPath());
            imageIconVector.add(PNG);
        }
 
        iL = new JLabel(imageIconVector.get(0));
        iL.setPreferredSize(new Dimension(400, 300));
        PngP.setLayout(new FlowLayout());
        PngP.add(iL);
        
        iL.addMouseListener(new MAL());
        setSize(420, 380);
        setVisible(true);
    }
 
    class MAL extends MouseAdapter
    {
    	public void mouseClicked(MouseEvent e) 
        {
            super.mouseClicked(e);
            now += count;
            
            if(now < 0)
            {
                now = imageIconVector.size()-1;
                iL.setIcon(imageIconVector.get(now));
            }
            else{
                iL.setIcon(imageIconVector.get(now%imageIconVector.size()));
            }
        }
    }
    
    class MIL implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                if(left.isSelected())
                {
                    count = -1;
                }
                else{
                    count = 1;
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        new JC18011591E1();
    }
}




// 이미지와 라디오버튼을 만들어서 컨텐트팬에 넣어줘야한다. 