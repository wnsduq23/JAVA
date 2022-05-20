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
		String tmp = "Triangle은 "+"밑변이 "+getX()+"이고 높이가 "+getH()+"인 "+"삼각형이다.";
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
		this.color="분홍색";
	}
	public String toString()
	{
		String tmp = "ColorTriangle은 "+"밑변이 "+getX()+"이고 높이가 "+getH()+"인 "+color+" 삼각형이다.";
		return tmp;
	}
}
public class JC18011591E3 {
	public static void main(String [] args)
	{
		Triangle t=new Triangle(15,25);
		System.out.println(t.toString());
		
		ColorTriangle t2= new ColorTriangle(30,60);
		t2.setColor("분홍색");
		System.out.println(t2.toString());
	}

}
