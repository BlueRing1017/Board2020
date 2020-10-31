package main;

import java.util.ArrayList;
import java.util.Scanner;

public class saveboard {
	private ArrayList<String> savetitle = new ArrayList<>();
	private ArrayList<String> savetext = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private String title;
	private String text;
	private int size = 0;
	
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
	
	void view(int num) {
		line();
		System.out.println("제목 : " + savetitle.get(num));
		System.out.println("");
		System.out.println(savetext.get(num));
		line();
	}
	
	void line() {
		System.out.println("====================");
	}

}
