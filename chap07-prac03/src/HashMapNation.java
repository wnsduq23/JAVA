import java.util.*;

public class HashMapNation 
{
	public static void main(String[] args) 
	{
		HashMap<String, Integer> nations = new HashMap<String, Integer>();//해시맵의 키값의 문자형을 앞에, value값의 문자형을 뒤에 서술한다.
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
		
		while(true) 
		{ 
			System.out.print("나라 이름, 인구 >> ");		
			
			String nation = scanner.next();
			
			if(nation.equals("그만"))//입력의 값이 "그만"과 동일하면
				break; 
			int population = scanner.nextInt();
			
			nations.put(nation, population); // 해시맵에 나라이름과 인수 저장(put)
		}
		
		while(true) 
		{
			System.out.print("인구 검색 >> ");
			String nation = scanner.next();
			if(nation.equals("그만"))
				break;
			Integer n = nations.get(nation);//get메소드는 키값을 넣으면 value(값)이 나온다. int가 아니고 Integer임에 주의 ! 
			if(n == null)//value값은 리스트에 없으면 null로 나온다.
				System.out.println(nation + " 나라는 없습니다.");
			else 
				System.out.println(nation + "의 인구는 " + n); 
		}
		
		scanner.close();
	}

}
