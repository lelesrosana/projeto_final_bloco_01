package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import Menu.controller.Controller;
import Menu.model.Item_Menu;
import Menu.util.Cores;

public class Menu {
	private static final Item_Menu String = null;

	public static void main(String[] args) {
		Controller controller = new Controller();
		Scanner read = new Scanner(System.in);

		String userName, motherName, cpf = null, phoneNumber, address;
		int userAge, option;

		do {
			clearScreen();
			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_WHITE_BACKGROUND

					+ "...................................................................");
			System.out.println(".                                                                 .");
			System.out.println(".                     Sistema Unico de Saúde                      .");
			System.out.println(".                                                                 .");
			System.out.println("...................................................................");
			System.out.println(".                    1 - Gerar cadastro                           .");
			System.out.println(".                    2 - Listar todos os cadastros                .");
			System.out.println(".                    3 - Buscar cadastro                          .");
			System.out.println(".                    4 - Atualizar dados                          .");
			System.out.println(".                    5 - Apagar cadastro                          .");
			System.out.println(".                    6 - Agendar consulta                         .");
			System.out.println(".                    7 - Sair                                     .");
			System.out.println("...................................................................");
			System.out.println(".                                                                 .");
			System.out.println(".Escolha uma opção:                                               .");
			System.out
					.println(".                                                                 ." + Cores.TEXT_RESET);

			try {
				option = read.nextInt();
				read.nextLine(); // limpar buffer
			} catch (InputMismatchException e) {
				System.out.println("Digite apenas números inteiros!");
				read.nextLine();
				option = 0;
			}

			clearScreen();

			switch (option) {
			case 1:
				System.out.print("Digite o CPF: ");
				cpf = read.nextLine();
				if (controller.buscarNaCollection(cpf) != null) {
					System.out.println("Cadastro já existe.");
				} else {
					System.out.print("Nome do Titular: ");
					userName = read.nextLine();
					System.out.print("Idade: ");
					userAge = read.nextInt();
					read.nextLine();
					System.out.print("Nome da Mãe: ");
					motherName = read.nextLine();
					System.out.print("Número de telefone: ");
					phoneNumber = read.nextLine();
					System.out.print("Endereço: ");
					address = read.nextLine();

					Item_Menu novo = new Item_Menu(userName, motherName, userAge, cpf, phoneNumber, address);
					controller.register(novo);
				}
				KeyPress(read);
				break;

			case 2:
				controller.listAll();
				KeyPress(read);
				break;

			case 3:
				System.out.print("Informe o CPF: ");
				cpf = read.nextLine();
				controller.quest(cpf);
				KeyPress(read);
				break;

			case 4:
				System.out.print("\n\nInforme o CPF para atualizar: ");
				cpf = read.nextLine();
				if (controller.buscarNaCollection(cpf) != null) {
					System.out.print("Novo Nome: ");
					userName = read.nextLine();
					System.out.print("Nova Idade: ");
					userAge = read.nextInt();
					read.nextLine();
					System.out.print("Nome da Mãe: ");
					motherName = read.nextLine();
					System.out.print("Número de telefone: ");
					phoneNumber = read.nextLine();
					System.out.print("Endereço: ");
					address = read.nextLine();

					Item_Menu atualizado = new Item_Menu(userName, motherName, userAge, cpf, phoneNumber, address);
					controller.toUpdate(cpf, atualizado);
				} else {
					System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\n\nCPF não encontrado."
							+ Cores.TEXT_RESET);
				}
				KeyPress(read);
				break;

			case 5:
				System.out.print("\n\nInforme o CPF para deletar: ");
				cpf = read.nextLine();
				controller.delet(cpf);
				KeyPress(read);
				break;

			case 6:
				System.out.print("\n\nInforme o CPF para agendar consulta: ");
				cpf = read.nextLine();
				controller.register(cpf);
				KeyPress(read);
				break;

			case 7:
				System.out.println("\n\nEncerrando o programa.");
				break;

			default:
				System.out.println(
						Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND + "\n\nOpção inválida!" + Cores.TEXT_RESET);
				KeyPress(read);
				break;
			}

		} while (option != 7);
		clearScreen();
		System.out.println("\n\nAtendimento finalizado.\n\n\n");
		read.close();
		sobre();
	}

	public static void KeyPress(Scanner read) {
		System.out.println("\nPressione Enter para continuar.");
		read.nextLine();
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND
				+ "...................................................................");
		System.out.println(".  Projeto Desenvolvido por:                                      .");
		System.out.println(".  Rosana da Cruz Leles Ferreira                                  .");
		System.out.println(".  https://github.com/lelesrosana / E-mail: lelesrosana@gmail.com .");
		System.out.println("...................................................................");
	}
}
