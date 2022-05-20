package Num1;

class PrintShop
{
	private char x;
	private int y;
	int p;
	
	PrintShop()
	{
		
	}
	PrintShop(char x)
	{
		this.x=x;
	}
	PrintShop(char x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void print()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("#");
			}
			System.out.println();
		}
	}
	public void print(int num)
	{
		for(p=0;p<num;p++)
		{
			if(p%2==0)
			{
				for(int i=0;i<5;i++)
				{
					for(int j=0;j<=i;j++)
					{
						System.out.print(x);
						}
					System.out.println();
				}
			}
			if(p%2!=0)
			{
				for(int i=4;i>=0;i--)
				{
					for(int j=0;j<=i;j++)
					{
						System.out.print(x);
					}
					System.out.println();
				}
			}
		}
	}

	public void printReverse(int num)
	{
		for(int p=0;p<num;p++)
		{
			if(p%2!=0)
			{
				for(int i=0;i<y;i++)
				{
					for(int j=0;j<=i;j++)
					{
						System.out.print(x);
						}
					System.out.println();
					}
			}
			if(p%2==0)
			{
				for(int i=y-1;i>=0;i--)
				{
					for(int j=0;j<=i;j++)
					{
						System.out.print(x);
					}
					System.out.println();
				}
			}
		}
	}

}
public class JT18011591_E1 
{
	public static void main ( String[] args)
	{
		PrintShop ps1 = new PrintShop();
		PrintShop ps2 = new PrintShop('@');
		PrintShop ps3 = new PrintShop('$',10);
		
		ps1.print();
		ps2.print(3);
		ps3.printReverse(2);
	}

}
