package algorithms;

public class Resultado {

    private int salas;
    private int[] alocacao;

    public Resultado(int salas, int[] alocacao) {
        this.salas = salas;
        this.alocacao = alocacao;
    }

    public int getSalas() {
        return salas;
    }

    public int[] getAlocacao() {
        return alocacao;
    }
}