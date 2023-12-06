package Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.ClienteController;
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
	
				default:
					break;
			}
		}
	}
	
}
