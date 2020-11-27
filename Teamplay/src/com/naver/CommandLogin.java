package com.naver;

import java.util.Scanner;

public class CommandLogin {


	public MemberDTO execute(Scanner sc) {
		System.out.println("ID를 입력해주세요");
		String id = sc.nextLine();
		System.out.println("PASSWORD를 입력해주세요.");
		String password = sc.nextLine();
		MemberDTO indto = new MemberDTO(id, password, null, 0, null, null);
		MemberDAO dao = new MemberDAO();
		MemberDTO outdto = dao.selectbyidpassword(indto);
		if(outdto.getName()==null) {
			System.out.println("ID와 PASSWORD를 확인해주세요.");
			return null;
		}else {
			return outdto;			
		}
	}

}
