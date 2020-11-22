package main;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import main.Main;

public class saveboard {
	Calendar cal = Calendar.getInstance();

	private ArrayList<String> savetitle = new ArrayList<>();
	private ArrayList<String> savetext = new ArrayList<>();
	private ArrayList<String> savedate = new ArrayList<>();
	private ArrayList<String> savewriter = new ArrayList<>();
	private ArrayList<Integer> saveview = new ArrayList<>();
	private ArrayList<comments> savecomment = new ArrayList<>();
	private ArrayList<Integer> savecommentcount = new ArrayList<>();
	private ArrayList<likes> savelike = new ArrayList<>();
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
	private int skey;
	private int dkey;
	private String cmt;
	private String lh;
	private String ad;

	void add(String writer) {
		System.out.print("게시물 제목을 입력해주세요 : ");
		title = sc.nextLine();
		System.out.print("게시물 내용을 입력해주세요 : ");
		text = sc.nextLine();
		savetitle.add(title);
		savetext.add(text);
		savewriter.add(writer);
		String year = Integer.toString(cal.get(YEAR));
		String month = Integer.toString(cal.get(MONTH) + 1);
		String date = Integer.toString(cal.get(DATE));
		savedate.add(year + "." + month + "." + date);
		saveview.add(0);
		savecomment.add(new comments());
		savelike.add(new likes());
		savecommentcount.add(0);
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
			savewriter.add("익명");
			String year = Integer.toString(cal.get(YEAR));
			String month = Integer.toString(cal.get(MONTH) + 1);
			String date = Integer.toString(cal.get(DATE));
			savedate.add(year + "." + month + "." + date);
			saveview.add(0);
			savecomment.add(new comments());
			savelike.add(new likes());
			savecommentcount.add(0);
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
			System.out.println("작성자 : " + savewriter.get(i));
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
		System.out.println("작성자 : " + savewriter.get(num));
		System.out.println("등록 날짜 : " + savedate.get(num));
		System.out.println("조회수 : " + (a + 1));
		System.out.println(savetext.get(num));
		line();
		System.out.println("-------댓글-------");
		for (int i = 0; i < savecommentcount.get(num); i++) {
			for (int j = 0; j < savecomment.get(i).getSavecommentoftext().size(); j++) {
				System.out.println("내용 : " + savecomment.get(i).getText(j));
				System.out.println("작성일 : " + savecomment.get(i).getDate(j));
				System.out.println("작성자 : " + savecomment.get(i).getWriter(j));
				System.out.println("-----------------");
			}
		}
	}

	void sort() {
		System.out.print("정렬 대상을 선택해주세요. (like : 좋아요, hit : 조회수) :");
		lh = sc.nextLine();
		System.out.print("정렬 방법을 선택해주세요. (asc : 오름차순, desc : 내림차순) :");
		ad = sc.nextLine();
		ArrayList<Integer> rank = new ArrayList<>();
		int num = 0;
		if (lh.equals("hit")) {
			for (int i = 0; i < savetitle.size(); i++) {
				if (i == 1) {
					rank.add(i);
				} else {
					for (int j = 0; j < rank.size(); j++) {
						if (saveview.get(j) <= saveview.get(i)) {
							num++;
						}
					}
					rank.add((rank.size() - num), saveview.get(i));
				}
			}
		}else if (lh.equals("like")) {
			for (int i = 0; i < savetitle.size(); i++) {
				if (i == 1) {
					rank.add(i);
				} else {
					for (int j = 0; j < rank.size(); j++) {
						if (savelike.get(j).savelikes.size() <= savelike.get(i).savelikes.size()) {
							num++;
						}
					}
					rank.add((rank.size() - num), saveview.get(i));
				}
			}
		}
		if (ad.equals("desc")) {
			line();
			for (int i = 0; i < rank.size(); i++) {
				int a = rank.get(i);
				System.out.println((a + 1) + " 번 게시물");
				System.out.println(rank.get(a));
				System.out.println("작성자 : " + savewriter.get(a));
				System.out.println("등록 날짜 : " + savedate.get(a));
				System.out.println("조회수 : " + saveview.get(a));
				line();
			}
		} else if (ad.equals("asc")) {
			line();
			for (int i = rank.size(); i < 0; i--) {
				int a = rank.get(i);
				System.out.println((a + 1) + " 번 게시물");
				System.out.println(rank.get(a));
				System.out.println("작성자 : " + savewriter.get(a));
				System.out.println("등록 날짜 : " + savedate.get(a));
				System.out.println("조회수 : " + saveview.get(a));
				line();
			}
		}
	}

	void view(String a) {
		int size = getSize();
		if (size < 1) {
			System.out.println("게시물이 하나도 없습니다. 게시물을 작성한 후 열람해 주세요.");
		} else {
			System.out.print("열람할 게시물의 번호를 입력해주세요 : ");
			viewstr = sc.nextLine();
			viewnum = Integer.parseInt(viewstr) - 1;
			if (viewnum > size - 1) {
				System.out.println("너무 큰 숫자입니다. ( 현재 " + size + "개의 게시물 존재 )");
			} else {
				viewprint(viewnum);
				details(viewnum, a);
			}
		}
	}

	void details(int a, String b) {
		System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
		dkey = Integer.parseInt(sc.nextLine());
		switch (dkey) {
		case 1:
			if (Main.logon) {
				comment(a, b);
			} else {
				System.out.println("로그인 후 이용해주세요.");
			}
			break;
		case 2:
			if (Main.logon) {
				like(a, b);
			} else {
				System.out.println("로그인 후 이용해주세요.");
			}
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		case 5:
			dkey = 0;
			break;
		}
		if (dkey != 0) {
			details(a, b);
		}
	}

