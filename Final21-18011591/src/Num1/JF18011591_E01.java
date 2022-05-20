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
		Vector<Point> v = new Vector<Point>(); // Point 객체를 요소로 다루는 벡터 생성 
		
		// 3 개의 Point 객체 삽입 
		v.add(new Point(4, 5));
		v.add(new Point(8, 10));
		v.add(new Point(30, 15));

		v.remove(1); // 인덱스 1의 Point(-5, 20) 객체 삭제 
		
		Iterator<Point> it = v.iterator();//
		// 벡터에 있는 Point 객체 모두 검색하여 출력
		while(it.hasNext())
		{
			Point n=it.next();
			System.out.println("사각형 : "+n+", 면적:"+(double)n.getXY());
		}
	}
}