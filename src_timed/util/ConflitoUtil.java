package util;

import model.Aula;

public class ConflitoUtil {

    public static boolean haConflito(Aula a, Aula b) {

        return a.getInicio() < b.getFim() &&
                b.getInicio() < a.getFim();
    }
}
