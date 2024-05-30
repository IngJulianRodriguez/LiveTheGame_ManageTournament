package com.livethegame.ManageTournament.repository;

import com.livethegame.ManageTournament.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
