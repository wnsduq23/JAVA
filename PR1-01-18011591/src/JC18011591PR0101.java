
public class JC18011591PR0101 {
	public static void main ( String[] args)
	{
		int num[][]=new int[4][4];
		int cnt=0;
		int i,j;
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				num[i][j]=0;
			}
		}
		while(cnt<10)
		{
			i=(int)Math.round(Math.random()*3);
			j=(int)Math.round(Math.random()*3);
			
			if(num[i][j]==0)
			{
				num[i][j]=(int)Math.round(Math.random()*9+1);
				cnt++;
			}
		}
		
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				System.out.printf("%d  ", num[i][j]);
			}
			System.out.println();
		}
	}

}
