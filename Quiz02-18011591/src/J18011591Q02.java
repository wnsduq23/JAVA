
public class J18011591Q02 {
	public static void main ( String[] args)
	{
		int intArray[][]=new int[4][];
		int sum=0;
		for(int i=0;i<4;i++)
		{
			intArray[i]=new int[5-i];
		}
		for(int i=0;i<4;i++)
		{
			for(int j=4-i;0<=j;j--)
			{
				intArray[i][j]=(int)(Math.random()*100+1);
				sum+=intArray[i][j];
				System.out.print(intArray[i][j]+" ");
			}
			System.out.println("=>Sum of this row ="+ sum);
			sum=0;
		}
	}

}
