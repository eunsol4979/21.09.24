package Person;

public class Worker extends Person {


	private String depart;
	
	public Worker(String name,  Gender gender, String phone, String depart) {
		super(name, gender, phone);
		this.depart = depart;
		
		
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	
	
	}

	@Override
	public String toString() {
		return "Worker [name : " + this.getName() + " phone : " + this.getPhone() +" depart : " + depart + "]";
	}
	 
}
