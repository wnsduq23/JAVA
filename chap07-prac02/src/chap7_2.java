import java.util.*;

public class chap7_2 
{
	public static void main(String [] args)
	{
		ArrayList<Character> A= new ArrayList<Character>();
		Scanner sc = new Scanner(System.in);
		int sum =0;
		System.out.print("6���� ������ �� ĭ���� �и� �Է�(A/B/C/D/F) >> ");
		for(int i=0;i<6;i++)
		{
			char c= sc.next().charAt(0);//�Է¹��� ���ڿ��� '0'��° ���ڸ� charŸ������ ��ȯ�ϴ� ��ɾ� ��ĭ�� �����Ѵ�.
			A.add(c);
		}
		for(int i=0;i<A.size();i++)
		{
			char c = A.get(i);
			switch(c)//switch(��)
			{
			case 'A': // case �� : 
				sum+=4;
				break;//����! case���� break�ϸ� ���� case�� �Ѿ�� ����. switch�� ���ᰡ �ƴ�!
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
