package Menu.model;

public abstract class Item_Menu {

	private String userName;
	private String motherName;
	private int userAge;
	private String cpf;
	private String phoneNumber;
	private String address;
//	private String viewRegistration;

	public Item_Menu(String userName, String motherName, int userAge, String cpf, String phoneNumber, String address) {

		this.userName = userName;
		this.motherName = motherName;
		this.userAge = userAge;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.address = address;
		// this.viewRegistration = viewRegistration;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setViewRegistration() {

		System.out.println("\n\n" + ".....................................................");
		System.out.println(".         Dados da conta:                           .");
		System.out.println(".....................................................");
		System.out.println("Nome do usuário: " + this.userName);
		System.out.println("Nome da mãe: " + this.motherName);
		System.out.println("Idade: " + this.userAge);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Número de telefone: " + this.phoneNumber);
		System.out.println("Endereço: " + this.address);

	}
}
