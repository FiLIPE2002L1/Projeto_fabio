package algorithms;

import java.util.Scanner;
import model.Aula;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite inicialmente o número de aulas, seguido do horário (início e fim) de cada uma delas:");

        int n = sc.nextInt();

        Aula[] aulas = new Aula[n];

        for (int i = 0; i < n; i++) {

            int inicio = sc.nextInt();
            int fim = sc.nextInt();

            aulas[i] = new Aula(i, inicio, fim); 
        }

        // ---------------- BACKTRACKING ----------------
        System.out.println("Backtracking:");

        BacktrackingSolver backtracking = new BacktrackingSolver();

        long inicioBack = System.nanoTime();

        backtracking.resolver(aulas);

        long fimBack = System.nanoTime();

        double tempoBack = (fimBack - inicioBack) / 1_000_000_000.0;

        System.out.printf("Tempo: %.6f segundos\n", tempoBack);


        // ---------------- BRANCH AND BOUND ----------------
        System.out.println("\nBranch and Bound:");

        BranchBoundSolver branchBound = new BranchBoundSolver();

        long inicioBB = System.nanoTime();

        branchBound.resolver(aulas);

        long fimBB = System.nanoTime();

        double tempoBB = (fimBB - inicioBB) / 1_000_000_000.0;

        System.out.printf("Tempo: %.6f segundos\n", tempoBB);


        // ---------------- GREEDY ----------------
        System.out.println("\nGreedy:");

        GreedySolver greedy = new GreedySolver();

        long inicioGreedy = System.nanoTime();

        Resultado resultadoGreedy = greedy.resolver(aulas);

        long fimGreedy = System.nanoTime();

        double tempoGreedy = (fimGreedy - inicioGreedy) / 1_000_000_000.0;

        System.out.println(resultadoGreedy.getSalas());

        int[] alocacao = resultadoGreedy.getAlocacao();
        for (int i = 0; i < alocacao.length; i++) {
            System.out.println((i + 1) + " " + alocacao[i]);
        }

        System.out.printf("Tempo: %.6f segundos\n", tempoGreedy);


        // ---------------- PROGRAMAÇÃO DINÂMICA ----------------
        System.out.println("\nProgramação Dinâmica:");

        DynamicProgrammingSolver dpSolver = new DynamicProgrammingSolver();

        long inicioDP = System.nanoTime();

        int salasDP = dpSolver.resolver(aulas);

        long fimDP = System.nanoTime();

        double tempoDP = (fimDP - inicioDP) / 1_000_000_000.0;

        System.out.println("Número mínimo de salas usadas: " + salasDP);

        System.out.printf("Tempo: %.6f segundos\n", tempoDP);

        sc.close();
    }
}