package Num1;

import java.util.*;
class Circle
{
	public final double PI=3.14159;
	private int id;
	private int x,y;
	private double r;
	public Circle(int x, int y, double r)
	{
		this.x=x;
		this.y=y;
		this.r=r;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public double getR()
	{
		return r;
	}
	public int id()
	{
		return (int)(Math.random()*100+1);
	}
	public double size()
	{
		return PI*r*r; 
	}
	
	public boolean issize(double r2)
	{
		if(r==r2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
public class JC18011591E1 
{
	public static void main(String [] args)
	{
		Scanner sc= new Scanner(System.in);
		Circle c1= new Circle(11,11,9.0);
		Circle c2= new Circle(16,21,13.0);
		Circle c3= new Circle(21,21,9.0);
		System.out.println("ID:"+c1.id()+" ,중심점 좌표:("+c1.getX()+","+c1.getY()+")"+"반지름:"+c1.getR()+" ,면적:"+c1.size());
		System.out.println("ID:"+c2.id()+" ,중심점 좌표:("+c2.getX()+","+c2.getY()+")"+"반지름:"+c2.getR()+" ,면적:"+c2.size());
		System.out.println("ID:"+c3.id()+" ,중심점 좌표:("+c3.getX()+","+c3.getY()+")"+"반지름:"+c3.getR()+" ,면적:"+c3.size());
		if(c1.issize(c2.getR()))
		{
		System.out.println("==> "+"(원 "+c1.id()+")와"+" (원 "+c2.id()+")는 면적이 같습니다.");
		}
		else
		{
			System.out.println("==> "+"(원 "+c1.id()+")와"+" (원 "+c2.id()+")는 면적이 같지 않습니다.");
		}
		if(c1.issize(c3.getR()))
		{
		System.out.println("==> "+"(원 "+c1.id()+")와"+" (원 "+c3.id()+")는 면적이 같습니다.");
		}
		else
		{
			System.out.println("==> "+"(원 "+c1.id()+")와"+" (원 "+c3.id()+")는 면적이 같지 않습니다.");
		}
	}

}
