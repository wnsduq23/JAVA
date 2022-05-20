package Num1;
import java.util.*;

class Location
{
	private String latitude;//위도
	private String longitude;//경도
	private String name;
	
	Location(String name, String latitude, String longitude)
	{
		this.name=name;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public String toString()
	{
		return name+" "+latitude+" "+longitude;
	}
}
public class JC18011591E1 
{
	public static void main(String [] args)
	{
		Location[] loc = new Location[4];
		Scanner sc = new Scanner(System.in);
		HashMap<String,Location> h = new HashMap<String, Location>();
		System.out.println("도시, 경도, 위도를 입력하세요.");
		for(int i=0;i<loc.length;i++)
		{
			System.out.println(">>");
			String input=sc.nextLine();
			String word[]=input.split(", ");
			String name = word[0];
			String latitude = word[1];
			String longitude = word[2];
			loc[i]=new Location(name, latitude, longitude);
			h.put(name, loc[i]);
		}
		System.out.println("------------------------------");
		for(int i=0;i<loc.length;i++)
		{
			System.out.println(loc[i]);
		}
		System.out.println("------------------------------");
		
		while(true)
		{
			System.out.print("도시 이름>>");
			String name = sc.next();
			if(name.equals("그만"))
				break;
			Location a=h.get(name);
			if(a==null)
				System.out.println(name+"는 없습니다.");
			else 
				System.out.println(a);
		}
		sc.close();
	}
	
}
