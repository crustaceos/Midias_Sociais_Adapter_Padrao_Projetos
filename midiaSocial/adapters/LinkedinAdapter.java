package midiaSocial.adapters;

import midiaSocial.apis.LinkedinAPI;
import midiaSocial.core.MidiaSocial;
import midiaSocial.core.exceptions.MidiaSocialException;
import midiaSocial.models.Conteudo;
import midiaSocial.models.Publicacao;
import midiaSocial.models.Estatisticas;

public class LinkedinAdapter implements MidiaSocial {

    private final LinkedinAPI api;

    public LinkedinAdapter(LinkedinAPI api) {

        this.api = api;

    }

    @Override
    public Publicacao postar(Conteudo conteudo) throws MidiaSocialException {
        try {
            //A API do linkedin espera receber um texto para ser compartilhado como post
            String retorno = api.compartilharPost(conteudo.getTexto());

            String id = "LI-" + System.currentTimeMillis();
            return new Publicacao(id, "LinkedIn", retorno);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao postar no LinkedinAdapter", e);
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
    
        return new Estatisticas(200, 50, 15);
        
    }
}

