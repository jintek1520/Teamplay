package com.naver;

import java.util.Scanner;

public class CommandLogin {


	public MemberDTO execute(Scanner sc) {
		System.out.println("ID�� �Է����ּ���");
		String id = sc.nextLine();
		System.out.println("PASSWORD�� �Է����ּ���.");
		String password = sc.nextLine();
		MemberDTO indto = new MemberDTO(id, password, null, 0, null, null);
		MemberDAO dao = new MemberDAO();
		MemberDTO outdto = dao.selectbyidpassword(indto);
		if(outdto.getName()==null) {
			System.out.println("ID�� PASSWORD�� Ȯ�����ּ���.");
			return null;
		}else {
			return outdto;			
		}
	}

}
