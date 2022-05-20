import java.util.*;


public class chap07_8 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> man = new HashMap<String,Integer>();
		System.out.println("**포인트 관리 프로그램입니다.**");
		while(true)
		{
			System.out.print("이름과 포인트 입력>>");
			
			String name = sc.next();
			if((name.equals("그만")))
					break;
			int pt=sc.nextInt();
			if(man.get(name)==null)
			{
				man.put(name,pt);
			}
			else
			{
				man.put(name, man.get(name)+pt);
			}
			Set<String> k = man.keySet(); 
			Iterator<String> it= k.iterator();
			while(it.hasNext())
			{
				String people = it.next();
				Integer sum = man.get(people);
				System.out.print("("+people+","+sum+")");
			}
			System.out.println();
		}
		sc.close();
	}

}
