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

    public static void listarFaturas() {
        System.out.println("\n======================== Listar faturas ========================\n");

        for (Fatura fatura : FaturaService.getFaturas()) {
            System.out.println(fatura.toString());
        }
    }

    public static void listarFaturasEmAberto() {
        System.out.println("\n======================== Listar faturas em aberto ========================\n");

        for (Fatura fatura : FaturaService.getFaturas()) {
            if (!fatura.isQuitada()) {
                System.out.println(fatura.toString());
            }
        }
    }

    


    
}
