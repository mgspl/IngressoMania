package br.edu.utfpr.futebol.api_jogos.dtos;

import java.time.LocalDateTime;

public record JogosDTO(
        Long id,
        String timeCasa,
        String timeVisitante,
        String estadio,
        Double precoIngresso,
        LocalDateTime dataHora
) {}
