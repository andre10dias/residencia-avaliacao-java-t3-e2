package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Imovel;
import Models.Falha;

public class FalhaService {
    
    private static List<Falha> falhas;
    
    public static List<Falha> getFalhas() {
        if (falhas == null) {
            falhas = new ArrayList<>(); 
        }
        
        return falhas;
    }
    
    public static void addFalha(Falha f) {
        if (falhas == null) {
            falhas = new ArrayList<>();
        }
        
        falhas.add(f);
    }
    
    
    public static List<Falha> getFalhas(Imovel imovel){
        List<Falha> falhasImovel = new ArrayList<>();
        
        for (Falha falha : getFalhas()) {
            if (falha.getImovelAssociado().equals(imovel)) {
                falhasImovel.add(falha);
            }
        }
        
        return falhasImovel;
    }
    
    public static Falha cadastrarFalha(String descricao, String tipo, Imovel imovel) {
        Falha f = new Falha(descricao, tipo, imovel);
        addFalha(f);
        
        return f;
    }



}
