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
	
	void resister() {
		System.out.print("사용할 아이디를 입력해주세요 : ");
		id.add(sc.nextLine());
		System.out.print("사용할 비밀번호를 입력해주세요 : ");
		pw.add(sc.nextLine());
		System.out.print("사용할 이름을 입력해주세요 : ");
		user.add(sc.nextLine());
		System.out.println("회원가입이 완료되었습니다.");
	}

	String login() {
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
