package Menu.controller;

import Menu.model.Item_Menu;
import Menu.repository.Repository;
import Menu.util.Cores;

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
			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\nCadastro com CPF " + cpf
					+ " não encontrado." + Cores.TEXT_RESET);
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
			System.out.println(
					Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\nNenhum cadastro encontrado." + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND
					+ "\nNão foi possível atualizar: CPF não encontrado." + Cores.TEXT_RESET);
		}
	}

	@Override
	public void delet(String cpf) {
		Item_Menu existente = buscarNaCollection(cpf);
		if (existente != null) {
			registrationList.remove(existente);
			System.out.println(
					Cores.TEXT_GREEN + "\nCadastro com CPF " + cpf + " removido com sucesso." + Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\nCadastro com CPF " + cpf + " não encontrado." + Cores.TEXT_RESET);
		}
	}

	@Override
	public void register(String cpf) {
		Item_Menu existente = buscarNaCollection(cpf);
		System.out.println("Avaliando se o cadastro existe: ");
		int passoword = 0;
		if (existente != null) {
			System.out.println(Cores.TEXT_GREEN + "\n\nCadastro encontrado!" + Cores.TEXT_RESET);
			passoword = registrationList.size();
			System.out.println(Cores.TEXT_GREEN + "\n\nSua senha é: " + (passoword++)
					+ "\nPor favor, aguarde ser chamado." + Cores.TEXT_RESET);
			// registerOrdenation.add(existente);
		} else {
			System.out.println(
					Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\n\nCadastro não encontrado! Realize o cadastramento." + Cores.TEXT_RESET);
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
