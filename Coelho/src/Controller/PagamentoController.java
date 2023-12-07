package Controller;

import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Models.Fatura;
import Models.Imovel;
import Models.Pagamento;
import Services.FaturaService;
import Services.ImovelService;
import Services.PagamentoService;
import Utils.Util;

public class PagamentoController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void realizarPagamento() {
		System.out.println("\n======================== Realizar Pagamento ========================");
		
		//Cliente clienteSelecionado = Menu.menuSelecionarCliente();
		Imovel imovelSelecionado = Menu.menuSelecionarImovel(ImovelService.getImoveis());
		
		List<Fatura> faturasPendentes = FaturaService.getFaturasPendentesByImovel(imovelSelecionado);
		Fatura faturaSelecionada = Menu.menuSelecionarFatura(faturasPendentes);
		
		if (faturaSelecionada != null) {			
			System.out.print("\nValor do pagamento: ");
			int valor = Util.stringToInt(entrada.nextLine());
			
			Pagamento pagamento = new Pagamento(faturaSelecionada, valor);
			
			List<Pagamento> pagamentosAnteriores = PagamentoService.getPagamentosByFatura(faturaSelecionada);
			for (Pagamento p : pagamentosAnteriores) {
				valor += p.getValor();
			}
			
			if (valor == faturaSelecionada.getValorCalculado()) {
				pagamento.getFatura().setQuitada(true);
			}
			else if (valor > pagamento.getFatura().getValorCalculado()) {
				//TODO: Implementar reembolso
			}
		}
		else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
		
	}

	public static void listarTodos() {
		// TODO Auto-generated method stub
		
	}

	public static void consultarPagFatura() {
		// TODO Auto-generated method stub
		
	}

}
