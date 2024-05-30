package com.livethegame.ManageTournament.repository;

import com.livethegame.ManageTournament.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
