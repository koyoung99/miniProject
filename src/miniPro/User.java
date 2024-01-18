package miniPro;

public class User {
	String name;
	String hp;
	String company;

	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}

	public void showInfo() {
		System.out.println(name + "\t" + hp + "\t" + company);
	}

}
