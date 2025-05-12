import java.util.HashMap;
import java.util.Map;

public class ModaEstatistica {
    public static int moda(int[] lista) {
        Map<Integer, Integer> contagem = new HashMap<>();
        
        for (int num : lista) {
            contagem.put(num, contagem.getOrDefault(num, 0) + 1);
        }
        
        int moda = lista[0]; // A moda começa com o primeiro número
        int maxFreq = 0;     // Frequência máxima começa como 0
        
        for (Map.Entry<Integer, Integer> entry : contagem.entrySet()) {
            if (entry.getValue() > maxFreq) {
                moda = entry.getKey();
                maxFreq = entry.getValue();
            }
        }    
        return moda;
    }
    public static void main(String[] args) {
        int[] lista1 = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9};
        
        int moda1 = moda(lista1);
        System.out.println("A moda é: " + moda1);  
    }
}
