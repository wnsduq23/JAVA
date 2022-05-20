import java.util.*;
class Word {
    private String english;
    private String korean;
    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }
    public String getEnglish() { return english; }
    public String getKorean() { return korean; }
 
}
public class chap07_12
{
    private String name; // ���� ���α׷��� �̸�
    private Vector<Word> v;
    private Scanner scanner;
    public chap07_12(String name) {
        this.name = name;
        v = new Vector<Word>();
        scanner = new Scanner(System.in);
        v.add(new Word("love", "���"));
        v.add(new Word("animal", "����"));
        v.add(new Word("emotion", "����"));
        v.add(new Word("human", "�ΰ�"));
        v.add(new Word("stock", "�ֽ�"));
        v.add(new Word("trade", "�ŷ�"));
        v.add(new Word("society", "��ȸ"));
        v.add(new Word("baby", "�Ʊ�"));
        v.add(new Word("honey", "��"));
        v.add(new Word("dall", "����"));
        v.add(new Word("bear", "��"));
        v.add(new Word("picture", "����"));
        v.add(new Word("painting", "�׸�"));
        v.add(new Word("fault", "����"));
        v.add(new Word("example", "����"));
        v.add(new Word("eye", "��"));
        v.add(new Word("statue", "������"));
    }
 
    private int makeExample(int ex[], int answerIndex) {
        int n[] = {-1, -1, -1, -1}; // -1�� �ʱ�ȭ
        int index;
        for(int i=0; i<n.length; i++) {
            do {
                index = (int)(Math.random()*v.size());
            } while(index == answerIndex || exists(n, index)); // �ٽ� �õ�
            n[i] = index;
        }
 
        for(int i=0; i<n.length; i++) ex[i] = n[i];
        return (int)(Math.random()*n.length); // ex[] �迭 ���� ������ ��ġ ����. �̰��� ������ �ɴ´�.
    }
 
    private boolean exists(int n[], int index) {
        for(int i=0; i<n.length; i++) {
            if(n[i] == index)
                return true;
        }
        return false;
    }
    private void test(){
        System.out.println("���� " + v.size() + "���� �ܾ ��� �ֽ��ϴ�. -1�� �Է��ϸ� �����մϴ�.");
        while(true) {
            int answerIndex = (int)(Math.random()*v.size()); // ������ ��� �ִ� ���� �׸��� �ε���
            String eng = v.get(answerIndex).getEnglish(); // ������ �־��� ���� �ܾ�
 
            // 4���� ���⸦ ���� ������ index �迭
            int example[] = new int [4];
 
            int answerLoc = makeExample(example, answerIndex); // ������ �ִ� ���� ��ȣ
            example[answerLoc] = answerIndex; // ���⿡ ���� �ε��� ����
 
            // ������ ����մϴ�.
            System.out.println(eng + "?");
            for(int i=0; i<example.length; i++)
                System.out.print("(" + (i+1) + ")" + v.get(example[i]).getKorean() + " "); // ���� ���
 
            System.out.print(":>"); // ������Ʈ
            try {
                int in = scanner.nextInt(); // ������� ���� �Է�
                if(in == -1) {
                    break; // ���α׷� ����
                }
 
                // ����ڰ� 1~4 ������ ���� �Է�
                in--; // 1~4�� 0~3�� �ε����� �ٲ�
                if(in == answerLoc)
                    System.out.println("Excellent !!");
                else
                    System.out.println("No. !!");
            }
            catch(InputMismatchException e) {
                scanner.next(); // ���� ��Ʈ�� ���ۿ� �ԷµǾ� �ִ� �Է��� �о ������
                System.out.println("���ڸ� �Է��ϼ��� !!");
                // while ������ �ٽ� �ݺ�
            }
        }
    }
 
    public void run() {
        boolean flag = true;
        System.out.println("**** ���� �ܾ� �׽�Ʈ ���α׷�" + "\"" + name + "\"" + "�Դϴ�.");
        while(flag){
            System.out.print("�ܾ� �׽�Ʈ:1, �ܾ� ����:2, ����:3>> ");
            int select = scanner.nextInt();
            switch(select){
                case 1:
                    this.test();
                    break;
                case 2:
                    System.out.println("���� �ܾ �׸��� �Է��ϸ� �Է��� �����մϴ�.");
                    while(true){
                        System.out.print("���� �ѱ� �Է� >> ");
                        String english = scanner.next();
                        if(english.equals("�׸�")){
                            break;
                        }
                        String korean = scanner.next();
                        v.add(new Word(english, korean));
                    }
                    break;
                case 3:
                    System.out.print("\"" + name + "\"�� �����մϴ�...");
                    flag = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("�߸��Է��߽��ϴ�.");
                    break;
            }
        }
    }
    public static void main(String[] args) {
    	chap07_12 quiz = new chap07_12("��ǰ����");
        quiz.run();
    }
}