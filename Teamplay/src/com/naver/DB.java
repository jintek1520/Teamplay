package com.naver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DB {
	Scanner se = new Scanner(System.in);
	
	public List<Command> cmdlist() {
		List<Command> list = new ArrayList<Command>();
		
		list.add(new CommandInsertMember());
		list.add(new CommadSelectMember());
		list.add(new CommandUpdateMember());
		list.add(new CommandDeleteMember());
		list.add(new CommandEnd());
		return list;
	}
	
	public int intpick() {
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
	
}
