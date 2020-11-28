package com.naver;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandInsertMember implements Command{

	Scanner se = new Scanner(System.in);
	@Override
	public void execute(Scanner sc) {
		int age=0 ;
		int year=0;
		int month=0 ;
		int day=0 ;
		System.out.println("사용하실 ID를 입력해주세요.");
		String id = sc.nextLine();
		System.out.println("사용하실 비밀번호를 입력해주세요.");
		String password = sc.nextLine();
		System.out.println("성함을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("현재 나이를 입력해주세요.");
		age = num();
		System.out.println("출생년도를 입력해주세요.");
		year = num();
		System.out.println("출생월을 입력해주세요.");
		month = num();
		System.out.println("출생일을 입력해주세요.");
		day = num();
		Date birth = new Date(year-1900, month-1, day);
		MemberDAO dao = new MemberDAO();
		List<MemberDAO> list = new ArrayList<MemberDAO>();
//		list = dao.select();
		int newnum = list.size();
		String nes = String.format("%02d", newnum);
		String userhero ="m"+nes;
		MemberDTO dto = new MemberDTO(id, password, name, age, birth,userhero);
//		dao.insert(dto);
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
		return "2.회원가입  ,";
	}
	
	
	
	
}
