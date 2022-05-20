import java.util.*;

public class HashMapNation 
{
	public static void main(String[] args) 
	{
		HashMap<String, Integer> nations = new HashMap<String, Integer>();//�ؽø��� Ű���� �������� �տ�, value���� �������� �ڿ� �����Ѵ�.
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("���� �̸��� �α��� �Է��ϼ���.(��: Korea 5000)");
		
		while(true) 
		{ 
			System.out.print("���� �̸�, �α� >> ");		
			
			String nation = scanner.next();
			
			if(nation.equals("�׸�"))//�Է��� ���� "�׸�"�� �����ϸ�
				break; 
			int population = scanner.nextInt();
			
			nations.put(nation, population); // �ؽøʿ� �����̸��� �μ� ����(put)
		}
		
		while(true) 
		{
			System.out.print("�α� �˻� >> ");
			String nation = scanner.next();
			if(nation.equals("�׸�"))
				break;
			Integer n = nations.get(nation);//get�޼ҵ�� Ű���� ������ value(��)�� ���´�. int�� �ƴϰ� Integer�ӿ� ���� ! 
			if(n == null)//value���� ����Ʈ�� ������ null�� ���´�.
				System.out.println(nation + " ����� �����ϴ�.");
			else 
				System.out.println(nation + "�� �α��� " + n); 
		}
		
		scanner.close();
	}

}
