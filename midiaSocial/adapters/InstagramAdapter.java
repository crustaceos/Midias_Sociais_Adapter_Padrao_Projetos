package midiaSocial.adapters;

import midiaSocial.apis.InstagramAPI;
import midiaSocial.core.MidiaSocial;
import midiaSocial.core.exceptions.MidiaSocialException;
import midiaSocial.models.*;

public class InstagramAdapter implements MidiaSocial {

    private final InstagramAPI api;

    public InstagramAdapter(InstagramAPI api) {

        this.api = api;

    }

    @Override
    public Publicacao postar(Conteudo conteudo) throws MidiaSocialException {

        try {
            String raw = api.publicarImagem(conteudo.getTexto(), conteudo.getImagemUrl());

            String id = "IG-" + Math.abs(raw.hashCode());
            
            return new Publicacao(id, "instagram", raw);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro no InstagramAdapter", e);
        }

    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) throws MidiaSocialException {
        try {
            return new Estatisticas(50, 10, 5);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro obtendo estatísticas Instagram", e);
        }
    }
}
