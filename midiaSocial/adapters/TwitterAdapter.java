package midiaSocial.adapters;

import midiaSocial.apis.TwitterAPI;
import midiaSocial.core.MidiaSocial;
import midiaSocial.models.*;

public class TwitterAdapter implements MidiaSocial {

    private TwitterAPI twitterAPI;

    public TwitterAdapter() {

        this.twitterAPI = new TwitterAPI();

    }

    @Override
    public Publicacao postar(Conteudo conteudo) {

        twitterAPI.tweetar(conteudo.getTexto());

        return new Publicacao("TW-" + System.currentTimeMillis(), "Twitter", conteudo.getTexto());


    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        return new Estatisticas(100, 20, 10);
    }
}
