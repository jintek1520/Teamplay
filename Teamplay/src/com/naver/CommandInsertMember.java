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
		System.out.println("����Ͻ� ID�� �Է����ּ���.");
		String id = sc.nextLine();
		System.out.println("����Ͻ� ��й�ȣ�� �Է����ּ���.");
		String password = sc.nextLine();
		System.out.println("������ �Է����ּ���.");
		String name = sc.nextLine();
		System.out.println("���� ���̸� �Է����ּ���.");
		age = num();
		System.out.println("����⵵�� �Է����ּ���.");
		year = num();
		System.out.println("������� �Է����ּ���.");
		month = num();
		System.out.println("������� �Է����ּ���.");
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
				System.out.println("���ڸ� �Է��� �ּ���");
			} finally {			
				se.nextLine();
			}
	}
		return a;
	}
	@Override
	public String toString() {
		return "2.ȸ������  ,";
	}
	
	
	
	
}
