import java.util.Scanner;

import model.Aula;
import algorithms.BacktrackingSolver;
import algorithms.BranchBoundSolver;

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
        backtracking.resolver(aulas);

        System.out.println("\nBranch and Bound:");

        BranchBoundSolver branchBound = new BranchBoundSolver();
        branchBound.resolver(aulas);
    }
}