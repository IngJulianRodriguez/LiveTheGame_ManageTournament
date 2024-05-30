package com.livethegame.ManageTournament.common;

import com.livethegame.ManageTournament.dto.TournamentResponse;
import com.livethegame.ManageTournament.entities.Tournaments;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TournamentResponseMapper {
    TournamentResponse TournamentToTournamentResponse(Tournaments source);
    List<TournamentResponse> ListTournamentToListTournamentResponse(List<Tournaments> source);
}
