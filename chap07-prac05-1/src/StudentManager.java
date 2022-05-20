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
		System.out.println("학생 이름,학과,학번,학점평균 입력하세요.");
		for (int i=0; i<4; i++) 
		{
			System.out.print(">> ");
			String text = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(text, ",");//","을 기준으로 나눔 
			String name = st.nextToken().trim();
			String department = st.nextToken().trim();
			String id = st.nextToken().trim();
			double grade = Double.parseDouble(st.nextToken().trim());//Double.parseDouble : String 타입의 문자열을 double 로 바꿔주는 메소드
			
			Student student = new Student(name, department, id, grade);//Student 클래스의 객체 생성
			dept.add(student); // ArrayList에 저장
		}			
	}
	
	private void printAll() 
	{ // 일부러 Iterator로 작성해 보았음
		Iterator<Student> it = dept.iterator();//컬렉션에서 요소를 순차 검색할 때 사용
		while (it.hasNext()) //hasNext: 방문할 요소가 남아있으면 true 리턴
		{
			Student student = it.next();//다음 요소 리턴
			System.out.println("---------------------------");
			System.out.println("이름:" + student.getName());
			System.out.println("학과:" + student.getDepartment());
			System.out.println("학번:" + student.getId());
			System.out.println("학점평균:" + student.getGrade());
			System.out.println("---------------------------");
		}		
	}

	private void processQuery() 
	{
		while(true) 
		{
			System.out.print("학생 이름 >> ");
			String name = scanner.nextLine(); // 학생 이름 입력
			if(name.equals("그만"))
				return; // 종료
			
			for(int i=0; i<dept.size(); i++) { // dept에 있는 모든 학생 검색
				Student student = dept.get(i); // i번째 학생 객체
				if(student.getName().equals(name)) 
				{ //  이름이 같은 Student 찾음
					System.out.print(student.getName() + ", ");
					System.out.print(student.getDepartment() + ", ");
					System.out.print(student.getId() + ", ");
					System.out.println(student.getGrade());
					break; // for 문을 벗어남
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
