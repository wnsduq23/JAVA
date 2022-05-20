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
		System.out.println("ID:"+c1.id()+" ,�߽��� ��ǥ:("+c1.getX()+","+c1.getY()+")"+"������:"+c1.getR()+" ,����:"+c1.size());
		System.out.println("ID:"+c2.id()+" ,�߽��� ��ǥ:("+c2.getX()+","+c2.getY()+")"+"������:"+c2.getR()+" ,����:"+c2.size());
		System.out.println("ID:"+c3.id()+" ,�߽��� ��ǥ:("+c3.getX()+","+c3.getY()+")"+"������:"+c3.getR()+" ,����:"+c3.size());
		if(c1.issize(c2.getR()))
		{
		System.out.println("==> "+"(�� "+c1.id()+")��"+" (�� "+c2.id()+")�� ������ �����ϴ�.");
		}
		else
		{
			System.out.println("==> "+"(�� "+c1.id()+")��"+" (�� "+c2.id()+")�� ������ ���� �ʽ��ϴ�.");
		}
		if(c1.issize(c3.getR()))
		{
		System.out.println("==> "+"(�� "+c1.id()+")��"+" (�� "+c3.id()+")�� ������ �����ϴ�.");
		}
		else
		{
			System.out.println("==> "+"(�� "+c1.id()+")��"+" (�� "+c3.id()+")�� ������ ���� �ʽ��ϴ�.");
		}
	}

}
