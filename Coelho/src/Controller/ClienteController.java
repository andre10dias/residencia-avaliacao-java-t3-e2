package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Models.Cliente;
import Models.Imovel;
import Services.ClienteService;
import Services.ImovelService;

public class ClienteController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void cadastrarCliente() {		
		System.out.println("\n======================== Cadastrar cliente ========================");
		
		if (!ImovelService.getImoveis().isEmpty()) {	
			List<Imovel> imoveis = new ArrayList<>();
			
			System.out.print("\nNome: ");
			String nome = entrada.nextLine();
			
			System.out.print("\nCPF: ");
			String cpf = entrada.nextLine();
			
			Imovel imovel = Menu.menuSelecionarImovel();
			imoveis.add(imovel);
			
			Cliente cliente = new Cliente(nome, cpf);
			cliente.setImoveis(imoveis);
			
			ClienteService.addCliente(cliente);
		}
		else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}
	
	public static void listarClientes() {
		System.out.println("\n======================== Listar cliente ========================\n");
		
		List<Cliente> clientes = ClienteService.getClientes();
		if (!clientes.isEmpty()) {
			System.out.println("CPF \t\t Nome");
			System.out.println("-----------------------");
			
			for (Cliente cliente : clientes) {
				System.out.println(cliente.toString());
			}
		}
		else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}

}
