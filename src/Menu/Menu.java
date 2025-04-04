package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Menu.controller.Controller;
import Menu.model.Item_Menu;
import Menu.model.Service;

public class Menu {
	public static void main(String[] args) {
		Controller Item = new Controller();
		Scanner read = new Scanner(System.in);

		// teste da Classe Item_Manu

		// Item_Menu test = new Item_Menu ("Luciana da Cruz", "Amélia da Cruz", 30,
		// "45855229231", "11254147645", "Rua Das Flores");

		// Service test01 = new Service ("Giovanna da Cruz", "Luciana da Cruz", 7,
		// "1234567892",
		// "14578523654", "Rua das Flores");

		int option;

		System.out.println(".....................................................");
		System.out.println(".                                                   .");
		System.out.println(".                Sistema Unico de Saúde             .");
		System.out.println(".                                                   .");
		System.out.println(".....................................................");
		System.out.println(".                                                   .");
		System.out.println(".         1 - Gerar cadastro                        .");
		System.out.println(".         2 - Listar todos os agendamentos          .");
		System.out.println(".         3 - Buscar cadastro                       .");
		System.out.println(".         4 - Atualizar dados                       .");
		System.out.println(".         5 - Apagar cadastro                       .");
		System.out.println(".         6 - Agendar consulta                      .");
		System.out.println(".         7 - Finalizar atendimento                 .");
		System.out.println(".                                                   .");
		System.out.println(".....................................................");
		System.out.println(".         Entre com a opção desejada:               .");
		System.out.println(".....................................................");

		
		try {
		option = read.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Digite valores inteiros!");
			read.nextLine();
			option = 0;

		}
		
		
		
		do {
			clearScreen();
			System.out.println(
					"        Bem vindo ao Sistema Único de Saúde" + "\n        Se cuidar é sempre a melhor opção!\n\n");
			about();

			switch (option) {
			case 1:
				System.out.println("Gerar cadastro:");
				//

				break;
			case 2:
				System.out.println("Listar todos os agendamentos:");
				System.out.println("");
				Item.procura(null);
				KeyPress();
				break;
			case 3:
				System.out.println("Buscar cadastro:");
				System.out.println("");
				break;
			case 4:
				System.out.println("Atualizar dados:");
				break;
			case 5:
				System.out.println("Apagar cadastro:");
				break;
			case 6:
				System.out.println("Agendar consulta:");
				break;
			case 7:
				System.out.println("Atendimento finalizado.");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente: ");
				break;
			}
			option = read.nextInt();
		} while (option != 7);

	}

	private static void KeyPress() {
		// TODO Auto-generated method stub
		
	}

	public static void about() {
		System.out.println(".....................................................");
		System.out.println(".                                                   .");
		System.out.println(".  Projeto desenvolvido por: Rosana C. L. Ferreira  .");
		System.out.println(".     E-mail: lelesrosana@gmail.com                 .");
		System.out.println(".     GitHub: https://github.com/lelesrosana        .");
		System.out.println(".                                                   .");
		System.out.println(".....................................................");
		System.out.println("                                                     ");
		System.out.println("                                                     ");
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}

	}
}
