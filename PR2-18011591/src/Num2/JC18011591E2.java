package Num2;
import java.util.*;

abstract class Shape
{
	public abstract void show();
}

class Line extends Shape
{
	public void show()
	{
		System.out.println("Line");
	}
}
class Rect extends Shape {
	public void show() {
		System.out.println("Rect");
	}
}
class Circle extends Shape {
	public void show() {
		System.out.println("Circle");
	}
}

public class JC18011591E2 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		var v = new Vector<Shape>();
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
		for(;;)
		{
			System.out.print("����(1), ����(2), ��� ����(3), ����(4) >> ");
			int sel=sc.nextInt();
			switch(sel)
			{
			case 1:
				System.out.print("Line(1), Rect(2), Circle(3) >> ");
				int ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					Shape shape = new Line();//
					v.add(shape);
					break;
				case 2:
					shape = new Rect();
					v.add(shape);
					break;
				case 3:
					shape = new Circle();
					v.add(shape);
					break;
				}
				break;
			case 2:
				System.out.print("������ ������ ��ġ >> " );
				int pos = sc.nextInt();
				if(v.size()<=pos || v.size()==0)
					System.out.println("������ �� �����ϴ�.");
				else 
					v.remove(pos);
				break;
			case 3:
				for(int j=0;j<v.size();j++)
					v.get(j).show();
				break;
			case 4:
				System.out.println("beauty�� �����մϴ�.");
				sc.close();//
				return;
			}
		}
	}

}
