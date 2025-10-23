package midiaSocial.adapters;

import midiaSocial.apis.TiktokAPI;
import midiaSocial.core.MidiaSocial;
import midiaSocial.core.exceptions.MidiaSocialException;
import midiaSocial.models.Conteudo;
import midiaSocial.models.Publicacao;
import midiaSocial.models.Estatisticas;

public class TikTokAdapter implements MidiaSocial {

    private final TiktokAPI api;

    public TikTokAdapter(TiktokAPI api) {
        this.api = api;
    }

    @Override
    public Publicacao postar(Conteudo conteudo) throws MidiaSocialException {
        try {
            api.postarVideo(conteudo.getImagemUrl(), conteudo.getTexto());
            String id = "TT-" + System.currentTimeMillis();
            return new Publicacao(id, "TikTok", conteudo.getTexto());
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao postar no TikTokAdapter", e);
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) throws MidiaSocialException {
        try {
            String stats = api.obterDadosVideo(idPublicacao);
            return new Estatisticas("TikTok", stats);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao obter estatísticas do TikTok", e);
        }
    }
}

