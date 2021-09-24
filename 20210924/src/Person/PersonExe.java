package Person;

import java.util.Scanner;

public class PersonExe {

	public static Scanner sc = new Scanner(System.in);
	private static PersonExe singleton = new PersonExe();

	private Person[] people;

	private PersonExe() {
		people = new Person[100];
		people[0] = new Person("ȫ�浿", Gender.MEN , "1111-2222");
		people[1] = new Person("���ڹ�", Gender.MEN , "3333-2222");
		people[2] = new Person("��Ģ��", Gender.WOMEN , "7777-8888");
		people[3] = new Person("������", Gender.WOMEN , "1111-7777");
		people[4] = new Student("�ֿ�", Gender.WOMEN ,"2345-1234", "���а�");
		people[5] = new Worker("��ö��",Gender.WOMEN , "1234-5678", "������");
		
	}

	public static PersonExe getInstance() {
		return singleton;
	}

	public void execute() {
		while (true) {
			System.out.println("------------------");
			System.out.println("1.�߰� 2.��ȸ 3.���� 4.���� 5.����");
			System.out.println("----------------------");

			int menu = PersonExe.readInt("�޴��� �����ϼ���");
			if (menu == 1) {
				System.out.println("[���]");
				addPerson();
			} else if (menu == 2) {
				System.out.println("[��ȸ]");
				showList();
			} else if (menu == 3) {
				System.out.println("[����]");
				modify();
			} else if (menu == 4) {
				System.out.println("[����]");
				delete();
			} else if (menu == 5) {
				System.out.println("�����մϴ�.");
				break;
			} else
				System.out.println("�߸��Է��߽��ϴ�.");

		}}

	

	private void addPerson() {
		System.out.println("1.���� 2.���� 3.����");
		int choice = PersonExe.readInt("�޴� ����");
		Person person = null;

		String name = PersonExe.readStr("�̸� �Է�");
		Gender gender = gender();
		String phone = PersonExe.readStr("����ó �Է�");

		if (choice == 1) {

			person = new Person(name, gender, phone);

		} else if (choice == 2) {
			String major = PersonExe.readStr("�����Է�");
			person = new Student(name, gender, phone, major);

		} else if (choice == 3) {
			String depart = PersonExe.readStr("�μ��Է�");
			person = new Worker(name, gender, phone, depart);
		}
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null) {
				people[i] = person;
				break;
			}
		}
		System.out.println("��ϿϷ�.");
	}

	private void showList() {

		String name = readStr("��ȸ�� �̸� �Է�");
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

		System.out.println("[���]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());

			int num = PersonExe.readInt("��ȣ�� �����ϼ���");
			String phone = PersonExe.readStr("������ ��ȭ��ȣ�� �Է��ϼ���");
			if (!phone.equals("")) {
				people[num].setPhone(phone);
			}

			if (people[num] instanceof Student) {
				String major = PersonExe.readStr("�ٲ� ������ �Է��ϼ���");
				if (!major.equals("")) {
					((Student) people[num]).setMajor(major);
				}

			} else if (people[num] instanceof Worker) {
				String depart = PersonExe.readStr("�ٲ� �μ��� �Է��ϼ���");
				if (!depart.equals(""))
					((Worker) people[num]).setDepart(depart);
			}
			System.out.println("�����Ϸ�.");

		}
	}

	private void delete() {
		System.out.println("[���]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = PersonExe.readInt("������ ��ȣ�� �����ϼ���.");
		if (people[num] != null) {
			people[num] = null;
			System.out.println("�����Ϸ�.");
		} else {
			System.out.println("������ �����ϴ�.");
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
		System.out.println("���� �Է�");
		String str = sc.nextLine();

		if (str.equals("����")) {
			return Gender.MEN;

		} else if (str.equals("����")) {
			return Gender.WOMEN;
		}
		return null;

	}
}
