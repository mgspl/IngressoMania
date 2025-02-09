package br.edu.utfpr.futebol.api_jogos.exceptions;

public class GameFullException extends RuntimeException{
    public GameFullException() {
        super("Os ingressos para o jogo esgotaram");
    }

    public GameFullException(String message) {
        super(message);
    }
}
