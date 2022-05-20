import java.io.*;
import java.util.*;

public class FileWriterEx 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); 
		FileWriter fout = null; //입력받은 키값을 파일에 작성해주는 스트림
		int c;
		try 
		{
			fout = new FileWriter("c:\\Temp\\test.txt"); // 파일과 연결된 출력 문자 스트림 생성
			while(true) 
			{
				String line = scanner.nextLine();
				if(line.length() == 0) // 한 줄에 <Enter>키만 입력한 경우
					break;
				fout.write(line, 0, line.length()); // 인데스 0부터 .length개의 문자를 line 문자열에서 출력
				fout.write("\r\n", 0, 2); // \r\n을 파일에 기록 \r\n은 줄바꿈!
			}
			fout.close();//스트림은 호출하면 반드시 닫아줘야함
		}
		catch (IOException e) 
		{
			System.out.println("입출력 오류");
		}
		scanner.close();
	}
}