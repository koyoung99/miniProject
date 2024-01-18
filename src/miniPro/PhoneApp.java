package miniPro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		ArrayList aList = new ArrayList();

		InputStream in = new FileInputStream("C:\\javaStudy\\PhoneDB_원본.txt");
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("*************************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("*************************************");

		boolean stop = true;

		while (stop) {

			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5. 종료");
			System.out.println("---------------------------------------");
			System.out.print(">메뉴번호:");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				while (true) {
					String str = br.readLine();

					if (str == null) {
						break;
					}
					String[] personInfo = str.split(",");
					String name = personInfo[0];
					String hp = personInfo[1];
					String company = personInfo[2];

					User user = new User(name, hp, company);

					aList.add(user);
				}

				for (int i = 0; i < aList.size(); i++) {
					System.out.print((i + 1) + ".   ");
					((User) aList.get(i)).showInfo();
				}

				System.out.println();
				break;

			case 2:
				System.out.println("<2.등록>");
				System.out.print(">이름:");
				String name = sc.next();
				System.out.print(">휴대전화:");
				String hp = sc.next();
				System.out.print(">회사전화:");
				String company = sc.next();
				System.out.println("[등록되었습니다.]");

				User user = new User(name, hp, company);
				aList.add(user);
				break;

			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				int number = sc.nextInt();
				for (int i = 0; i < aList.size(); i++) {
					if ((i + 1) == number) {
						aList.remove(i);
					}
				}
				System.out.println("[삭제되었습니다.]");
				break;

			case 4:
				System.out.println("<4.검색>");
				System.out.print("이름: ");
				String find = sc.next();
				User us1 = new User(find);
				for (int i = 0; i < aList.size(); i++) {
					if (((User) aList.get(i)).getName().contains(find)) {
						System.out.print((i + 1) + ".   ");
						((User) aList.get(i)).showInfo();
					}
				}
				break;

			case 5:
				System.out.println("*************************************");
				System.out.println("*             감사합니다.            *");
				System.out.println("*************************************");
				stop = false;
				break;

			default:
				System.out.println("[다시입력해주세요.]");
				break;
			}
		}

		br.close();
	}
}
