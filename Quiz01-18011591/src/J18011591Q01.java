import java.util.Scanner;
public class J18011591Q01 {
	public static void main(String[] args)
	{
		System.out.print("18011591 김준엽");
		char grade;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요(0~100):");
		int score = scanner.nextInt();
		if(score>=95)
			grade ='A';
		else if(score>=75)
			grade ='B';
		else if (score >=60)
			grade ='C';
		else if (score >=40)
			grade ='D';
		else
			grade='F';
		System.out.println("학점은 " + grade + "입니다.");
		
		scanner.close();
	}
	
}