	void comment(int a, String b) {
		System.out.print("댓글 내용을 입력해주세요 : ");
		cmt = sc.nextLine();
		savecomment.get(a).setText(cmt);
		savecomment.get(a).setDate();
		savecomment.get(a).setWriter(b);
		savecommentcount.set(a, savecommentcount.get(a) + 1);
	}

	void like(int num, String user) {
		savelike.get(num).setLike(user);
	}

	void update() {
		int size = getSize();
		if (size < 1) {
			System.out.println("게시물이 하나도 없습니다. 게시물을 작성한 후 수정해 주세요.");
		} else {
			System.out.print("수정할 게시물의 번호를 입력해주세요 : ");
			updatestr = sc.nextLine();
			updatenum = Integer.parseInt(updatestr) - 1;
			if (updatenum > size - 1) {
				System.out.println("너무 큰 숫자입니다. ( 현재 " + size + "개의 게시물 존재 )");
			} else {
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
		} else {
			System.out.print("삭제할 게시물의 번호를 입력해주세요 : ");
			removestr = sc.nextLine();
			removenum = Integer.parseInt(removestr) - 1;
			if (removenum > size - 1) {
				System.out.println("너무 큰 숫자입니다. ( 현재 " + size + "개의 게시물 존재 )");
			} else {
				System.out.println(removestr + "번의 게시물을 삭제합니다. ( 현재 " + (size - 1) + "개의 게시물 존재 )");
				savetitle.remove(removenum);
				savetext.remove(removenum);
				size--;
			}
		}
	}

	void search(String str) {
		line();
		switch (skey) {
		case 1:
			for (int i = 0; i < savetitle.size(); i++) {
				if (savetitle.get(i).contains(str)) {
					int a = saveview.get(i);
					System.out.println((i + 1) + " 번 게시물");
					System.out.println(savetitle.get(i));
					System.out.println("작성자 : " + savewriter.get(i));
					System.out.println("등록 날짜 : " + savedate.get(i));
					System.out.println("조회수 : " + (a));
					line();
				}
			}
			break;
		case 2:
			for (int i = 0; i < savetitle.size(); i++) {
				if (savetext.get(i).contains(str)) {
					int a = saveview.get(i);
					System.out.println((i + 1) + " 번 게시물");
					System.out.println(savetitle.get(i));
					System.out.println("작성자 : " + savewriter.get(i));
					System.out.println("등록 날짜 : " + savedate.get(i));
					System.out.println("조회수 : " + (a));
					line();
				}
			}
			break;
		case 3:
			for (int i = 0; i < savetitle.size(); i++) {
				if (savetitle.get(i).contains(str) | savetext.get(i).contains(str)) {
					int a = saveview.get(i);
					System.out.println((i + 1) + " 번 게시물");
					System.out.println(savetitle.get(i));
					System.out.println("작성자 : " + savewriter.get(i));
					System.out.println("등록 날짜 : " + savedate.get(i));
					System.out.println("조회수 : " + (a));
					line();
				}
			}
			break;
		case 4:
			for (int i = 0; i < savetitle.size(); i++) {
				if (savewriter.get(i).contains(str)) {
					int a = saveview.get(i);
					System.out.println((i + 1) + " 번 게시물");
					System.out.println(savetitle.get(i));
					System.out.println("작성자 : " + savewriter.get(i));
					System.out.println("등록 날짜 : " + savedate.get(i));
					System.out.println("조회수 : " + (a));
					line();
				}
			}
			break;
		}
	}

	public int getSkey() {
		return skey;
	}

	public void setSkey(int skey) {
		this.skey = skey;
	}

	void line() {
		System.out.println("=====================");
	}

}

class comments {
	Calendar cal = Calendar.getInstance();
	private ArrayList<String> savecommentoftext = new ArrayList<>();
	private ArrayList<String> savecommentofdate = new ArrayList<>();
	private ArrayList<String> savecommentofwriter = new ArrayList<>();

	void setText(String text) {
		savecommentoftext.add(text);
	}

	void setDate() {
		String year = Integer.toString(cal.get(YEAR));
		String month = Integer.toString(cal.get(MONTH) + 1);
		String date = Integer.toString(cal.get(DATE));
		savecommentofdate.add(year + "." + month + "." + date);
	}

	void setWriter(String text) {
		savecommentofwriter.add(text);
	}

	String getText(int a) {
		return savecommentoftext.get(a);
	}

	String getDate(int a) {
		return savecommentofdate.get(a);
	}

	String getWriter(int a) {
		return savecommentofwriter.get(a);
	}

	public ArrayList<String> getSavecommentoftext() {
		return savecommentoftext;
	}

	public void setSavecommentoftext(ArrayList<String> savecommentoftext) {
		this.savecommentoftext = savecommentoftext;
	}
}

class likes {

	ArrayList<String> savelikes = new ArrayList<>();
	private boolean pass = true;

	void setLike(String user) {
		for (int i = 0; i < savelikes.size(); i++) {
			if (savelikes.get(i).equals(user)) {
				savelikes.remove(i);
				System.out.println("이 게시물의 좋아요를 취소하였습니다.");
				pass = false;
				break;
			}
		}
		if (pass) {
			savelikes.add(user);
			System.out.println("이 게시물을 좋아합니다.");
		}
		pass = true;
	}
}