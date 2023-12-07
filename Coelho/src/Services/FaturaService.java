package Services;

import Models.Fatura;
import Models.Imovel;
import java.util.ArrayList;
import java.util.List;

public class FaturaService {
        
        private static List<Fatura> faturas;
        
        public static List<Fatura> getFaturas() {
            if (faturas == null) {
                faturas = new ArrayList<>();
            }
            
            return faturas;
        }
        
        public static void addFatura(Fatura f) {
            if (faturas == null) {
                faturas = new ArrayList<>();
            }
            
            faturas.add(f);
        }
          
        public static void alterarFatura(Fatura f) {
            faturas.set(faturas.indexOf(f), f);
        }

        public static void novaLeitura(Fatura f, int leituraAtual) {
            f.setLeituraAnterior(f.getLeituraAtual()); 
            f.setLeituraAtual(leituraAtual);
            f.setValorConsumo(leituraAtual - f.getLeituraAnterior());
            f.setValorCalculado(10 * f.getValorConsumo());
           
        }

        public static Fatura getFaturaByImovel(Imovel imovel) {
            for (Fatura fatura : faturas) {
                if (fatura.getImovel().equals(imovel)) {
                    return fatura;
                }
            }
            return null;
        }
    
}
