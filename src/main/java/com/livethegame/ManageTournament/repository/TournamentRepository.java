package com.livethegame.ManageTournament.repository;

import com.livethegame.ManageTournament.entities.Tournaments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournaments, Long> {
}
