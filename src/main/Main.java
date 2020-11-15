package main;

import java.util.Date;
import java.util.Scanner;

public class Main {
	public static boolean logon = false;

	public static void main(String[] args) {

		boolean programon = true;
		Scanner sc = new Scanner(System.in);
		String cmd;
		saveboard sv = new saveboard();
		resister rs = new resister();
		String user = null;

		sv.testdata();
		System.out.println("게시판 프로그램을 시작합니다.");
		while (programon) {

			System.out.print("명령어를 입력하세요. : ");
			cmd = sc.nextLine();
			if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				programon = false;
			} else if (cmd.equals("article add")) {
				if (logon) {					
					sv.add(user);
				}else {
					System.out.println("로그인 후 이용해주세요.");
				}
			} else if (cmd.equals("article list")) {
				sv.list();
			} else if (cmd.equals("article read")) {
				sv.view(user);
			} else if (cmd.equals("article update")) {
				sv.update();
			} else if (cmd.equals("article delete")) {
				sv.delete();
			} else if (cmd.equals("article search")) {
				System.out.print("검색 항목을 선택해주세요 (1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자) : ");
				sv.setSkey(Integer.parseInt(sc.nextLine()));
				System.out.println(sv.getSkey() + "번을 선택하셨습니다.");
				System.out.print("검색 키워드를 입력해주세요 : ");
				sv.search(sc.nextLine());
			} else if (cmd.equals("member signup")) {
				rs.signup();
			} else if (cmd.equals("member signin")) {
				user = null;
				while (user == null) {
					user = rs.signin();
				}
				logon = true;
			} else if (cmd.equals("member signout")) {
				logon = false;
				user = null;
			} else {
				System.out.println("알 수 없는 명령어입니다.");
			}
			
		}
		
	}
	
	

}
