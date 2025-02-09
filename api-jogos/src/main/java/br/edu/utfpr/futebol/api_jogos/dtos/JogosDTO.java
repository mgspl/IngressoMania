package br.edu.utfpr.futebol.api_jogos.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.time.LocalDateTime;

public record JogosDTO(
        Long id,
        @NotNull
        @NonNull
        String timeCasa,
        @NotNull
        @NonNull
        String timeVisitante,
        @NotNull
        @NonNull
        String estadio,
        @NotNull
        @NonNull
        @Min(value = 1, message = "O valor do ingresso deve ser maior que R$ 1,00 ")
        Double precoIngresso,
        @NotNull
        @NonNull
        LocalDateTime dataHora
) {}
