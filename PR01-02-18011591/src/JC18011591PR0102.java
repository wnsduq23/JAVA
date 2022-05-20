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
      System.out.print("인원수 >> ");
      int num = scanner.nextInt();
      phone = new PhoneBook[num];
      for(i=0; i<num; i++) {
         System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
         String name = scanner.next();
         String tel = scanner.next();
         phone[i] = new PhoneBook(name, tel);
      }
      System.out.println("저장되었습니다...");
      while(true) {
    	  flag=0;
         System.out.print("검색할 이름 >>");
         String name = scanner.next();
         for(i=0; i<num; i++) 
         {
            if(name.equals(phone[i].getName())) //if 안에는 무조건 return 값이 존재해야?
            {
               System.out.println(name+"의 번호는 "+phone[i].getTel()+" 입니다.");
               flag=1;
               break;
            }
         }
         if(name.equals("그만")) break;
         if (flag==0) System.out.println(name+"이 없습니다.");
      }
      
      scanner.close();
   }

}