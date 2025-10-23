package midiaSocial.core;

import midiaSocial.models.Publicacao;

public class RespostaUnificada {

    private boolean sucesso;
    private String mensagem;
    private Publicacao publicacao;

    public RespostaUnificada(boolean sucesso, String mensagem) {

        this(sucesso, mensagem, null);

    }

    public RespostaUnificada(boolean sucesso, String mensagem, Publicacao publicacao) {

        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.publicacao = publicacao;

    }

    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public Publicacao getPublicacao() { return publicacao; }
    
}
