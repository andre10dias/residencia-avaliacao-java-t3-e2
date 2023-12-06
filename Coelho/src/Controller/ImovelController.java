package Controller;

import java.util.List;
import java.util.Scanner;

import Models.Cliente;
import Models.Imovel;
import Services.ClienteService;
import Services.ImovelService;

public class ImovelController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void cadastrarImovel() {
		System.out.println("\n======================== Cadastrar imóvel ========================");
		
		System.out.print("\nMatrícula: ");
		String matricula = entrada.nextLine();
		
		System.out.print("\nEndereço: ");
		String endereco = entrada.nextLine();
		
		Imovel imovel = new Imovel(matricula, endereco);
		ImovelService.addImovel(imovel);
	}
	
	public static void listarImoveis() {
		System.out.println("\n======================== Listar imóvel ========================\n");
		
		List<Imovel> imoveis = ImovelService.getImoveis();
		if (!imoveis.isEmpty()) {
			System.out.println("Matrícula \t Endereço");
			System.out.println("-------------------");
			for (Imovel imovel : imoveis) {
				System.out.println(imovel.toString());
			}
		}
	}
	
}
