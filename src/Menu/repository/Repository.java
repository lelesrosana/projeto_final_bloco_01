package Menu.repository;

import Menu.model.Item_Menu;

public interface Repository {

	// CRUD da conta
	public void quest(String cpf); 
	public void listAll();
	public void register(Item_Menu registration); 
	public void toUpdate(String cpf, Item_Menu updateRegistration);
	public void delet(String cpf); 

	// Métodos

	//public void registerDiary(String cpf);
	void register(String cpf);



}
