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
            api.compartilharPost(conteudo.getTexto());
            String id = "LI-" + System.currentTimeMillis();
            return new Publicacao(id, "LinkedIn", conteudo.getTexto());
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao postar no LinkedInAdapter", e);
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) throws MidiaSocialException {
        try {
            String rawStats = api.getMetricas(idPublicacao);
            return new Estatisticas("LinkedIn", rawStats);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao obter estatísticas do LinkedIn", e);
        }
    }
}
