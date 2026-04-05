package algorithms;

import model.Aula;
import util.ConflitoUtil;

public class BacktrackingSolver {

    private int melhorSalas = Integer.MAX_VALUE;
    private int[] melhorSolucao;

    public void resolver(Aula[] aulas) {

        int[] salas = new int[aulas.length];

        backtrack(aulas, salas, 0, 0);

        imprimirResultado();
    }

    private void backtrack(Aula[] aulas, int[] salas, int aulaAtual, int salasUsadas) {

        if (aulaAtual == aulas.length) {

            if (salasUsadas < melhorSalas) {
                melhorSalas = salasUsadas;
                melhorSolucao = salas.clone();
            }

            return;
        }

        for (int s = 1; s <= salasUsadas; s++) {

            if (podeColocar(aulas, salas, aulaAtual, s)) {

                salas[aulaAtual] = s;

                backtrack(aulas, salas, aulaAtual + 1, salasUsadas);
            }
        }

        salas[aulaAtual] = salasUsadas + 1;

        backtrack(aulas, salas, aulaAtual + 1, salasUsadas + 1);
    }

    private boolean podeColocar(Aula[] aulas, int[] salas, int aulaAtual, int sala) {

        for (int i = 0; i < aulaAtual; i++) {

            if (salas[i] == sala) {

                if (ConflitoUtil.haConflito(aulas[i], aulas[aulaAtual])) {
                    return false;
                }
            }
        }

        return true;
    }

    private void imprimirResultado() {

        System.out.println(melhorSalas);

        for (int i = 0; i < melhorSolucao.length; i++) {

            System.out.println((i + 1) + " " + melhorSolucao[i]);
        }
    }
}
