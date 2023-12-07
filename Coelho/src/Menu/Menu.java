package Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.ClienteController;
import Controller.ImovelController;
import Controller.FaturaController;
import Utils.MenuUtil;

public class Menu {
	
	public static void menuCliente() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastrar", "[ 2 ] Listar"));
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
				case 3:
					ClienteController.removerCliente();
					break;
				case 4:
					ClienteController.alterarCliente();
					break;
				case 5:
					ClienteController.buscarCliente();
					break;
				
	
				default:
					break;
			}
		}
	}
	
	public static void menuImovel() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastrar", "[ 2 ] Listar"));
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
	
				default:
					break;
			}
		}
	}

	public static void menuFatura() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastrar", "[ 2 ] Listar"));
		int opcao;
		
		while (true) {
			MenuUtil.montaMenu(itens, "Menu Faturas");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					FaturaController.cadastrarFatura();
					break;
				case 2:
					FaturaController.novaLeitura();
					break;
				default:
					break;
			}
		}
	}
	
}
