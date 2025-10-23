package midiaSocial.adapters;

import midiaSocial.apis.TwitterAPI;
import midiaSocial.core.MidiaSocial;
import midiaSocial.core.exceptions.MidiaSocialException;
import midiaSocial.models.Conteudo;
import midiaSocial.models.Publicacao;
import midiaSocial.models.Estatisticas;

public class TwitterAdapter implements MidiaSocial {

    private final TwitterAPI api;

    public TwitterAdapter(TwitterAPI api) {
        this.api = api;
    }

    @Override
    public Publicacao postar(Conteudo conteudo) throws MidiaSocialException {
        try {
            //A API do twitter espera receber um texto para ser "tuítado"
            String retorno = api.tweetar(conteudo.getTexto());

            //Gera um ID unico simulando o retorno da API
            String id = "TW-" + System.currentTimeMillis();

            
            return new Publicacao(id, "Twitter", retorno);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao postar no TwitterAdapter", e);
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) throws MidiaSocialException {
        try {
            return new Estatisticas(120, 35, 8);
        } catch (Exception e) {
            throw new MidiaSocialException("Erro ao obter estatísticas do Twitter", e);
        }
    }
}
