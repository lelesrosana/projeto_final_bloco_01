package Menu.model;

import java.util.Scanner;

public class Service extends Item_Menu {
	Scanner read = new Scanner(System.in);
	private String consultation;

	public Service(String userName, String motherName, int userAge, String cpf, String phoneNumber, String address) {
		super(userName, motherName, userAge, cpf, phoneNumber, address);

		this.consultation = cpf; // Armazena o CPF novamente, mas isso é opcional
	}

	public String getConfere() {
		return consultation;
	}

	public void setConfere(String confere) {
		this.consultation = confere;
	}

	public boolean register(String consultation) {
		System.out.println("Avaliar se a consulta existe: ");
		consultation = read.nextLine(); // Captura a entrada do usuário

		if (getCpf().equals(consultation)) {
			System.out.println("Cadastro encontrado!");
			return true;
		} else {
			System.out.println("Cadastro não encontrado! Realize o cadastramento.");
			return false;
		}
	}

}
