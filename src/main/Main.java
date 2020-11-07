package main;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean programon = true;
		Scanner sc = new Scanner(System.in);
		String cmd;
		saveboard sv = new saveboard();
		
		sv.testdata();
		while (programon == true) {
			System.out.print("명령어를 입력하세요. : ");
			cmd = sc.nextLine();
			
			if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				programon = false;
			}else if (cmd.equals("add")) {
				sv.add();
			}else if (cmd.equals("list")) {
				sv.list();
			}else if (cmd.equals("read")) {
				sv.view();
			}else if (cmd.equals("update")) {
				sv.update();
			}else if (cmd.equals("delete")) {
				sv.delete();
			}else if (cmd.equals("search")) {
				System.out.print("검색 키워드를 입력해주세요 : ");
				sv.search(sc.nextLine());
			}else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}

	}

}
