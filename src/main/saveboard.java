package main;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class saveboard {
	Calendar cal = Calendar.getInstance();
	
	private ArrayList<String> savetitle = new ArrayList<>();
	private ArrayList<String> savetext = new ArrayList<>();
	private ArrayList<String> savedate = new ArrayList<>();
	private ArrayList<Integer> saveview = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private String title;
	private String text;
	private String retitle;
	private String retext;
	private int size = 0;
	private String viewstr;
	private int viewnum;
	private String updatestr;
	private int updatenum;
	private String removestr;
	private int removenum;
	
	void add () {
		System.out.print("게시물 제목을 입력해주세요 : ");
		title = sc.nextLine();
		System.out.print("게시물 내용을 입력해주세요 : ");
		text = sc.nextLine();
		savetitle.add(title);
		savetext.add(text);
		String year = Integer.toString(cal.get ( YEAR ));
		String month = Integer.toString(cal.get ( MONTH ) + 1 );
		String date = Integer.toString(cal.get ( DATE )) ;
		savedate.add(year + "." + month + "." + date);
		saveview.add(0);
		size++;
		System.out.println("게시물이 등록되었습니다.");
	}
	
	void testdata() {
		String str;
		for (int i = 1; i <= 3; i++) {
			str = Integer.toString(i);
			title = "제목" + str;
			text = "내용" + str;
			savetitle.add(title);
			savetext.add(text);
			String year = Integer.toString(cal.get ( YEAR ));
			String month = Integer.toString(cal.get ( MONTH ) + 1 );
			String date = Integer.toString(cal.get ( DATE )) ;
			savedate.add(year + "." + month + "." + date);
			saveview.add(0);
			size++;
		}
	}
	
	public int getSize() {
		return size;
	}


	void list() {
		line();
		for (int i = 0; i < savetitle.size(); i++) {
			int a = saveview.get(i);
			System.out.println((i + 1) + " 번 게시물");
			System.out.println(savetitle.get(i));
			System.out.println("작성자 : 익명");
			System.out.println("등록 날짜 : " + savedate.get(i));
			System.out.println("조회수 : " + (a));
			line();
		}
	}
	
	void viewprint(int num) {
		int a = saveview.get(num);
		saveview.set(num, (a + 1));
		System.out.println("=======" + (num + 1) + "번 게시물=======");
		System.out.println("번호 : " + (num + 1));
		System.out.println("제목 : " + savetitle.get(num));
		System.out.println("작성자 : 익명");
		System.out.println("등록 날짜 : " + savedate.get(num));
		System.out.println("조회수 : " + (a + 1));
		System.out.println(savetext.get(num));
		line();
	}
	
	void view() {
		int size = getSize();
		if (size < 1) {
			System.out.println("게시물이 하나도 없습니다. 게시물을 작성한 후 열람해 주세요.");
		}else {
			System.out.print("열람할 게시물의 번호를 입력해주세요 : ");
			viewstr = sc.nextLine();
			viewnum = Integer.parseInt(viewstr) - 1;
			if (viewnum > size - 1) {
				System.out.println("너무 큰 숫자입니다. ( 현재 " + size + "개의 게시물 존재 )");
			}else {				
//				System.out.println(viewstr + "번의 게시물을 열람합니다.");
				viewprint(viewnum);
			}
		}
	}
	
	void update() {
		int size = getSize();
		if (size < 1) {
			System.out.println("게시물이 하나도 없습니다. 게시물을 작성한 후 수정해 주세요.");
		}else {
			System.out.print("수정할 게시물의 번호를 입력해주세요 : ");
			updatestr = sc.nextLine();
			updatenum = Integer.parseInt(updatestr) - 1;
			if (updatenum > size - 1) {
				System.out.println("너무 큰 숫자입니다. ( 현재 " + size + "개의 게시물 존재 )");
			}else {				
				System.out.println(updatestr + "번의 게시물을 수정합니다.");
				repair(updatenum);
			}
		}		
	}
	void repair(int num) {
		System.out.print("새로운 게시물 제목을 입력해주세요 : ");
		retitle = sc.nextLine();
		System.out.print("새로운 게시물 내용을 입력해주세요 : ");
		retext = sc.nextLine();
		savetitle.set(updatenum, retitle);
		savetext.set(updatenum, retext);
		size++;
		System.out.println("게시물이 수정되었습니다.");
	}
	
	void delete() {
		int size = getSize();
		if (size < 1) {
			System.out.println("게시물이 하나도 없습니다. 게시물을 작성한 후 삭제해 주세요.");
		}else {
			System.out.print("삭제할 게시물의 번호를 입력해주세요 : ");
			removestr = sc.nextLine();
			removenum = Integer.parseInt(removestr) - 1;
			if (removenum > size - 1) {
				System.out.println("너무 큰 숫자입니다. ( 현재 " + size + "개의 게시물 존재 )");
			}else {				
				System.out.println(removestr + "번의 게시물을 삭제합니다. ( 현재 " + (size - 1) + "개의 게시물 존재 )");
				savetitle.remove(removenum);
				savetext.remove(removenum);
				size--;
			}
		}		
	}
	
	void search(String str) {
		line();
		for (int i = 0; i < savetitle.size(); i++) {
			if (savetitle.get(i).contains(str)) {
				int a = saveview.get(i);
				System.out.println((i + 1) + " 번 게시물");
				System.out.println(savetitle.get(i));
				System.out.println("작성자 : 익명");
				System.out.println("등록 날짜 : " + savedate.get(i));
				System.out.println("조회수 : " + (a));
				line();
			}
		}
	}
	
	void line() {
		System.out.println("=====================");
	}

}
