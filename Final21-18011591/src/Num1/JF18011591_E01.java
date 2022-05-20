package Num1;

import java.util.Iterator;
import java.util.Vector;

class Point 
{
	private int w, h;
	public Point(int w, int h) 
	{
		this.w = w; this.h = h;
	}
	public String toString() 
	{
		return "(" + w + "," + h + ")"; 
	}
	public int getXY() 
	{
		return w*h;
	}
}

public class JF18011591_E01 
{
	public static void main(String[] args) 
	{
		Vector<Point> v = new Vector<Point>(); // Point ��ü�� ��ҷ� �ٷ�� ���� ���� 
		
		// 3 ���� Point ��ü ���� 
		v.add(new Point(4, 5));
		v.add(new Point(8, 10));
		v.add(new Point(30, 15));

		v.remove(1); // �ε��� 1�� Point(-5, 20) ��ü ���� 
		
		Iterator<Point> it = v.iterator();//
		// ���Ϳ� �ִ� Point ��ü ��� �˻��Ͽ� ���
		while(it.hasNext())
		{
			Point n=it.next();
			System.out.println("�簢�� : "+n+", ����:"+(double)n.getXY());
		}
	}
}