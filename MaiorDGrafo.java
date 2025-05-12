import java.util.*;

public class MaiorDistanciaGrafo {

    public static int bfs(int[][] grafo, int inicio) {
        int n = grafo.length;
        boolean[] visitado = new boolean[n];
        int[] distancia = new int[n];
        Queue<Integer> fila = new LinkedList<>();
        
        fila.add(inicio);
        visitado[inicio] = true;
        distancia[inicio] = 0;
        
        while (!fila.isEmpty()) {
            int atual = fila.poll();
            
            for (int vizinho = 0; vizinho < n; vizinho++) {
                if (grafo[atual][vizinho] == 1 && !visitado[vizinho]) {
                    visitado[vizinho] = true;
                    distancia[vizinho] = distancia[atual] + 1;
                    fila.add(vizinho);
                }
            }
        }
        
        int maiorDistancia = 0;
        for (int dist : distancia) {
            maiorDistancia = Math.max(maiorDistancia, dist);
        }
      
        return maiorDistancia;
    }
    public static int maiorDistancia(int[][] grafo) {
        int n = grafo.length;
        int maiorDistancia = 0;
        
        for (int i = 0; i < n; i++) {
            maiorDistancia = Math.max(maiorDistancia, bfs(grafo, i));
        }
        
        return maiorDistancia;
    }
    public static void main(String[] args) {
        int[][] grafo_matriz1 = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 1},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0}
        };
       
        int maiorDistancia1 = maiorDistancia(grafo_matriz1);
        System.out.println("A maior distância no grafo é: " + maiorDistancia1); 
    }
}
