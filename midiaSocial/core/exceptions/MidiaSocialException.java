package midiaSocial.core.exceptions;
//Para "tratativa" do erro granular
public class MidiaSocialException extends Exception {

    public MidiaSocialException(String message) {

        super(message);

    }
    public MidiaSocialException(String message, Throwable cause) {

        super(message, cause);

    }
}
