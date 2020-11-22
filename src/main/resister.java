package main;

import java.util.ArrayList;
import java.util.Scanner;

public class resister {
	
	Scanner sc = new Scanner(System.in);

	private ArrayList<String> user = new ArrayList<>();
	private ArrayList<String> id = new ArrayList<>();
	private ArrayList<String> pw = new ArrayList<>();
	private String ID;
	private String PW;
	private String USER;
	private String str;
	private boolean pass;
	
	void signup() {
		while (true) {
			System.out.print("사용할 아이디를 입력해주세요 : ");
			str = sc.nextLine();
			for (int i = 0; i < user.size(); i++) {
				if (id.get(i).equals(str)) {
					pass = false;
				}
			}
			if (pass) {			
				id.add(str);
				break;
			}else {
				System.out.println("중복되는 아이디입니다.");
			}
		}
		while (true) {
			System.out.print("사용할 아이디를 입력해주세요 : ");
			str = sc.nextLine();
			for (int i = 0; i < user.size(); i++) {
				if (pw.get(i).equals(str)) {
					pass = false;
				}
			}
			if (pass) {			
				pw.add(str);
				break;
			}else {
				System.out.println("중복되는 비밀번호입니다.");
			}
		}
		while (true) {
			System.out.print("사용할 아이디를 입력해주세요 : ");
			str = sc.nextLine();
			for (int i = 0; i < user.size(); i++) {
				if (user.get(i).equals(str)) {
					pass = false;
				}
			}
			if (pass) {			
				user.add(str);
				break;
			}else {
				System.out.println("중복되는 닉네임입니다.");
			}
		}
		System.out.println("회원가입이 완료되었습니다.");
	}
	
	void testMember() {
		id.add("test");
		pw.add("test");
		user.add("test");
	}

	String signin() {
		boolean pass = false;
		int code = 0;
		System.out.print("아이디를 입력하세요 : ");
		ID = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		PW = sc.nextLine();
		for (int i = 0; i < user.size(); i++) {
			if (id.get(i).equals(ID)) {
				if (pw.get(i).equals(PW)) {
					pass = true;
					code = i;
					break;
				}
			}
		}
		if (pass) {			
			System.out.println("안녕하세요! " + user.get(code) + "님!");
			return user.get(code);
		}else {
			System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
			return null;
		}
	}

}
