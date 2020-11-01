package main;

import java.util.ArrayList;
import java.util.Scanner;

public class saveboard {
	
	private ArrayList<String> savetitle = new ArrayList<>();
	private ArrayList<String> savetext = new ArrayList<>();
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
		size++;
		System.out.println("게시물이 등록되었습니다.");
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	void list() {
		line();
		for (int i = 0; i < savetitle.size(); i++) {
			System.out.println((i + 1) + " 번 게시물");
			System.out.println(savetitle.get(i));
			line();
		}
	}
	
	void viewprint(int num) {
		line();
		System.out.println("제목 : " + savetitle.get(num));
		System.out.println("");
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
				System.out.println(viewstr + "번의 게시물을 열람합니다.");
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
	
	void line() {
		System.out.println("====================");
	}

}
