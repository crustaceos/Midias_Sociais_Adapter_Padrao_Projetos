package midiaSocial.core;

import midiaSocial.models.*;
import java.util.concurrent.ConcurrentHashMap;

public class GerenciadorMidiaSocial {

    private ConcurrentHashMap<String, MidiaSocial> plataformas = new ConcurrentHashMap<>();

    public void adicionarPlataforma(String nome, MidiaSocial midia) {

        plataformas.put(nome, midia);

    }

    public RespostaUnificada postar(String nomePlataforma, Conteudo conteudo) {

        try {
            MidiaSocial midia = plataformas.get(nomePlataforma);
            if (midia == null)
                return new RespostaUnificada(false, "Plataforma não encontrada");

            Publicacao pub = midia.postar(conteudo);
            return new RespostaUnificada(true, "Publicado com sucesso", pub);
        } catch (Exception e) {
            return new RespostaUnificada(false, "Erro ao publicar: " + e.getMessage());
        }
        
    }
}
