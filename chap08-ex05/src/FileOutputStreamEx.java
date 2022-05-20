import java.io.*;

public class FileOutputStreamEx 
{
	public static void main(String[] args) 
	{
		byte b[] = {7,51,3,4,-1,24};
		
		try 
		{ 
			FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");//파일로부터 바이너리 데이터를 읽거나 저장
			for(int i=0; i<b.length; i++)
				fout.write(b[i]); // 배열 b의 바이너리를 그대로 기록
			fout.close();
		} 
		catch(IOException e) 
		{
			System.out.println("c:\\Temp\\test.out에 저장할 수 없었습니다. 경로명을  확인해 주세요");
			return;
		}
		System.out.println("c:\\Temp\\test.out을 저장하였습니다.");
	}
}