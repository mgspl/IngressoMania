package br.edu.utfpr.futebol.api_jogos.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record JogoRequestDTO(String id,
                             @NotNull
                             @NonNull
                             int maxFans,
                             @NotNull
                             @NonNull
                             int registeredFans,
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
                             String dataJogo) {
}
