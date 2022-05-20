package Num2;

import java.util.*;

class Money
{
	private String name;
	private int exc;
	
	public Money(String name, int exc)
	{
		this.name=name;
		this.exc=exc;
	}
	public int getE()
	{
		return exc;
	}
	public String getN()
	{
		return name;
	}
	public int jong()
	{
		int a,b,c,d,e,f;
		while(true)
		{
			if(exc/50000>=1)
			{
				System.out.println("오만원권: "+exc/50000+"매");
				exc=exc- exc*(exc/50000);
				a=exc/50000;
				}
			if(exc/10000>=1)
			{
				System.out.println("만원권: "+exc/10000+"매");
				exc=exc- exc*(exc/10000);
				b=exc/10000;
			}
			if(exc/5000>=1)
			{
				System.out.println("오천원권: "+exc/5000+"매");
				exc=exc- exc*(exc/5000);
				c=exc/5000;
			}
			if(exc/100>=1)
			{
				System.out.println("백원짜리: "+exc/100+"매");
				exc=exc- exc*(exc/100);
				d=exc/100;
			}
			if(exc/10>=1)
			{
				System.out.println("십원짜리: "+exc/10+"매");
				exc=exc- exc*(exc/10);
				e=exc/10;
			}
			if(exc/1>=1)
			{
				System.out.println("일원짜리: "+exc/1+"매");
				exc=exc- exc*(exc/1);
				f=exc/1;
			}
			if(exc==0)
				break;
		}
	}
	
}
public class JC18011591E2 
{
	public static void main(String [] args)
	{
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		Money m1= new Money("장백산",158377);
		Money m2= new Money("장흑산",69637);
		Money m3= new Money("임꺽정",10637);
		System.out.println(m1.getN());
		m1.jong();
		System.out.println(m2.getN());
		m2.jong();
		System.out.println(m3.getN());
		m3.jong();
	}
	

}
