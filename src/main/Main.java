package main;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean programon = true;
		boolean logon = false;
		Scanner sc = new Scanner(System.in);
		String cmd;
		saveboard sv = new saveboard();
		resister rs = new resister();
		String user = null;
		
		sv.testdata();
		System.out.println("게시판 프로그램을 시작합니다.");
		while (programon) {
			
			if (logon) {
				System.out.print("명령어를 입력하세요. : ");
				cmd = sc.nextLine();
				if (cmd.equals("exit")) {
					System.out.println("프로그램을 종료합니다.");
					programon = false;
				}else if (cmd.equals("add")) {
					sv.add(user);
				}else if (cmd.equals("list")) {
					sv.list();
				}else if (cmd.equals("read")) {
					sv.view(user);
				}else if (cmd.equals("update")) {
					sv.update();
				}else if (cmd.equals("delete")) {
					sv.delete();
				}else if (cmd.equals("search")) {
					System.out.print("검색 항목을 선택해주세요 (1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자) : ");
					sv.setSkey(Integer.parseInt(sc.nextLine()));
					System.out.println(sv.getSkey() + "번을 선택하셨습니다.");
					System.out.print("검색 키워드를 입력해주세요 : ");
					sv.search(sc.nextLine());
				}else {
					System.out.println("알 수 없는 명령어입니다.");
				}
			}else {
				System.out.print("1.로그인, 2.회원가입, 3.종료 : ");
				cmd = sc.nextLine();
				if (cmd.equals("3")) {
					System.out.println("프로그램을 종료합니다.");
					programon = false;
				}else if (cmd.equals("2")) {
					rs.resister();
				}else if (cmd.equals("1")) {
					user = null;
					while(user == null) {						
						user = rs.login();
					}
					logon = true;
				}
			}
		}

	}

}
