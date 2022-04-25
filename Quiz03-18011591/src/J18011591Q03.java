import java.util.Scanner;
import java.util.InputMismatchException;

class Rectangle
{
	private int x1,y1,x2,y2;
	private int length,width;
	private int size;
	
	Rectangle() 
	{
		x1 = x2 = y1 = y2 = 0;
	}//�Ű� ���� ���� ������
	
	Rectangle(int xx1, int yy1, int xx2, int yy2) 
	{
		this.set(xx1, yy1, xx2, yy2);
	}//��ǥ�� ���� �����ϴ� ������
	
	public void set(int xx1, int yy1, int xx2, int yy2) 
	{
		this.x1=xx1; 
		this.y1=yy1;
		this.x2=xx2;
		this.y2=yy2;
		
		length= (xx1-xx2)>0 ? xx1-xx2 : -(xx1-xx2);
		width= (yy1-yy2)>0 ? yy1-yy2 : -(yy1-yy2);
		size = length*width;//���⼭ ��� �ǳ�?
	}
	
	public int square() 
	{
		int size = (x1-x2) * (y1-y2); // ���� ���
		if (size <0)
			size = -size; // ������ ������ ��� ����� ����� ��
		return size;
	}
	
	public void show() 
	{
		System.out.printf("x1��ǥ : %d, y1��ǥ : %d \n", x1, y1);
		System.out.printf("x2��ǥ : %d, y2��ǥ : %d \n", x2, y2);
		System.out.printf("���� : %d, ���� : %d, ", length, width);
		System.out.printf("���� : %d \n", size);
	}
	
	public boolean equals(Rectangle x) 
	{
		int width1 = (x.x1>x.x2?(x.x1-x.x2):x.x2-x.x1); // x�� ���� ����
		int width2 = (x1>x2?(x1-x2):(x2-x1)); // this�� ���� ����
		int height1 = (x.y1>x.y2?(x.y1-x.y2):(x.y2-x.y1)); // x�� ���� ����
		int height2 = (y1>y2?(y1-y2):(y2-y1)); // this�� ���� ����

		if(height1 == height2 && width1 == width2)
			return true;
		else
			return false;
	}
}

public class J18011591Q03 {
	
		public static void main(String[] args) 
		{
			Rectangle r = new Rectangle();
			Rectangle s = new Rectangle(1,1,2,3);
	    
			r.show();
			s.show();
			System.out.println(s.square());

			r.set(-2,2,-1,4); 
			r.show();

			System.out.println(r.square());

			if (r.equals(s))
				System.out.println("�� �簢���� ���ο� ���ΰ� �����ϴ�.");
			else System.out.println(" �� �簢���� ���ο� ���ΰ� �ٸ��ϴ�.");
		}

}
