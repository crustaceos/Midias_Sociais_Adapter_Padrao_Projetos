package midiaSocial.core;

import midiaSocial.models.Conteudo;
import midiaSocial.models.Publicacao;
import midiaSocial.models.Estatisticas;
import midiaSocial.core.exceptions.MidiaSocialException;

public interface MidiaSocial {

    Publicacao postar(Conteudo conteudo) throws MidiaSocialException;
    Estatisticas obterEstatisticas(String idPublicacao) throws MidiaSocialException;
    
}
