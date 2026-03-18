package algorithms;

import model.Aula;
import util.ConflitoUtil;

public class BranchBoundSolver {

    private int melhorSalas = Integer.MAX_VALUE;
    private int[] melhorSolucao;
    private int podas = 0;

    public void resolver(Aula[] aulas) {

        int[] salas = new int[aulas.length];

        branchBound(aulas, salas, 0, 0);

        imprimirResultado();
    }

    private void branchBound(Aula[] aulas, int[] salas, int aulaAtual, int salasUsadas) {

        if (salasUsadas >= melhorSalas) {
            podas++;
            return;
        }

        if (aulaAtual == aulas.length) {

            melhorSalas = salasUsadas;
            melhorSolucao = salas.clone();
            return;
        }

        for (int s = 1; s <= salasUsadas; s++) {

            if (podeColocar(aulas, salas, aulaAtual, s)) {

                salas[aulaAtual] = s;

                branchBound(aulas, salas, aulaAtual + 1, salasUsadas);
            }
        }

        salas[aulaAtual] = salasUsadas + 1;

        branchBound(aulas, salas, aulaAtual + 1, salasUsadas + 1);
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

        System.out.println("Podas: " + podas);
    }
}