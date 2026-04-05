package model;

public class Aula {

    private int id;
    private int inicio;
    private int fim;

    public Aula(int id, int inicio, int fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getId() {
        return id;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }
}