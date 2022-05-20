package Num3;

class Triangle
{
	private int x;
	private int h;
	
	public Triangle(int x, int h)
	{
		this.x=x;
		this.h=h;
	}
	public int getX()
	{
		return x;
	}
	public int getH()
	{
		return h;
	}
	public String toString()
	{
		String tmp = "Triangle�� "+"�غ��� "+getX()+"�̰� ���̰� "+getH()+"�� "+"�ﰢ���̴�.";
		return tmp;
	}
}
class ColorTriangle extends Triangle
{
	String color;
	public ColorTriangle()
	{
		super(0,0);
	}
	public void setColor ( String color)
	{
		this.color=color;
	}
	public ColorTriangle (int x,int h)
	{
		super(x,h);
		this.color="��ȫ��";
	}
	public String toString()
	{
		String tmp = "ColorTriangle�� "+"�غ��� "+getX()+"�̰� ���̰� "+getH()+"�� "+color+" �ﰢ���̴�.";
		return tmp;
	}
}
public class JC18011591E3 {
	public static void main(String [] args)
	{
		Triangle t=new Triangle(15,25);
		System.out.println(t.toString());
		
		ColorTriangle t2= new ColorTriangle(30,60);
		t2.setColor("��ȫ��");
		System.out.println(t2.toString());
	}

}
