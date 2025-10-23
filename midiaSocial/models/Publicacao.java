package midiaSocial.models;

public class Publicacao {

    private String id;
    private String plataforma;
    private String conteudo;

    public Publicacao(String id, String plataforma, String conteudo) {

        this.id = id;
        this.plataforma = plataforma;
        this.conteudo = conteudo;

    }

    public String getId() { return id; }
    public String getPlataforma() { return plataforma; }
    public String getConteudo() { return conteudo; }
}
