package Person;

public class Student extends Person{

	private String major;

	public Student(String name, Gender gender, String phone, String major) {
		
		super(name, gender, phone);
		this.major = major;

	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Student [name : " + this.getName() + " phone : " + this.getPhone() + " major : " + major;
	}
	
}
