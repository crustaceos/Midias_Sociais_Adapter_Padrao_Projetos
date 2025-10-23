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
            //A Api espera receber um texto e uma imagem
            String retorno = api.postarVideo(conteudo.getTexto(), conteudo.getImagemUrl());

            String id = "TT-" + System.currentTimeMillis();
            return new Publicacao(id, "TikTok", retorno);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao postar no TikTokAdapter", e);
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {

        return new Estatisticas(300, 150, 20);
        
    }
}
