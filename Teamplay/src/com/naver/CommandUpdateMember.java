package com.naver;

import java.sql.Date;
import java.util.Scanner;

public class CommandUpdateMember implements Command{
	Scanner se = new Scanner(System.in);
	@Override
	public void execute(Scanner sc) {
		System.out.println("ID�� �Է����ּ���");
		String id = sc.nextLine();
		System.out.println("PASSWORD�� �Է����ּ���.");
		String password = sc.nextLine();
		MemberDTO indto = new MemberDTO(id, password, null, 0, null, null);
		MemberDAO dao = new MemberDAO();
		MemberDTO outdto = dao.selectbyidpassword(indto);
		if(outdto.getName() == null) {
			System.out.println("ID �� PASSWORD�� Ȯ�����ּ���.");
			return;
		}
		System.out.println("������ �κ��� ����ּ���.");
		System.out.println("1.ID  2.PASSWORD  3.�̸�  4.����  5.����");
		int sct = 0;
		sct = num();
		MemberDTO newdto = new MemberDTO();
		switch (sct) {
		case 1:
			System.out.println("ID ���� ����");
			System.out.println("���ο� ID�� �Է����ּ���.");
			String newid = sc.nextLine();
			newdto= new MemberDTO(newid, outdto.getPassword(), outdto.getName(), outdto.getAge(), outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 2:
			System.out.println("PASSWORD ���� ����");
			System.out.println("���ο� PASSWORD�� �Է����ּ���.");
			String newps = sc.nextLine();
			newdto= new MemberDTO(outdto.getId(), newps, outdto.getName(), outdto.getAge(), outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 3:
			System.out.println("�̸� ���� ����");
			System.out.println("���ο� �̸��� �Է����ּ���.");
			String newname = sc.nextLine();
			newdto= new MemberDTO(outdto.getId(), outdto.getPassword(), newname, outdto.getAge(), outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 4:
			System.out.println("���� ���� ����");
			System.out.println("���ο� ���̸� �Է����ּ���.");
			int newage = 0;
			newdto= new MemberDTO(outdto.getId(), outdto.getPassword(), outdto.getName(), newage, outdto.getBirth(), outdto.getUserhero());
//			dao.update(newdto);
			break;
		case 5:
			int year = 0; 
			int month = 0;
			int day = 0;
			System.out.println("���� ���� ����");
			System.out.println("����⵵�� �Է����ּ���.");
			year = num();
			System.out.println("������� �Է����ּ���.");
			month = num();
			System.out.println("������� �Է����ּ���.");
			day = num();
			Date birth = new Date(year-1900, month-1, day);
			newdto= new MemberDTO(outdto.getId(), outdto.getPassword(), outdto.getName(),outdto.getAge(), birth, outdto.getUserhero());
//			dao.update(newdto);
			break;
			
		default:
			System.out.println("1~5������ ���ڸ� �Է����ּ���.");
			break;
		}
		
		System.out.println("���� �Ϸ�");
		
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
		return "4.��������  ,";
	}

}
