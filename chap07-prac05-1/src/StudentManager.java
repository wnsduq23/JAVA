import java.util.*;

class Student 
{
	private String name;
	private String department;
	private String id;
	private double grade;
	
	public Student(String name, String department, String id, double grade) 
	{
		this.name = name;
		this.department = department;
		this.id = id;
		this.grade = grade;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}
	public void setDepartment(String department) 
	{
		this.department = department;
	}
	public String getDepartment() 
	{
		return department;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getId() 
	{
		return id;
	}
	public void setGrade(double grade) 
	{
		this.grade = grade;
	}
	public double getGrade() 
	{
		return grade;
	}
}

public class StudentManager 
{
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Student> dept = new ArrayList<Student>();
	
	private void read() 
	{
		System.out.println("�л� �̸�,�а�,�й�,������� �Է��ϼ���.");
		for (int i=0; i<4; i++) 
		{
			System.out.print(">> ");
			String text = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(text, ",");//","�� �������� ���� 
			String name = st.nextToken().trim();
			String department = st.nextToken().trim();
			String id = st.nextToken().trim();
			double grade = Double.parseDouble(st.nextToken().trim());//Double.parseDouble : String Ÿ���� ���ڿ��� double �� �ٲ��ִ� �޼ҵ�
			
			Student student = new Student(name, department, id, grade);//Student Ŭ������ ��ü ����
			dept.add(student); // ArrayList�� ����
		}			
	}
	
	private void printAll() 
	{ // �Ϻη� Iterator�� �ۼ��� ������
		Iterator<Student> it = dept.iterator();//�÷��ǿ��� ��Ҹ� ���� �˻��� �� ���
		while (it.hasNext()) //hasNext: �湮�� ��Ұ� ���������� true ����
		{
			Student student = it.next();//���� ��� ����
			System.out.println("---------------------------");
			System.out.println("�̸�:" + student.getName());
			System.out.println("�а�:" + student.getDepartment());
			System.out.println("�й�:" + student.getId());
			System.out.println("�������:" + student.getGrade());
			System.out.println("---------------------------");
		}		
	}

	private void processQuery() 
	{
		while(true) 
		{
			System.out.print("�л� �̸� >> ");
			String name = scanner.nextLine(); // �л� �̸� �Է�
			if(name.equals("�׸�"))
				return; // ����
			
			for(int i=0; i<dept.size(); i++) { // dept�� �ִ� ��� �л� �˻�
				Student student = dept.get(i); // i��° �л� ��ü
				if(student.getName().equals(name)) 
				{ //  �̸��� ���� Student ã��
					System.out.print(student.getName() + ", ");
					System.out.print(student.getDepartment() + ", ");
					System.out.print(student.getId() + ", ");
					System.out.println(student.getGrade());
					break; // for ���� ���
				}
			} // end of while
		}
	}
	
	public void run() 
	{
		read();
		printAll();
		processQuery();
	}
	
	public static void main (String[] args) 
	{
		StudentManager man = new StudentManager();
		man.run();
	}
}
