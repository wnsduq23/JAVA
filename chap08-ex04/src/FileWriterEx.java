import java.io.*;
import java.util.*;

public class FileWriterEx 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); 
		FileWriter fout = null; //�Է¹��� Ű���� ���Ͽ� �ۼ����ִ� ��Ʈ��
		int c;
		try 
		{
			fout = new FileWriter("c:\\Temp\\test.txt"); // ���ϰ� ����� ��� ���� ��Ʈ�� ����
			while(true) 
			{
				String line = scanner.nextLine();
				if(line.length() == 0) // �� �ٿ� <Enter>Ű�� �Է��� ���
					break;
				fout.write(line, 0, line.length()); // �ε��� 0���� .length���� ���ڸ� line ���ڿ����� ���
				fout.write("\r\n", 0, 2); // \r\n�� ���Ͽ� ��� \r\n�� �ٹٲ�!
			}
			fout.close();//��Ʈ���� ȣ���ϸ� �ݵ�� �ݾ������
		}
		catch (IOException e) 
		{
			System.out.println("����� ����");
		}
		scanner.close();
	}
}