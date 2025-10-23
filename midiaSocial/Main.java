package midiaSocial;

import midiaSocial.core.MidiaSocial;
import midiaSocial.core.MidiaSocialFactory;
import midiaSocial.core.exceptions.MidiaSocialException;
import midiaSocial.models.Conteudo;
import midiaSocial.models.Publicacao;
import midiaSocial.models.Estatisticas;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== GERENCIADOR DE MIDIAS SOCIAIS ===");

        //Exemplo de conteudo
        Conteudo conteudo = new Conteudo(
            "Lançamento do novo produto",
            "Teste"
        );

        try {
            
            MidiaSocial twitter = MidiaSocialFactory.criar("twitter");
            MidiaSocial instagram = MidiaSocialFactory.criar("instagram");
            MidiaSocial linkedin = MidiaSocialFactory.criar("linkedin");
            MidiaSocial tiktok = MidiaSocialFactory.criar("tiktok");

            //Postagens em diferentes plataformas
            Publicacao pubTwitter = twitter.postar(conteudo);
            Publicacao pubInstagram = instagram.postar(conteudo);
            Publicacao pubLinkedin = linkedin.postar(conteudo);
            Publicacao pubTiktok = tiktok.postar(conteudo);

            //Exibindo resultados das postagens
            System.out.println("\nPublicações realizadas com sucesso:\n");
            System.out.println(pubTwitter.getPlataforma() + ": " + pubTwitter.getConteudo());
            System.out.println(pubInstagram.getPlataforma() + ": " + pubInstagram.getConteudo());
            System.out.println(pubLinkedin.getPlataforma() + ": " + pubLinkedin.getConteudo());
            System.out.println(pubTiktok.getPlataforma() + ": " + pubTiktok.getConteudo());

            //Obtendo estatísticas simuladas
            System.out.println("\n📊 Estatísticas das publicações:\n");
            exibirEstatisticas(pubTwitter.getPlataforma(), twitter.obterEstatisticas(pubTwitter.getId()));
            exibirEstatisticas(pubInstagram.getPlataforma(), instagram.obterEstatisticas(pubInstagram.getId()));
            exibirEstatisticas(pubLinkedin.getPlataforma(), linkedin.obterEstatisticas(pubLinkedin.getId()));
            exibirEstatisticas(pubTiktok.getPlataforma(), tiktok.obterEstatisticas(pubTiktok.getId()));

        } catch (MidiaSocialException e) {
            System.err.println("Erro no gerenciamento de mídia social: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void exibirEstatisticas(String plataforma, Estatisticas est) {
        System.out.println(plataforma + " → Curtidas: " + est.getCurtidas() +
                ", Comentários: " + est.getComentarios() +
                ", Compartilhamentos: " + est.getCompartilhamentos());
    }
}
