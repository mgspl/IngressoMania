package com.te29s.apitimes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

//TODO: Adicionar alguma constraint unique.
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClubModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_time")
    @SequenceGenerator(name = "seq_time", sequenceName = "seq_time", allocationSize = 1)
    private Long id;
    @NotNull
    @NonNull
    private String fullname;
    @NotNull
    @NonNull
    private String knownname;
    @NotNull
    @NonNull
    private String nickname;
    @NotNull
    @NonNull
    private String fansname;
    @NotNull
    @NonNull
    private String city;
    @NotNull
    @Size(min = 2, max = 2, message = "Utilize a sigla do estado!")
    @NonNull
    private String state;
    @NotNull
    @NonNull
    private String stadium;

}
