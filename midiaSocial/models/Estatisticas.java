package midiaSocial.models;

public class Estatisticas {

    private int curtidas;
    private int comentarios;
    private int compartilhamentos;

    public Estatisticas(int curtidas, int comentarios, int compartilhamentos) {

        this.curtidas = curtidas;
        this.comentarios = comentarios;
        this.compartilhamentos = compartilhamentos;

    }

    public int getCurtidas() { return curtidas; }
    public int getComentarios() { return comentarios; }
    public int getCompartilhamentos() { return compartilhamentos; }
    
}

