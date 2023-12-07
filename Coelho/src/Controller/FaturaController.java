package Controller;

import java.util.Scanner;

import Models.Fatura;
import Models.Imovel;
import Services.FaturaService;

public class FaturaController {

    private static Scanner entrada = new Scanner(System.in);

    public static void cadastrarFatura() {
        System.out.println("\n======================== Cadastrar fatura ========================");

        System.out.print("\nMatrícula do imóvel: ");
        String matricula = entrada.nextLine();
        var imovel = ImovelController.getImovelByMatricula(matricula);

        System.out.print("\nLeitura atual: ");
        int leituraAtual = entrada.nextInt();
        Fatura fatura = new Fatura(imovel, leituraAtual);
        FaturaService.addFatura(fatura);
    }

    public static void novaLeitura() {
        System.out.println("\n======================== Nova leitura ========================");

        System.out.print("\nMatrícula do imóvel: ");
        String matricula = entrada.nextLine();
        var imovel = ImovelController.getImovelByMatricula(matricula);

        System.out.print("\nLeitura atual: ");
        int leituraAtual = entrada.nextInt();
        Fatura fatura = FaturaService.getFaturaByImovel(imovel);
        FaturaService.novaLeitura(fatura, leituraAtual);
    }

    


    
}
