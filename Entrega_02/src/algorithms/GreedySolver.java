package algorithms;

import model.Aula;
import java.util.*;

public class GreedySolver {

    public Resultado resolver(Aula[] aulas) {

        int n = aulas.length;

        Aula[] copia = aulas.clone();

        Arrays.sort(copia, Comparator.comparingInt(Aula::getInicio));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] alocacao = new int[n];
        int salas = 0;

        for (Aula aula : copia) {

            if (!pq.isEmpty() && pq.peek()[0] <= aula.getInicio()) {

                int[] sala = pq.poll();

                alocacao[aula.getId()] = sala[1];

                pq.add(new int[]{aula.getFim(), sala[1]});

            } else {

                salas++;
                alocacao[aula.getId()] = salas;

                pq.add(new int[]{aula.getFim(), salas});
            }
        }

        return new Resultado(salas, alocacao);
    }
}
