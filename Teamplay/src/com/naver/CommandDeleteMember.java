package com.naver;

import java.util.Scanner;

public class CommandDeleteMember implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("ID�� �Է����ּ���");
		String id = sc.nextLine();
		System.out.println("PASSWORD�� �Է����ּ���.");
		String password = sc.nextLine();
		MemberDTO indto = new MemberDTO(id, password, null, 0, null, null);
		MemberDAO dao = new MemberDAO();
//		dao.delete(indto); 	
	}

	@Override
	public String toString() {
		return "5.ȸ��Ż��  ,";
	}

}
