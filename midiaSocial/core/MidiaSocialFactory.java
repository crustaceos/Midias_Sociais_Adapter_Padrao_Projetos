package midiaSocial.core;

import midiaSocial.adapters.*;
import midiaSocial.apis.*;
import midiaSocial.core.exceptions.MidiaSocialException;

//Factory de midia social permite criar novas midias social

public class MidiaSocialFactory {

    public static MidiaSocial criar(String plataforma) throws MidiaSocialException {
        if (plataforma == null || plataforma.isBlank()) {
            throw new MidiaSocialException("Plataforma não pode ser nula ou vazia.");
        }

        switch (plataforma.toLowerCase()) {
            case "twitter":
                return new TwitterAdapter(new TwitterAPI());

            case "linkedin":
                return new LinkedinAdapter(new LinkedinAPI());

            case "tiktok":
                return new TikTokAdapter(new TiktokAPI());

            case "instagram":
                return new InstagramAdapter(new InstagramAPI());

            default:
                throw new MidiaSocialException("Plataforma não suportada: " + plataforma);
        }
    }
}
