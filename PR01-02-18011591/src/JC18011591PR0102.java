import java.util.Scanner;

class PhoneBook {
   private String name;
   private String tel;
   PhoneBook(String name, String tel) 
   {
      this.name = name;
      this.tel = tel;
   }
   public String getName() 
   {
      return name;
   }
   public String getTel() 
   {
      return tel;
   }
}

public class JC18011591PR0102  
{
   
   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);
      int flag=0;
      PhoneBook phone[];
      int i;
      System.out.print("�ο��� >> ");
      int num = scanner.nextInt();
      phone = new PhoneBook[num];
      for(i=0; i<num; i++) {
         System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȣ�� �� ĭ���� �Է�)>>");
         String name = scanner.next();
         String tel = scanner.next();
         phone[i] = new PhoneBook(name, tel);
      }
      System.out.println("����Ǿ����ϴ�...");
      while(true) {
    	  flag=0;
         System.out.print("�˻��� �̸� >>");
         String name = scanner.next();
         for(i=0; i<num; i++) 
         {
            if(name.equals(phone[i].getName())) //if �ȿ��� ������ return ���� �����ؾ�?
            {
               System.out.println(name+"�� ��ȣ�� "+phone[i].getTel()+" �Դϴ�.");
               flag=1;
               break;
            }
         }
         if(name.equals("�׸�")) break;
         if (flag==0) System.out.println(name+"�� �����ϴ�.");
      }
      
      scanner.close();
   }

}