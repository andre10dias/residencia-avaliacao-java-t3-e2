package Controller;

import java.util.List;
import java.util.Scanner;

import Menu.Menu;

import Models.Imovel;
import Models.Falha;
import Services.ImovelService;
import Services.FalhaService; // Add this import statement


public class FalhaController {

    private static Scanner entrada = new Scanner(System.in);

    public static void cadastrarFalha() {
        System.out.println("\n====================== Cadastrar falha ======================");

        Imovel imovelSelecionado = Menu.menuSelecionarImovel(ImovelService.getImoveis());

        if (imovelSelecionado != null) {
            System.out.print("\nDescrição: ");
            String descricao = entrada.nextLine();

            System.out.print("\nTipo: ");
            String tipo = entrada.nextLine();

            Falha falha = new Falha(descricao, tipo, imovelSelecionado);

            System.out.println("\nFalha cadastrada com sucesso!");
        }
        else {
            System.out.println("\nNão existem dados para serem exibidos.");
        }
    }


    public static void listarFalhas() {
        System.out.println("\n======================== Listar falhas ========================");

        List<Falha> falhas = FalhaService.getFalhas();

        if (!falhas.isEmpty()) {
            for (Falha falha : falhas) {
                System.out.println("\nDescrição: " + falha.getDescricao());
                System.out.println("Tipo: " + falha.getTipo());
                System.out.println("Imóvel associado: " + falha.getImovelAssociado().getEndereco());
            }
        }
        else {
            System.out.println("\nNão existem dados para serem exibidos.");
        }
    }
}

     

 

