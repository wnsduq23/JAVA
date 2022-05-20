import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JC18011591M extends JFrame implements ActionListener
{
	JTextArea ShowResult;
	JButton btnReset, btnInput, btnSearch1, btnSearch2, btnSearch3, btnSearch4;
	JPanel pn1,pn2;
	JTextField tf1, tf2;
	JOptionPane error = new JOptionPane(); // ���� �޽����� ����� �˾�â
	String query = new String();
	
	static Connection con;
	   Statement stmt;

	   ResultSet myRS; // ������� �������� ����
	   String Driver = "";
	   String url = "jdbc:mysql://localhost:3306/hospital?&serverTimezone=Asia/Seoul";
	   String userid = "hospital";
	   String pwd = "hospital";     
	  
	public JC18011591M() 
	   {
	      super("18011591/���ؿ�");
	      GUItable();
	      make_con_DB();
	      setVisible(true);
	      setLocationRelativeTo(null);
	      setSize(1000,900);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	
	 public void GUItable()
	   {
		 btnReset = new JButton("��ü �ʱ�ȭ");
	     btnInput = new JButton("INSERT");
	     btnSearch1 = new JButton("�˻�1");
	     btnSearch2 = new JButton("�˻�2"); 
	     btnSearch3 = new JButton("�˻�3"); 
	     btnSearch4 = new JButton("��ü ��ȸ"); 
	     ShowResult = new JTextArea();
	     
	     tf1 = new JTextField("table_name",20); 
	     tf2 = new JTextField("attribute1  ,  'attribute2' , 'attribute3' .....",40); 
	     
	     pn1 = new JPanel();
	     pn2 = new JPanel();
	      
	     pn1.add(btnSearch1);
	     pn1.add(btnSearch2);
	     pn1.add(btnSearch3);
	     pn1.add(btnSearch4);
	     pn1.add(btnReset);
	     pn2.add(new JLabel("INSERT INTO"));
	     pn2.add(tf1);
	     pn2.add(new JLabel(" VALUES ("));
	     pn2.add(tf2);
	     pn2.add(new JLabel(")"));
	     pn2.add(btnInput);
	     
	     Font font = new Font("ABCDEFG", Font.BOLD, 15);
	     ShowResult.setFont(font);
	     ShowResult.setEditable(false);
	     
	     //��� �κ�
	     JScrollPane scrollPane = new JScrollPane(ShowResult);
	     add("North", pn1);
	     add("South", pn2);
	     add("Center", scrollPane);
	     
	     btnInput.addActionListener(this);
	     btnReset.addActionListener(this);
	     btnSearch1.addActionListener(this);
	     btnSearch2.addActionListener(this);
	     btnSearch3.addActionListener(this);
	     btnSearch4.addActionListener(this);
	   }
	 
	 public void make_con_DB() 
	   {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         System.out.println("����̹� �ε� ����");
	      }
	      catch (ClassNotFoundException e) 
	      {
	         e.printStackTrace();
	      }
	      
	      try { /* �����ͺ��̽��� �����ϴ� ���� */
	          System.out.println("�����ͺ��̽� ���� �غ�...");
	          con = DriverManager.getConnection(url, userid, pwd);
	          System.out.println("�����ͺ��̽� ���� ����!");
	          
	          stmt = con.createStatement();
	       }
	      catch (SQLException e1) 
	      {
	          e1.printStackTrace();
	      }
	   }
	 
	 public void actionPerformed(ActionEvent e) 
	   {
	      try
	      {
	         stmt = con.createStatement();
     
	         String query1 = "SELECT p.pat_name,p.pat_addr,p.pat_phone,t.treat_contents,t.treat_date\r\n"
	         		+ "FROM Doctors d INNER JOIN Patients p ON (d.doc_id = p.doc_id) JOIN Treatments t ON (p.pat_id = t.pat_id)\r\n"
	         		+ "WHERE d.doc_name = '�躴��';";
	         String query2 = "SELECT *\r\n"
	         		+ "FROM Doctors d\r\n"
	         		+ "WHERE not exists (SELECT *\r\n"
	         		+ "				FROM Treatments t\r\n"
	         		+ "                WHERE t.doc_id = d.doc_id);";
	         String query3 = "SELECT *\r\n"
	         		+ "FROM Doctors d\r\n"
	         		+ "GROUP BY doc_id\r\n"
	         		+ "HAVING doc_id = (SELECT doc_id\r\n"
	         		+ "FROM Treatments t\r\n"
	         		+ "GROUP  BY doc_id\r\n"
	         		+ "HAVING count(*) = (SELECT max(mycount)\r\n"
	         		+ "FROM (SELECT doc_id, count(*) AS mycount FROM Treatments t GROUP BY doc_id) AS result));";
	         String query4 = "SELECT * FROM Doctors";
	         String query5 = "SELECT * FROM Nurses";
	         String query6 = "SELECT * FROM Patients";
	         String query7 = "SELECT * FROM Treatments";
	         String query8 = "SELECT * FROM Charts";
	         
	         if (e.getSource() == btnSearch1)
	         {
	        	 ShowResult.setText("");
	             ShowResult.setText("pat_name\tpat_addr\t\tpat_phone\t\ttreat_contents\ttreat_date\n");
	             myRS = stmt.executeQuery(query1);
	             while (myRS.next()) 
	             {
	                String str = myRS.getString(1) + "\t" + myRS.getString(2) + "\t\t" + myRS.getString(3) + "\t\t" + myRS.getString(4) + 
	                		"\t\t" + myRS.getString(5)
	                      + "\n";
	                ShowResult.append(str);
	             }
	         }
	         else if (e.getSource() == btnSearch2)
	         {
	        	 ShowResult.setText("");
	             ShowResult.setText("doc_id\tmajor_treat\t\tdoc_name\tdoc_gen\tdoc_phone\t\tdoc_email\t\tdoc_position\n");
	             myRS = stmt.executeQuery(query2);
	             while (myRS.next()) 
	             {
	                String str = myRS.getInt(1) + "\t" + myRS.getString(2) + "\t\t" + myRS.getString(3) + "\t" + myRS.getString(4) + 
	                		"\t" + myRS.getString(5) + "\t\t" + myRS.getString(6) + "\t" + myRS.getString(7)
	                      + "\n";
	                ShowResult.append(str);
	             }
	         }
	         else if (e.getSource() == btnSearch3)
	         {
	        	 ShowResult.setText("");
	             ShowResult.setText("doc_id\tmajor_treat\t\tdoc_name\tdoc_gen\tdoc_phone\t\tdoc_email\t\tdoc_position\n");
	             myRS = stmt.executeQuery(query3);
	             while (myRS.next()) 
	             {
	                String str = myRS.getInt(1) + "\t" + myRS.getString(2) + "\t\t" + myRS.getString(3) + "\t" + myRS.getString(4) + 
	                		"\t" + myRS.getString(5) + "\t\t" + myRS.getString(6) + "\t" + myRS.getString(7)
	                      + "\n";
	                ShowResult.append(str);
	             }
	         }
	         else if (e.getSource() == btnSearch4)
	         {
	        	 ShowResult.setText("");
	             ShowResult.setText("doc_id\tmajor_treat\t\tdoc_name\tdoc_gen\tdoc_phone\t\tdoc_email\t\tdoc_position\n");
	             myRS = stmt.executeQuery(query4);
	             while (myRS.next()) 
	             {
	                String str = myRS.getInt(1) + "\t" + myRS.getString(2) + "\t\t" + myRS.getString(3) + "\t" + myRS.getString(4) + 
	                		"\t" + myRS.getString(5) + "\t\t" + myRS.getString(6) + "\t" + myRS.getString(7)
	                      + "\n";
	                ShowResult.append(str);
	             }
	             ShowResult.append("\nnur_id\tmajor_job\t\tnur_name\tnur_gen\tnur_phone\t\tnur_email\t\tnur_position\n");
	             myRS = stmt.executeQuery(query5);
	             while (myRS.next()) 
	             {
	                String str = myRS.getInt(1) + "\t" + myRS.getString(2) + "\t\t" + myRS.getString(3) + "\t" + myRS.getString(4) + 
	                		"\t" + myRS.getString(5) + "\t\t" + myRS.getString(6) + "\t" + myRS.getString(7)
	                      + "\n";
	                ShowResult.append(str);
	             }
	             ShowResult.append("\npat_id\tnur_id\t\tdoc_id\tpat_name\tpat_gen\t\tpat_jumin\t\tpat_addr\tpat_phone\tpat_email\tpat_job\n");
	             myRS = stmt.executeQuery(query6);
	             while (myRS.next()) 
	             {
	                String str = myRS.getInt(1) + "\t" + myRS.getInt(2) + "\t\t" + myRS.getInt(3) + "\t" + myRS.getString(4) + 
	                		"\t" + myRS.getString(5) + "\t\t" + myRS.getInt(6) + "\t\t" + myRS.getString(7) + "\t" +myRS.getString(8)
	                		+ "\t" + myRS.getString(9) + "\t" + myRS.getString(10)
	                		+ "\n";
	                ShowResult.append(str);
	             }
	             ShowResult.append("\ntreat_id\tpat_id\t\tdoc_id\ttreat_contents\ttreat_date\n");
	             myRS = stmt.executeQuery(query7);
	             while (myRS.next()) 
	             {
	                String str = myRS.getInt(1) + "\t" + myRS.getInt(2) + "\t\t" + myRS.getInt(3) + "\t" + myRS.getString(4) + 
	                		"\t\t" + myRS.getString(5)
	                      + "\n";
	                ShowResult.append(str);
	             }
	             ShowResult.append("\nchart_id\ttreat_id\t\tdoc_id\tpat_id\tnur_id\t\tchar_contetns\n");
	             myRS = stmt.executeQuery(query8);
	             while (myRS.next()) 
	             {
	                String str = myRS.getString(1) + "\t" + myRS.getInt(2) + "\t\t" + myRS.getInt(3) + "\t" + myRS.getInt(4) + 
	                		"\t" + myRS.getInt(5) + "\t\t" + myRS.getString(6)
	                      + "\n";
	                ShowResult.append(str);
	             }
	             
	         }
	         else if (e.getSource() == btnReset)
	         {
	        	 ShowResult.setText("");
	             try
	             {
	            	 stmt.executeUpdate("DELETE FROM Charts");
	            	 stmt.executeUpdate("DELETE FROM Treatments");
	            	 stmt.executeUpdate("DELETE FROM Patients");
	            	 stmt.executeUpdate("DELETE FROM Nurses");
	            	 stmt.executeUpdate("DELETE FROM Doctors");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(980312, '�Ҿư�', '������', 'M', '010-333-1340', 'ltj@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(000601, '����', '�ȼ���', 'M', '011-222-0987', 'ask@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(001208, '�ܰ�', '�����', 'M', '010-333-8743', 'kmj@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(020403, '�Ǻΰ�', '���¼�', 'M', '019-777-3764', 'lts@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(050900, '�Ҿư�', '�迬��', 'F', '010-555-3746', 'kya@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(050101, '����', '������', 'M', '011-222-7643', 'cth@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(062019, '�Ҿư�', '������', 'F', '010-999-1265', 'jjh@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(070576, '�Ǻΰ�', 'ȫ�浿', 'M', '016-333-7263', 'hgd@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(080543, '��缱��', '���缮', 'M', '010-222-1263', 'yjs@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(091001, '�ܰ�', '�躴��', 'M', '010-555-3542', 'kbm@hanbit.com', '������');");

	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(050302, '�Ҿư�', '������', 'F', '010-555-8751', 'key@hanbit.com', '����ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(050021, '����', '������', 'F', '016-333-8745', 'ysa@hanbit.com', '����ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(040089, '�Ǻΰ�', '������', 'M', '010-666-7646', 'sjw@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(070605, '��缱��', '����ȭ', 'F', '010-333-4588', 'yjh@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(070804, '����', '���ϳ�', 'F', '010-222-1340', 'nhn@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(071018, '�Ҿư�', '��ȭ��', 'F', '019-888-4116', 'khk@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(100356, '�Ҿư�', '�̼���', 'M', '010-777-1234', 'lsy@hanbit.com', '��ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(104145, '�ܰ�', '����', 'M', '010-999-8520', 'kh@hanbit.com', '��ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(120309, '�Ǻΰ�', '�ڼ���', 'M', '010-777-4996', 'psw@hanbit.com', '��ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(130211, '�ܰ�', '�̼���', 'F', '010-222-3214', 'lsy2@hanbit.com', '��ȣ��');");

	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(2345, 050302, 980312, '�Ȼ��', 'M', 232345, '����', '010-555-7845', 'ask@ab.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(3545, 040089, 020403, '�輺��', 'M', 543545, '����', '010-333-7812', 'ksn@bb.com', '�ڿ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(3424, 070605, 080543, '������', 'M', 433424, '�λ�', '010-888-4859', 'ljj@ab.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(7675, 100356, 050900, '�ֱ���', 'M', 677675, '����', '010-222-4847', 'cks@cc.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(4533, 070804, 000601, '���Ѱ�', 'M', 744533, '����', '010-777-9630', 'jhk@ab.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(5546, 120309, 070576, '������', 'M', 765546, '�뱸', '016-777-0214', 'ywh@cc.com', '�ڿ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(4543, 070804, 050101, '������', 'M', 454543, '�λ�', '010-555-4187', 'cjj@bb.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(9768, 130211, 091001, '������', 'F', 119768, '����', '010-888-3675', 'ljh@ab.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(4234, 130211, 091001, '������', 'F', 234234, '����', '010-999-6541', 'onm@cc.com', '�л�');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(7643, 071018, 062019, '�ۼ���', 'M', 987643, '����', '010-222-5874', 'ssm@bb.com', '�л�');");

	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(130516023, 2345, 980312, '����, ����', STR_TO_DATE('2013-05-16','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(130628100, 3545, 020403, '�Ǻ� Ʈ���� ġ��', STR_TO_DATE('2013-06-28','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(131205056, 3424, 080543, '�� ��ũ�� MRI �Կ�', STR_TO_DATE('2013-12-05','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(131218024, 7675, 050900, '���̿�', STR_TO_DATE('2013-12-18','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(131224012, 4533, 000601, '�忰', STR_TO_DATE('2013-12-24','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140103001, 5546, 070576, '���帧 ġ��', STR_TO_DATE('2014-01-03','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140109026, 4543, 050101, '����', STR_TO_DATE('2014-01-09','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140226102, 9768, 091001, 'ȭ��ġ��', STR_TO_DATE('2014-02-26','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140303003, 4234, 091001, '������ �ܻ�ġ��', STR_TO_DATE('2014-03-03','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140308087, 7643, 062019, '�忰', STR_TO_DATE('2014-03-08','%Y-%m-%d'));");

	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('PD13572410', 130516023, 980312, 2345, 050302, '����, ����� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('DM11389132', 130628100, 020403, 3545, 040089, '�Ǻξ� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('RD10023842', 131205056, 080543, 3424, 070605, '�� ��ũ �ǽ�, �߰� �˻� �ʿ�');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('PD13581241', 131218024, 050900, 7675, 100356, '���ݰ��� �߰� �˻� �ʿ�');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('IM12557901', 131224012, 000601, 4533, 070804, '����� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('DM11400021', 140103001, 070576, 5546, 120309, '���帧 ġ���� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('IM12708224', 140109026, 050101, 4543, 070804, '���� �ɰ�, �߰� �˻� �� ���� ����');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('GS17223681', 140226102, 091001, 9768, 130211, 'ȭ��� ó�� �� ����ġ��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('GS17264430', 140303003, 091001, 4234, 130211, '�߰� �������� �ʿ���');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('PD13664611', 140308087, 062019, 7643, 071018, '�忰�� ó��');");
	             }
	             catch (Exception e2)
	             {
	            	 error.showMessageDialog(null, e2, "ERROR_MESSAGE", JOptionPane.QUESTION_MESSAGE);
	             }
	             error.showMessageDialog(null,"SUCCESS RESET DATA!");
	         }
	         else if (e.getSource() == btnInput)
	         {
	        	 try 
	        	 {
	        		 query= "INSERT INTO " + tf1.getText() + " VALUES(" + tf2.getText() + ");";
	        		 System.out.println(query);
	        		 tf1.setText("table_name"); 
	        		 tf2.setText("attribute1  ,  'attribute2' , 'attribute3' .....");
	        		 stmt.executeUpdate(query);
	        	 }
	              catch (Exception e3)
	              {
	            	 error.showMessageDialog(null, e3, "ERROR_MESSAGE", JOptionPane.QUESTION_MESSAGE);
	              }
	         }
	      }
	      catch (Exception e4)
	      {
	    	  error.showMessageDialog(null, e4, "ERROR_MESSAGE", JOptionPane.QUESTION_MESSAGE);
	      }
	   }
	 
	 public static void main(String[] args) 
	   {
		 JC18011591M HL = new JC18011591M();
	      
	      HL.addWindowListener(new WindowAdapter() 
	      {
	    	  public void windowClosing(WindowEvent we) 
	    	  {
	    		try 
	    		{
	    			Statement stmt;
	    			stmt = con.createStatement();
	            	 stmt.executeUpdate("DELETE FROM Charts");
	            	 stmt.executeUpdate("DELETE FROM Treatments");
	            	 stmt.executeUpdate("DELETE FROM Patients");
	            	 stmt.executeUpdate("DELETE FROM Nurses");
	            	 stmt.executeUpdate("DELETE FROM Doctors");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(980312, '�Ҿư�', '������', 'M', '010-333-1340', 'ltj@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(000601, '����', '�ȼ���', 'M', '011-222-0987', 'ask@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(001208, '�ܰ�', '�����', 'M', '010-333-8743', 'kmj@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(020403, '�Ǻΰ�', '���¼�', 'M', '019-777-3764', 'lts@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(050900, '�Ҿư�', '�迬��', 'F', '010-555-3746', 'kya@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(050101, '����', '������', 'M', '011-222-7643', 'cth@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(062019, '�Ҿư�', '������', 'F', '010-999-1265', 'jjh@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(070576, '�Ǻΰ�', 'ȫ�浿', 'M', '016-333-7263', 'hgd@hanbit.com', '������');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(080543, '��缱��', '���缮', 'M', '010-222-1263', 'yjs@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Doctors VALUES(091001, '�ܰ�', '�躴��', 'M', '010-555-3542', 'kbm@hanbit.com', '������');");

	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(050302, '�Ҿư�', '������', 'F', '010-555-8751', 'key@hanbit.com', '����ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(050021, '����', '������', 'F', '016-333-8745', 'ysa@hanbit.com', '����ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(040089, '�Ǻΰ�', '������', 'M', '010-666-7646', 'sjw@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(070605, '��缱��', '����ȭ', 'F', '010-333-4588', 'yjh@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(070804, '����', '���ϳ�', 'F', '010-222-1340', 'nhn@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(071018, '�Ҿư�', '��ȭ��', 'F', '019-888-4116', 'khk@hanbit.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(100356, '�Ҿư�', '�̼���', 'M', '010-777-1234', 'lsy@hanbit.com', '��ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(104145, '�ܰ�', '����', 'M', '010-999-8520', 'kh@hanbit.com', '��ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(120309, '�Ǻΰ�', '�ڼ���', 'M', '010-777-4996', 'psw@hanbit.com', '��ȣ��');");
	            	 stmt.executeUpdate("INSERT INTO Nurses VALUES(130211, '�ܰ�', '�̼���', 'F', '010-222-3214', 'lsy2@hanbit.com', '��ȣ��');");

	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(2345, 050302, 980312, '�Ȼ��', 'M', 232345, '����', '010-555-7845', 'ask@ab.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(3545, 040089, 020403, '�輺��', 'M', 543545, '����', '010-333-7812', 'ksn@bb.com', '�ڿ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(3424, 070605, 080543, '������', 'M', 433424, '�λ�', '010-888-4859', 'ljj@ab.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(7675, 100356, 050900, '�ֱ���', 'M', 677675, '����', '010-222-4847', 'cks@cc.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(4533, 070804, 000601, '���Ѱ�', 'M', 744533, '����', '010-777-9630', 'jhk@ab.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(5546, 120309, 070576, '������', 'M', 765546, '�뱸', '016-777-0214', 'ywh@cc.com', '�ڿ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(4543, 070804, 050101, '������', 'M', 454543, '�λ�', '010-555-4187', 'cjj@bb.com', 'ȸ���');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(9768, 130211, 091001, '������', 'F', 119768, '����', '010-888-3675', 'ljh@ab.com', '����');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(4234, 130211, 091001, '������', 'F', 234234, '����', '010-999-6541', 'onm@cc.com', '�л�');");
	            	 stmt.executeUpdate("INSERT INTO Patients VALUES(7643, 071018, 062019, '�ۼ���', 'M', 987643, '����', '010-222-5874', 'ssm@bb.com', '�л�');");

	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(130516023, 2345, 980312, '����, ����', STR_TO_DATE('2013-05-16','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(130628100, 3545, 020403, '�Ǻ� Ʈ���� ġ��', STR_TO_DATE('2013-06-28','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(131205056, 3424, 080543, '�� ��ũ�� MRI �Կ�', STR_TO_DATE('2013-12-05','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(131218024, 7675, 050900, '���̿�', STR_TO_DATE('2013-12-18','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(131224012, 4533, 000601, '�忰', STR_TO_DATE('2013-12-24','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140103001, 5546, 070576, '���帧 ġ��', STR_TO_DATE('2014-01-03','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140109026, 4543, 050101, '����', STR_TO_DATE('2014-01-09','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140226102, 9768, 091001, 'ȭ��ġ��', STR_TO_DATE('2014-02-26','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140303003, 4234, 091001, '������ �ܻ�ġ��', STR_TO_DATE('2014-03-03','%Y-%m-%d'));");
	            	 stmt.executeUpdate("INSERT INTO Treatments VALUES(140308087, 7643, 062019, '�忰', STR_TO_DATE('2014-03-08','%Y-%m-%d'));");

	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('PD13572410', 130516023, 980312, 2345, 050302, '����, ����� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('DM11389132', 130628100, 020403, 3545, 040089, '�Ǻξ� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('RD10023842', 131205056, 080543, 3424, 070605, '�� ��ũ �ǽ�, �߰� �˻� �ʿ�');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('PD13581241', 131218024, 050900, 7675, 100356, '���ݰ��� �߰� �˻� �ʿ�');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('IM12557901', 131224012, 000601, 4533, 070804, '����� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('DM11400021', 140103001, 070576, 5546, 120309, '���帧 ġ���� ó��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('IM12708224', 140109026, 050101, 4543, 070804, '���� �ɰ�, �߰� �˻� �� ���� ����');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('GS17223681', 140226102, 091001, 9768, 130211, 'ȭ��� ó�� �� ����ġ��');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('GS17264430', 140303003, 091001, 4234, 130211, '�߰� �������� �ʿ���');");
	            	 stmt.executeUpdate("INSERT INTO Charts VALUES('PD13664611', 140308087, 062019, 7643, 071018, '�忰�� ó��');");
	    			con.close();
	    			
	    		} catch (Exception e5)
	    		{ e5.printStackTrace();}
	    	  }
	    	});
	   }
}
