
import java.util.Scanner;

public class Grade{
	public static void main(String[] args) {
		String[][] information = null;
		int student = 0;
		int max = 0;
		int min = 0;
		Scanner scanner = new Scanner(System.in);
		int row = 0;
		int grade_a = 0;
		int grade_b = 0;
		int grade_c = 0;
		int grade_d = 0;
		int grade_f = 0;
		double Max = 0;
		double Min = 1000;
		double avg_total = 0;
		String grade = null;
		String avg_grade = null;
		
		while(true) {
			System.out.println("-----�������� ���α׷� �Դϴ�-----");
			System.out.println("1.���л� �� �Է� | 2.�����л� �����Է� | 3.��ü ����ǥ ��� 			| 4.�����л� ���� ��ȸ | 5.���α׷� ����");
			System.out.println("--------------------------");
			System.out.print("���ϴ� �޴��� �����Ͻʽÿ�. >");
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				if(student ==0) {
					System.out.println("���л� ���� �Է��ϼ���");
					System.out.print(">");
					student = scanner.nextInt();
					 if(2<=student && student<=10) {
						information = new String[student][8];
					 } else {
						 student=0;
						 System.out.println("�Է°����� �ּ� �л����� 2��, �ִ� 							�л����� 10���Դϴ�.");
						 System.out.println("---�ٽ� �޴��� �������ּ���.---");
					 }
				} else {
					System.out.println("=========================");
					System.out.println("[�˸�]���л����� �̹� �Է��ϼ̽��ϴ�.");
					System.out.println("=========================");
				}
			} else if(selectNo == 2) {
				if(row < student) {
					
					System.out.println("�̸��� �Է��ϼ���");
					System.out.print(">");
				    	information[row][0] = scanner.nextLine();					
					
					System.out.println("�й��� �Է��ϼ���");
					System.out.print(">");
					information[row][1] = scanner.nextLine();
										
					System.out.println("�߰���� ������ �Է��ϼ���");
					System.out.print(">");
					information[row][2] = scanner.nextLine();
										
					System.out.println("�⸻��� ������ �Է��ϼ���");
					System.out.print(">");
					information[row][3] = scanner.nextLine();
									
					System.out.println("�⼮������ �Է��ϼ���");
					System.out.print(">");
					information[row][4] = scanner.nextLine();
										
					System.out.println("���������� �Է��ϼ���");
					System.out.print(">");
					information[row][5] = scanner.nextLine();
					
					//�����Ҽ��� ù°�ڸ������� ����
					 double doubletotal = 										((double)((int)((Double.valueOf(information[row][2])*0.3 +
				 		Double.valueOf(information[row][3])*0.3+ 								Double.valueOf(information[row][4])*0.15 + 
						Double.valueOf(information[row][5])*0.25) * 10)))/10;
					 information[row][6] =  Double.toString(doubletotal);
					 //�������
					 avg_total += doubletotal;
					 
					 if(doubletotal >=90) {
							grade= "A";
							grade_a++;
						} else if (doubletotal >= 80) {
							grade = "B";
							grade_b++;
						} else if (doubletotal >= 70) {
							grade = "C";
							grade_c++;
						} else if (doubletotal >= 60) {
							grade = "D";
							grade_d++;
						} else {
							grade = "F";
							grade_f++;
						} 
					 information[row][7] = grade;
					 //�ְ���,������ ���ϱ�
					 if( Max < doubletotal) {
						 Max = doubletotal;
						 max = row;
					   } else if( Min > doubletotal) {
						   Min = doubletotal;
						   min = row; 
						   }
					 
					 row++;	
				} else {
					System.out.println("===========================");
					System.out.println("[�˸�] ���̻� �л��� ����� �� �����ϴ�.");
					System.out.println("===========================");
				}
				
				
			} else if(selectNo == 3) {
				//����ǥ���
				System.out.println("�̸�\t�й�\t�߰�\t�⸻\t�⼮\t����\t����\t����");
				System.out.println("====================================
				================");
				for(int i=0; i<information.length; i++) {
					for(int k=0; k<information[i].length; k++) {
						System.out.print(information[i][k] + "\t");
					}
					System.out.println("\n");
				}
				
				//������޺� ���
				System.out.println("���� | �ο�");
				System.out.println("A | " + grade_a + "\n" +"B | " +grade_b +"\n" +"C 					| " +grade_c +"\n" +"D | " +grade_d +"\n" +"F | " +grade_f  );
				//�����ο�,�������,��յ��
				avg_total = ((double)((int)(avg_total/row* 10)))/10;
				if(avg_total>=90) {
					avg_grade= "A";
				} else if (avg_total >= 80) {
					avg_grade = "B";
				} else if (avg_total >= 70) {
					avg_grade = "C";
				} else if (avg_total >= 60) {
					avg_grade = "D";
				} else {
					avg_grade = "F";
				} 
				System.out.println("===============================
				=====================");
				System.out.println("���� �ο�:" + row + "�������:" + avg_total + "��� 				����:" + avg_grade);
				System.out.println("===============================
				=====================");
				//�ְ���,������
				System.out.println("\t�̸�\t����\t����");
				System.out.println("�ְ��� "+ information[max][0] +"\t"+ 						information[max][6] +"\t"+information[max][7]);
				System.out.println("������ "+ information[min][0] +"\t"+ 						information[min][6]+"\t"+ information[min][7]);
				
			} else if(selectNo == 4) {
				System.out.println("��ȸ �� �л��� �̸��� �Է��ϼ���");
				System.out.print(">");
				String name = scanner.next();
				int searchedIndex = -1; 
	            
	            		for(int i = 0; i < information.length;i++) {
	            			if(name.compareTo(information[i][0]) == 0) {
	            				searchedIndex = i;
	            			}
	           		 }
	            
	            		if(searchedIndex >= 0) {
	            			System.out.println(name + "���� ���� ��ȸ�Դϴ�.");
	                		System.out.println("�й�\t�߰�\t�⸻\t�⼮\t����\t����\t����");
	                															System.out.println(information[searchedIndex][1]+
					"\t"+information[searchedIndex][2]+"\t��
					+information[searchedIndex][3]+
	                     		"\t"+information[searchedIndex][4]+"\t��
					+information[searchedIndex][5]+"\t��
					+information[searchedIndex][6]
	                             +"\t"+information[searchedIndex][7]);
	            		}
	            		else {
	            			System.out.println("===========================");
	                		System.out.println("[�˸�]��ϵǾ����� ���� �л��Դϴ�.");
	                		System.out.println("===========================");
	            		}
			} else if(selectNo == 5) {
				break;
			}
			
		}
		System.out.println ("���α׷��� �����մϴ�.");
	}
}