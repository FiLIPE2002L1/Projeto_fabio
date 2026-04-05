package algorithms;

import model.Aula;
import java.util.*;

public class DynamicProgrammingSolver {

    public int resolver(Aula[] aulas) {

        int n = aulas.length;

        int[] inicios = new int[n];
        int[] fins = new int[n];

        for (int i = 0; i < n; i++) {
            inicios[i] = aulas[i].getInicio();
            fins[i] = aulas[i].getFim();
        }

        Arrays.sort(inicios);
        Arrays.sort(fins);

        int i = 0, j = 0;
        int salasAtivas = 0;
        int maxSalas = 0;

        while (i < n && j < n) {

            if (inicios[i] < fins[j]) {
                salasAtivas++;
                maxSalas = Math.max(maxSalas, salasAtivas);
                i++;
            } else {
                salasAtivas--;
                j++;
            }
        }

        return maxSalas;
    }
}