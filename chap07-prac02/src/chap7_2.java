import java.util.*;

public class chap7_2 
{
	public static void main(String [] args)
	{
		ArrayList<Character> A= new ArrayList<Character>();
		Scanner sc = new Scanner(System.in);
		int sum =0;
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >> ");
		for(int i=0;i<6;i++)
		{
			char c= sc.next().charAt(0);//입력받은 문자열의 '0'번째 문자를 char타입으로 변환하는 명령어 빈칸은 무시한다.
			A.add(c);
		}
		for(int i=0;i<A.size();i++)
		{
			char c = A.get(i);
			switch(c)//switch(식)
			{
			case 'A': // case 값 : 
				sum+=4;
				break;//주의! case에서 break하면 다음 case로 넘어가는 거임. switch는 종료가 아님!
			case 'B':
				sum+=3;
				break;
			case 'C':
				sum+=2;
				break;
			case 'D':
				sum+=1;
				break;
			case 'F':
				sum+=0;
				break;
			}
		}
		double avg =(double) sum/A.size();
		System.out.print(avg);
		sc.close();
	}

}
