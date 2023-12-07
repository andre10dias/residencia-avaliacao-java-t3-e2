package Controller;

import java.util.List;
import java.util.Scanner;

import Models.Cliente;
import Services.ClienteService;

public class ClienteController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void cadastrarCliente() {
		System.out.println("\n======================== Cadastrar cliente ========================");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		System.out.print("\nCPF: ");
		String cpf = entrada.nextLine();
		
		Cliente cliente = new Cliente(nome, cpf);
		ClienteService.addCliente(cliente);
	}
	
	public static void listarClientes() {
		System.out.println("\n======================== Listar cliente ========================\n");
		
		List<Cliente> clientes = ClienteService.getClientes();
		if (!clientes.isEmpty()) {
			System.out.println("CPF \t\t Nome");
			System.out.println("-------------------");
			for (Cliente cliente : clientes) {
				System.out.println(cliente.toString());
			}
		}
	}

	public static void removerCliente() {
		System.out.println("\n======================== Remover cliente ========================\n");
		System.out.print("\nDigite o CPF do cliente que deseja remover: ");
		String cpf = entrada.nextLine();
		for (Cliente cliente : ClienteService.getClientes()) {
			if (cliente.getCpf().equals(cpf)) {
				ClienteService.removeCliente(cliente);
				System.out.println("Cliente removido com sucesso!");
				return;
			}
			else {
				System.out.println("Cliente não encontrado!");
			}
		}
	}

	public static void alterarCliente() {
		System.out.println("\n======================== Alterar cliente ========================\n");
		System.out.print("\nDigite o CPF do cliente que deseja alterar: ");
		String cpf = entrada.nextLine();
		for (Cliente cliente : ClienteService.getClientes()) {
			if (cliente.getCpf().equals(cpf)) {
				System.out.print("\nDigite o novo nome do cliente: ");
				String nome = entrada.nextLine();
				cliente.setNome(nome);
				System.out.println("Cliente alterado com sucesso!");
				return;
			}
			else {
				System.out.println("Cliente não encontrado!");
			}
		}
	}

}
