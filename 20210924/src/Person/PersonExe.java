package Person;

import java.util.Scanner;

public class PersonExe {

	public static Scanner sc = new Scanner(System.in);
	private static PersonExe singleton = new PersonExe();

	private Person[] people;

	private PersonExe() {
		people = new Person[100];
		people[0] = new Person("홍길동", Gender.MEN , "1111-2222");
		people[1] = new Person("김자반", Gender.MEN , "3333-2222");
		people[2] = new Person("이칙촉", Gender.WOMEN , "7777-8888");
		people[3] = new Person("조은솔", Gender.WOMEN , "1111-7777");
		people[4] = new Student("최영", Gender.WOMEN ,"2345-1234", "수학과");
		people[5] = new Worker("김철수",Gender.WOMEN , "1234-5678", "영업부");
		
	}

	public static PersonExe getInstance() {
		return singleton;
	}

	public void execute() {
		while (true) {
			System.out.println("------------------");
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("----------------------");

			int menu = PersonExe.readInt("메뉴를 선택하세요");
			if (menu == 1) {
				System.out.println("[등록]");
				addPerson();
			} else if (menu == 2) {
				System.out.println("[조회]");
				showList();
			} else if (menu == 3) {
				System.out.println("[수정]");
				modify();
			} else if (menu == 4) {
				System.out.println("[삭제]");
				delete();
			} else if (menu == 5) {
				System.out.println("종료합니다.");
				break;
			} else
				System.out.println("잘못입력했습니다.");

		}}

	

	private void addPerson() {
		System.out.println("1.지인 2.동기 3.동료");
		int choice = PersonExe.readInt("메뉴 선택");
		Person person = null;

		String name = PersonExe.readStr("이름 입력");
		Gender gender = gender();
		String phone = PersonExe.readStr("연락처 입력");

		if (choice == 1) {

			person = new Person(name, gender, phone);

		} else if (choice == 2) {
			String major = PersonExe.readStr("전공입력");
			person = new Student(name, gender, phone, major);

		} else if (choice == 3) {
			String depart = PersonExe.readStr("부서입력");
			person = new Worker(name, gender, phone, depart);
		}
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null) {
				people[i] = person;
				break;
			}
		}
		System.out.println("등록완료.");
	}

	private void showList() {

		String name = readStr("조회할 이름 입력");
		Gender gender = gender();

		for (int i = 0; i < people.length; i++) {
			if (people[i] != null) {

				if (!name.equals("") && !gender.equals("")) {
					if (people[i].getName().indexOf(name) != -1 && people[i].getGender() == gender) {
						System.out.println(people[i].toString());
					}

				} else if (gender==null) {
					if (people[i].getName().indexOf(name) != -1) {
						System.out.println(people[i].toString());
					}

				} else if (!name.equals("")) {
					if (people[i].getGender() == gender) {
						System.out.println(people[i].toString());
					}
				} else {
					System.out.println(people[i].toString());
				}
			}
		} // end of for
	}

	private void modify() {

		System.out.println("[목록]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());

			int num = PersonExe.readInt("번호를 선택하세요");
			String phone = PersonExe.readStr("변경할 전화번호를 입력하세요");
			if (!phone.equals("")) {
				people[num].setPhone(phone);
			}

			if (people[num] instanceof Student) {
				String major = PersonExe.readStr("바꿀 전공을 입력하세요");
				if (!major.equals("")) {
					((Student) people[num]).setMajor(major);
				}

			} else if (people[num] instanceof Worker) {
				String depart = PersonExe.readStr("바꿀 부서를 입력하세요");
				if (!depart.equals(""))
					((Worker) people[num]).setDepart(depart);
			}
			System.out.println("수정완료.");

		}
	}

	private void delete() {
		System.out.println("[목록]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = PersonExe.readInt("삭제할 번호를 선택하세요.");
		if (people[num] != null) {
			people[num] = null;
			System.out.println("삭제완료.");
		} else {
			System.out.println("정보가 없습니다.");
		}
	}

	public static int readInt(String msg) {
		System.out.println(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;

	}

	public static String readStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	public static Gender gender() {
		System.out.println("성별 입력");
		String str = sc.nextLine();

		if (str.equals("남자")) {
			return Gender.MEN;

		} else if (str.equals("여자")) {
			return Gender.WOMEN;
		}
		return null;

	}
}
