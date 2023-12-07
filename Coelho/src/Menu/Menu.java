package Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.ClienteController;
import Controller.FaturaController;
import Controller.ImovelController;
import Controller.PagamentoController;
import Models.Cliente;
import Models.Fatura;
import Models.Imovel;
import Services.ClienteService;
import Services.FaturaService;
import Services.ImovelService;
import Utils.MenuUtil;

public class Menu {
	
	public static void menuPrincipal() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Imóvel", "[ 2 ] Cliente"));
		int opcao;
		
		if (!ImovelService.getImoveis().isEmpty() && !ClienteService.getClientes().isEmpty()) {
			itens.add("[ 3 ] Fatura");
		}
		
		if (!FaturaService.getFaturas().isEmpty()) {
			itens.add("[ 4 ] Pagamento");
		}
		
		itens.add("[ 0 ] Sair");
		
		do {
			MenuUtil.montaMenu(itens, "Empresa de Distribuição de Energia COELHO");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					menuImovel();
					break;
					
				case 2:
					menuCliente();
					break;
					
				case 3:
					menuFatura();
					break;
					
				case 0:
					System.out.println("\nFinalizando programa...");
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	public static void menuCliente() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastrar", "[ 2 ] Listar", "[ 0 ] Sair"));
		int opcao;
		
		while (true) {
			MenuUtil.montaMenu(itens, "Menu Clientes");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					ClienteController.cadastrarCliente();
					break;
					
				case 2:
					ClienteController.listarClientes();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		}
	}
	
	public static void menuImovel() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastrar", "[ 2 ] Listar", "[ 0 ] Sair"));
		int opcao;
		
		while (true) {
			MenuUtil.montaMenu(itens, "Menu Imóveis");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					ImovelController.cadastrarImovel();
					break;
					
				case 2:
					ImovelController.listarImoveis();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		}
	}
	
	public static void menuFatura() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Realizar leitura", "[ 2 ] Listar todas ", "[ 3 ] Listar quitadas ", "[ 0 ] Sair"
		));
		int opcao;
		
		while (true) {
			MenuUtil.montaMenu(itens, "Menu Fatura");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					FaturaController.realizarLeitura();
					break;
					
				case 2:
					FaturaController.listarFaturas(false);
					break;
					
				case 3:
					FaturaController.listarFaturas(true);
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		}
	}
	
	public static void menuPagamento() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Realizar pagamento", "[ 2 ] Listar todos", "[ 3 ] Consultar pagamento de fatura", "[ 0 ] Sair"
		));
		int opcao;
		
		while (true) {
			MenuUtil.montaMenu(itens, "Menu Fatura");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					PagamentoController.realizarPagamento();
					break;
					
				case 2:
					PagamentoController.listarTodos();
					break;
					
				case 3:
					PagamentoController.consultarPagFatura();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		}
	}
	
	public static Cliente menuSelecionarCliente() {
		List<Cliente> clientes = ClienteService.getClientes();
		Cliente cliente = null;
		
		if (!clientes.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < clientes.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + clientes.get(i).getCpf() + "\t" + clientes.get(i).getNome());
			}
			
			System.out.println("Clientes cadastrados:");
			System.out.println("\nNome \t\t CPF ");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			cliente = clientes.get(opcao-1);
		}
		
		return cliente;
	}
	
	public static Imovel menuSelecionarImovel(List<Imovel> imoveis) {
		Imovel imovel = null;
		
		if (!imoveis.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < imoveis.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + imoveis.get(i).getMatricula());
			}
			
			System.out.println("\nMatrículas dos imíveis cadastrados:");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			imovel = imoveis.get(opcao-1);
		}
		
		return imovel;
	}
	
	public static Fatura menuSelecionarFatura(List<Fatura> faturas) {
		Fatura fatura = null;
		
		if (!faturas.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < faturas.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + faturas.get(i).getDataEmissao() 
						+ "\t" + faturas.get(i).getValorCalculado() + "\t" + faturas.get(i).isQuitada());
			}
			
			System.out.println("Faturas em aberto:");
			System.out.println("Data Emissão \t Valor \t\t Quitada");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			fatura = faturas.get(opcao-1);
		}
		
		return fatura;
	}
	
}
