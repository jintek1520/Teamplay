package com.naver;

import java.sql.Date;
import java.util.Scanner;

public class CommandUpdateMember implements Command{
	Scanner se = new Scanner(System.in);
	@Override
	public void execute(Scanner sc) {
		System.out.println("ID를 입력해주세요");
		String id = sc.nextLine();
		System.out.println("PASSWORD를 입력해주세요.");
		String password = sc.nextLine();
		MemberDTO indto = new MemberDTO(id, password, null, 0, null, null);
		MemberDAO dao = new MemberDAO();
		MemberDTO outdto = dao.selectbyidpassword(indto);
		if(outdto.getName() == null) {
			System.out.println("ID 와 PASSWORD를 확인해주세요.");
			return;
		}
		System.out.println("수정할 부분을 골라주세요.");
		System.out.println("1.ID  2.PASSWORD  3.이름  4.나이  5.생일");
		int sct = 0;
		sct = num();
		MemberDTO newdto = new MemberDTO();
		switch (sct) {
		case 1:
			System.out.println("ID 수정 시작");
			System.out.println("새로운 ID를 입력해주세요.");
			String newid = sc.nextLine();
			newdto= new MemberDTO(newid, outdto.getPassword(), outdto.getName(), outdto.getAge(), outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 2:
			System.out.println("PASSWORD 수정 시작");
			System.out.println("새로운 PASSWORD를 입력해주세요.");
			String newps = sc.nextLine();
			newdto= new MemberDTO(outdto.getId(), newps, outdto.getName(), outdto.getAge(), outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 3:
			System.out.println("이름 수정 시작");
			System.out.println("새로운 이름을 입력해주세요.");
			String newname = sc.nextLine();
			newdto= new MemberDTO(outdto.getId(), outdto.getPassword(), newname, outdto.getAge(), outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 4:
			System.out.println("나이 수정 시작");
			System.out.println("새로운 나이를 입력해주세요.");
			int newage = 0;
			newdto= new MemberDTO(outdto.getId(), outdto.getPassword(), outdto.getName(), newage, outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 5:
			int year = 0; 
			int month = 0;
			int day = 0;
			System.out.println("생일 수정 시작");
			System.out.println("출생년도를 입력해주세요.");
			year = num();
			System.out.println("출생월을 입력해주세요.");
			month = num();
			System.out.println("출생일을 입력해주세요.");
			day = num();
			Date birth = new Date(year-1900, month-1, day);
			newdto= new MemberDTO(outdto.getId(), outdto.getPassword(), outdto.getName(),outdto.getAge(), birth, outdto.getUserhero());
//			dao.update(newdto);
			break;
			
		default:
			System.out.println("1~5사이의 숫자만 입력해주세요.");
			break;
		}
		
		System.out.println("수정 완료");
		
	}
	private int num() {
		int a = 0;
		while(true) {
			try {
				a = se.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력해 주세요");
			} finally {			
				se.nextLine();
			}
	}
		return a;
	}
	@Override
	public String toString() {
		return "4.정보수정  ,";
	}

}
