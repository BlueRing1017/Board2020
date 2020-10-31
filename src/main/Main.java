package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean programon = true;
		Scanner sc = new Scanner(System.in);
		String cmd;
		String viewstr;
		int viewnum;
		saveboard sv = new saveboard();
		
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
			}else if (cmd.equals("view")) {
				int i = sv.getSize();
				if (i < 1) {
					System.out.println("게시물이 하나도 없습니다. 게시물을 작성한 후 열람해 주세요.");
				}else {
					System.out.print("열람할 게시물의 번호를 입력해주세요 : ");
					viewstr = sc.nextLine();
					viewnum = Integer.parseInt(viewstr) - 1;
					if (viewnum > i - 1) {
						System.out.println("너무 큰 숫자입니다. ( 현재 " + i + "개의 게시물 존재 )");
					}else {				
						System.out.println(viewnum + "번의 게시물을 열람합니다.");
						sv.view(viewnum);
					}
				}
			}else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}

	}

}
