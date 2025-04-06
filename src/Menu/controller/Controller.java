package Menu.controller;

import Menu.model.Item_Menu;
import Menu.repository.Repository;

import java.util.ArrayList;

public class Controller implements Repository {

	private ArrayList<Item_Menu> registrationList = new ArrayList<>();
	private ArrayList<Item_Menu> registerOrdenation = new ArrayList();
	int numero = 0;

	@Override
	public void quest(String cpf) {
		var found = buscarNaCollection(cpf);

		if (found != null) {
			found.setViewRegistration();
		} else {
			System.out.println("\nCadastro com CPF " + cpf + " não encontrado.");
		}
	}

	@Override
	public void register(Item_Menu registration) {
		registrationList.add(registration);
		System.out.println("\nCadastro realizado com sucesso para: " + registration.getUserName());
	}

	public int gerarNumero() { // metodo auxiliar de cadastrar
		return ++numero;
	}

	@Override
	public void listAll() {
		if (registrationList.isEmpty()) {
			System.out.println("\nNenhum cadastro encontrado.");
		} else {
			for (Item_Menu item : registrationList) {
				item.setViewRegistration();
			}
		}
	}

	@Override
	public void toUpdate(String cpf, Item_Menu updateRegistration) {
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
	public void delet(String cpf) {
		Item_Menu existente = buscarNaCollection(cpf);
		if (existente != null) {
			registrationList.remove(existente);
			System.out.println("\nCadastro com CPF " + cpf + " removido com sucesso.");
		} else {
			System.out.println("\nCadastro com CPF " + cpf + " não encontrado.");
		}
	}

	@Override
	public void register(String cpf) {
		Item_Menu existente = buscarNaCollection(cpf);
		System.out.println("Avaliando se o cadastro existe: ");
		int passoword = 0;
		if (existente != null) {
			System.out.println("\n\nCadastro encontrado!");
			passoword = registrationList.size();
			System.out.println("\n\nSua senha é: " + (passoword++) + "\nPor favor, aguarde ser chamado.");
			//registerOrdenation.add(existente);
		} else {
			System.out.println("\n\nCadastro não encontrado! Realize o cadastramento.");
		}
	}

	public Item_Menu buscarNaCollection(String cpf) {
		for (Item_Menu item : registrationList) {
			if (item.getCpf().equals(cpf)) {
				return item;
			}
		}
		return null;
	}

	// public void registerDiary(String consultation, int senha) {

	// registrationList.add(registrationList.size());

}
