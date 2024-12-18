package com.te29s.apitimes.repositories;

import com.te29s.apitimes.models.ClubModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepo extends JpaRepository<ClubModel, Long> {
    List<ClubModel> findAllByCityContaining(@NotNull @NonNull String city);

    List<ClubModel> findAllByState(@NotNull @Size(min = 2, max = 2, message = "Utilize a sigla do estado!") @NonNull String state);

    List<ClubModel> findAllByKnownnameContaining(@NotNull @NonNull String knownname);
}
