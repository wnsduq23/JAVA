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
	}//매개 변수 없는 생성자
	
	Rectangle(int xx1, int yy1, int xx2, int yy2) 
	{
		this.set(xx1, yy1, xx2, yy2);
	}//좌표의 값을 설정하는 생성자
	
	public void set(int xx1, int yy1, int xx2, int yy2) 
	{
		this.x1=xx1; 
		this.y1=yy1;
		this.x2=xx2;
		this.y2=yy2;
		
		length= (xx1-xx2)>0 ? xx1-xx2 : -(xx1-xx2);
		width= (yy1-yy2)>0 ? yy1-yy2 : -(yy1-yy2);
		size = length*width;//여기서 없어도 되나?
	}
	
	public int square() 
	{
		int size = (x1-x2) * (y1-y2); // 면적 계산
		if (size <0)
			size = -size; // 면적이 음수인 경우 양수로 만들어 줌
		return size;
	}
	
	public void show() 
	{
		System.out.printf("x1좌표 : %d, y1좌표 : %d \n", x1, y1);
		System.out.printf("x2좌표 : %d, y2좌표 : %d \n", x2, y2);
		System.out.printf("길이 : %d, 높이 : %d, ", length, width);
		System.out.printf("넓이 : %d \n", size);
	}
	
	public boolean equals(Rectangle x) 
	{
		int width1 = (x.x1>x.x2?(x.x1-x.x2):x.x2-x.x1); // x의 가로 길이
		int width2 = (x1>x2?(x1-x2):(x2-x1)); // this의 가로 길이
		int height1 = (x.y1>x.y2?(x.y1-x.y2):(x.y2-x.y1)); // x의 세로 길이
		int height2 = (y1>y2?(y1-y2):(y2-y1)); // this의 세로 길이

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
				System.out.println("두 사각형의 가로와 세로가 같습니다.");
			else System.out.println(" 두 사각형은 가로와 세로가 다릅니다.");
		}

}
