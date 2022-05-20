import java.util.*;

public class IteratorEx 
{
	public static void main(String[] args) 
	{
		int sum = 0;
		// ���� ���� �ٷ�� ���׸� ���� ����
		Vector<Integer> v = new Vector<Integer>(); 
		v.add(5); // 5 ����
		v.add(4); // 4 ����
		v.add(-1); // -1 ����
		v.add(2, 100); // 4�� -1 ���̿� ���� 100 ����
	
		// Iterator�� �̿��� ��� ���� ����ϱ� & ���ϱ�
		Iterator<Integer> it = v.iterator();  // Iterator ��ü ���
		while(it.hasNext()) 
		{
			int n = it.next();
			sum+=n;
			System.out.println(n);
		}
		

		System.out.println("���Ϳ� �ִ� ���� �� : " + sum);
	}
}