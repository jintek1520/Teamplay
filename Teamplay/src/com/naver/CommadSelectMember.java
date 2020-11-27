package com.naver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommadSelectMember implements Command{

	@Override
	public void execute(Scanner sc) {
		List<MemberDTO> dto = new ArrayList<MemberDTO>();
		for (int i = 0; i < dto.size(); i++) {
			System.out.println(dto.get(i));
		}
	}

	@Override
	public String toString() {
		return "3.회원조회  ,";
	}

}
