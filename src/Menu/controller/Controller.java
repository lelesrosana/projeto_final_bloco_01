package Menu.controller;

import Menu.model.Item_Menu;
import Menu.repository.Repository;

import java.util.ArrayList;

public class Controller implements Repository {

	private ArrayList<Item_Menu> registrationList = new ArrayList<>();

	@Override
	public void cadastra(Item_Menu registration) {
		registrationList.add(registration);
		System.out.println("\nCadastro realizado com sucesso para: " + registration.getUserName());
	}

	@Override
	public void lista() {
		if (registrationList.isEmpty()) {
			System.out.println("\nNenhum cadastro encontrado.");
		} else {
			for (Item_Menu item : registrationList) {
				item.setViewRegistration();
			}
		}
	}

	@Override
	public void procura(String cpf) {
		Item_Menu found = buscarNaCollection(cpf);
		if (found != null) {
			found.setViewRegistration();
		} else {
			System.out.println("\nCadastro com CPF " + cpf + " não encontrado.");
		}
	}

	@Override
	public void atualiza(String cpf, Item_Menu updateRegistration) {
		Item_Menu existente = buscarNaCollection(cpf);
		if (existente != null) {
			int index = registrationList.indexOf(existente);
			registrationList.set(index, updateRegistration);
			System.out.println("\nCadastro atualizado com sucesso!");
		} else {
			System.out.println("\nNão foi possível atualizar: CPF não encontrado.");
		}
	}

	@Override
	public void deleta(String cpf) {
		Item_Menu existente = buscarNaCollection(cpf);
		if (existente != null) {
			registrationList.remove(existente);
			System.out.println("\nCadastro com CPF " + cpf + " removido com sucesso.");
		} else {
			System.out.println("\nCadastro com CPF " + cpf + " não encontrado.");
		}
	}

	@Override
	public void cadastro(String consulta) {
		Item_Menu existente = buscarNaCollection(consulta);
		System.out.println("Avaliar se a consulta existe: ");
		if (existente != null) {
			System.out.println("Cadastro encontrado!");
		} else {
			System.out.println("Cadastro não encontrado! Realize o cadastramento.");
		}
	}

	private Item_Menu buscarNaCollection(String cpf) {
		for (Item_Menu item : registrationList) {
			if (item.getCpf().equals(cpf)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public void register(String consultation, int number) {
		// TODO Auto-generated method stub

	}
}
