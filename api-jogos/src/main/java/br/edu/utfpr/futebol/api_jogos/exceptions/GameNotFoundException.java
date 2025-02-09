package br.edu.utfpr.futebol.api_jogos.exceptions;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException() {
        super("Jogo não encontrado");
    }

    public GameNotFoundException(String message) {
        super(message);
    }
}

