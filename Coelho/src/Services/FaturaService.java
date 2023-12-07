package Services;

import Models.Fatura;
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
        
        public static void removeFatura(Fatura f) {
            faturas.remove(f);
        }
    
        public static void alterarFatura(Fatura f) {
            faturas.set(faturas.indexOf(f), f);
        }
    
}
