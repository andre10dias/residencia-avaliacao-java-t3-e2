package Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.ClienteController;
import Controller.FaturaController;
import Controller.ImovelController;
import Models.Fatura;
import Models.Imovel;
import Services.ClienteService;
import Services.FaturaService;
import Services.ImovelService;
import Utils.MenuUtil;
import Utils.Util;

public class Menu {
	
	public static void menuPrincipal() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Imóvel", "[ 2 ] Cliente"));
		int opcao;
		
		if (!ImovelService.getImoveis().isEmpty() && !ClienteService.getClientes().isEmpty()) {
			itens.add("[ 3 ] Fatura");
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
	
	public static Imovel menuSelecionarImovel() {
		List<Imovel> imoveis = ImovelService.getImoveis();
		Imovel imovel = null;
		
		if (!imoveis.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < imoveis.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + imoveis.get(i).getMatricula());
			}
			
			System.out.println("\nMAtrículas dos imíveis cadastrados: ");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			imovel = imoveis.get(opcao-1);
		}
		
		return imovel;
	}
	
}
