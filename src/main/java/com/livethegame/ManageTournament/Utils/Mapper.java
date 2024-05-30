package com.livethegame.ManageTournament.Utils;

import com.livethegame.ManageTournament.dto.TournamentRequest;
import com.livethegame.ManageTournament.entities.Categories;
import com.livethegame.ManageTournament.entities.Tournaments;
import com.livethegame.ManageTournament.entities.TournamentTypes;

public  class Mapper {
    public static Tournaments TournamentRequestToTournament(TournamentRequest source, Categories categories, TournamentTypes tournamentType, double commission){
        Tournaments tournament = new Tournaments();
        tournament.setStart_date(source.getStart_date());
        tournament.setStart_time(source.getStart_time());
        tournament.setCategory(categories);
        tournament.setTournament_type(tournamentType);
        tournament.setCommission(commission);
        return tournament;
    };
}
