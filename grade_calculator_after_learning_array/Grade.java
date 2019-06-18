
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
			System.out.println("-----성적산출 프로그램 입니다-----");
			System.out.println("1.재학생 수 입력 | 2.개별학생 성적입력 | 3.전체 성적표 출력 			| 4.개별학생 성적 조회 | 5.프로그램 종료");
			System.out.println("--------------------------");
			System.out.print("원하는 메뉴를 선택하십시오. >");
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				if(student ==0) {
					System.out.println("재학생 수를 입력하세요");
					System.out.print(">");
					student = scanner.nextInt();
					 if(2<=student && student<=10) {
						information = new String[student][8];
					 } else {
						 student=0;
						 System.out.println("입력가능한 최소 학생수는 2명, 최대 							학생수는 10명입니다.");
						 System.out.println("---다시 메뉴를 선택해주세요.---");
					 }
				} else {
					System.out.println("=========================");
					System.out.println("[알림]재학생수를 이미 입력하셨습니다.");
					System.out.println("=========================");
				}
			} else if(selectNo == 2) {
				if(row < student) {
					
					System.out.println("이름을 입력하세요");
					System.out.print(">");
				    	information[row][0] = scanner.nextLine();					
					
					System.out.println("학번을 입력하세요");
					System.out.print(">");
					information[row][1] = scanner.nextLine();
										
					System.out.println("중간고사 성적을 입력하세요");
					System.out.print(">");
					information[row][2] = scanner.nextLine();
										
					System.out.println("기말고사 성적을 입력하세요");
					System.out.print(">");
					information[row][3] = scanner.nextLine();
									
					System.out.println("출석점수를 입력하세요");
					System.out.print(">");
					information[row][4] = scanner.nextLine();
										
					System.out.println("과제점수를 입력하세요");
					System.out.print(">");
					information[row][5] = scanner.nextLine();
					
					//총점소숫점 첫째자리까지와 학점
					 double doubletotal = 										((double)((int)((Double.valueOf(information[row][2])*0.3 +
				 		Double.valueOf(information[row][3])*0.3+ 								Double.valueOf(information[row][4])*0.15 + 
						Double.valueOf(information[row][5])*0.25) * 10)))/10;
					 information[row][6] =  Double.toString(doubletotal);
					 //평균총점
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
					 //최고점,최저점 구하기
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
					System.out.println("[알림] 더이상 학생을 등록할 수 없습니다.");
					System.out.println("===========================");
				}
				
				
			} else if(selectNo == 3) {
				//성적표출력
				System.out.println("이름\t학번\t중간\t기말\t출석\t과제\t총점\t학점");
				System.out.println("====================================
				================");
				for(int i=0; i<information.length; i++) {
					for(int k=0; k<information[i].length; k++) {
						System.out.print(information[i][k] + "\t");
					}
					System.out.println("\n");
				}
				
				//학점등급별 출력
				System.out.println("학점 | 인원");
				System.out.println("A | " + grade_a + "\n" +"B | " +grade_b +"\n" +"C 					| " +grade_c +"\n" +"D | " +grade_d +"\n" +"F | " +grade_f  );
				//재학인원,평균점수,평균등급
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
				System.out.println("재학 인원:" + row + "평균점수:" + avg_total + "평균 				학점:" + avg_grade);
				System.out.println("===============================
				=====================");
				//최고점,최저점
				System.out.println("\t이름\t점수\t학점");
				System.out.println("최고점 "+ information[max][0] +"\t"+ 						information[max][6] +"\t"+information[max][7]);
				System.out.println("최저점 "+ information[min][0] +"\t"+ 						information[min][6]+"\t"+ information[min][7]);
				
			} else if(selectNo == 4) {
				System.out.println("조회 할 학생의 이름을 입력하세요");
				System.out.print(">");
				String name = scanner.next();
				int searchedIndex = -1; 
	            
	            		for(int i = 0; i < information.length;i++) {
	            			if(name.compareTo(information[i][0]) == 0) {
	            				searchedIndex = i;
	            			}
	           		 }
	            
	            		if(searchedIndex >= 0) {
	            			System.out.println(name + "님의 성적 조회입니다.");
	                		System.out.println("학번\t중간\t기말\t출석\t과제\t총점\t학점");
	                															System.out.println(information[searchedIndex][1]+
					"\t"+information[searchedIndex][2]+"\t“
					+information[searchedIndex][3]+
	                     		"\t"+information[searchedIndex][4]+"\t“
					+information[searchedIndex][5]+"\t“
					+information[searchedIndex][6]
	                             +"\t"+information[searchedIndex][7]);
	            		}
	            		else {
	            			System.out.println("===========================");
	                		System.out.println("[알림]등록되어있지 않은 학생입니다.");
	                		System.out.println("===========================");
	            		}
			} else if(selectNo == 5) {
				break;
			}
			
		}
		System.out.println ("프로그램을 종료합니다.");
	}
}