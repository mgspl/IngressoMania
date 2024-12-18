package com.te29s.apitimes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClubDTO(
        @NotBlank(message = "Nome completo do time vazio!")
        //@NotNull(message = "Nome completo do time vazio!")
        String fullname,
        @NotBlank(message = "Nome do time vazio!")
        //@NotNull(message = "Nome do time vazio!")
        String knownName,
        @NotBlank(message = "Apelido do time vazio!")
        //@NotNull(message = "Apelido do time vazio!")
        String nickname,
        @NotBlank(message = "Nome dos torcedores vazio")
        //@NotNull(message = "Nome dos torcedores vazio")
        String fansName,
        @NotBlank(message = "Cidade do time vazia!")
        //@NotNull(message = "Cidade do time vazia!")
        String city,
        @NotBlank(message = "Estado do time vazio!")
        //@NotNull(message = "Estado do time vazio!")
        @Size(min = 2, max = 2, message = "Utilize a sigla do estado!")
        String state,
        @NotBlank(message = "Nome do estadio vazio!")
        //@NotNull(message = "Nome do estadio vazio!")
        String stadium
) {}

