package Menu.repository;

import Menu.model.Item_Menu;

public interface Repository {

	// CRUD da conta
	public void procura(String cpf); // Busca um cadastro pelo CPF

	public void lista(); // Lista todos os cadastros

	public void cadastra(Item_Menu registration); // Cadastra um novo usuário

	public void atualiza(String cpf, Item_Menu updateRegistration); // Atualiza um cadastro existente

	public void deleta(String cpf); // Deleta um cadastro pelo CPF

	// Métodos

	public void register(String consultation, int number); // asssindando o metod de operações


}
