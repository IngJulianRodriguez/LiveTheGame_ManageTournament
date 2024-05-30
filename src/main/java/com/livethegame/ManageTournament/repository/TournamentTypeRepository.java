package com.livethegame.ManageTournament.repository;

import com.livethegame.ManageTournament.entities.TournamentTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentTypeRepository extends JpaRepository<TournamentTypes, Long> {
}
