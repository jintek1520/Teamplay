package kr.co.ezen;

import java.util.List;
import java.util.Scanner;

import com.naver.Command;
import com.naver.CommandLogin;
import com.naver.DB;
import com.naver.HeroDAO;
import com.naver.MemberDAO;
import com.naver.MonsterDAO;
import com.naver.WeaponDAO;

public class MainEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DB db = new DB();
		List<Command> cmdlist = db.cmdlist();
		MemberDAO memdao =new MemberDAO();
		HeroDAO hdao = new HeroDAO();
		WeaponDAO wdao = new WeaponDAO();
		MonsterDAO mondao = new MonsterDAO();
		CommandLogin cmdl = new CommandLogin();
		boolean isok = true;
		int menu = 0;
		
		while(isok) {
			System.out.println("매뉴를 선택해주세요.");
			for (int i = 0; i < cmdlist.size(); i++) {
				if (i==0) System.out.print("1.로그인  ");
				System.out.print(cmdlist.get(i));
			}
			menu = db.intpick();
			if (menu == 1) cmdl.execute(sc);
			cmdlist.get(menu).execute(sc);
			break;
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}
	
	
	
}
