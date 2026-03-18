package algorithms;

import java.util.Scanner;
import model.Aula;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Aula[] aulas = new Aula[n];

        for (int i = 0; i < n; i++) {

            int inicio = sc.nextInt();
            int fim = sc.nextInt();

            aulas[i] = new Aula(inicio, fim);
        }

        System.out.println("Backtracking:");

        BacktrackingSolver backtracking = new BacktrackingSolver();

        long inicioBack = System.nanoTime();

        backtracking.resolver(aulas);

        long fimBack = System.nanoTime();

        double tempoBack = (fimBack - inicioBack) / 1_000_000_000.0;

        System.out.printf("Tempo: %.6f segundos\n", tempoBack);


        System.out.println("\nBranch and Bound:");

        BranchBoundSolver branchBound = new BranchBoundSolver();

        long inicioBB = System.nanoTime();

        branchBound.resolver(aulas);

        long fimBB = System.nanoTime();

        double tempoBB = (fimBB - inicioBB) / 1_000_000_000.0;

        System.out.printf("Tempo: %.6f segundos\n", tempoBB);

        sc.close();
    }
}
