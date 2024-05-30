package com.livethegame.ManageTournament.services;

import com.livethegame.ManageTournament.Utils.Mapper;
import com.livethegame.ManageTournament.common.TournamentResponseMapper;
import com.livethegame.ManageTournament.dto.TournamentResponse;
import com.livethegame.ManageTournament.dto.TournamentRequest;
import com.livethegame.ManageTournament.entities.*;
import com.livethegame.ManageTournament.exception.CategoryNotFoundException;
import com.livethegame.ManageTournament.exception.TournamentNotFoundException;
import com.livethegame.ManageTournament.exception.ParamsNotFoundException;
import com.livethegame.ManageTournament.exception.TournamentTypeNotFoundException;
import com.livethegame.ManageTournament.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ParamsRepository paramsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TournamentTypeRepository tournamentTypeRepository;
    @Autowired
    TournamentResponseMapper tournamentResponseMapper;


    public TournamentResponse getTournamentById(Long idTorneo){
        Optional<Tournaments> optionalTournament = tournamentRepository.findById(idTorneo);
        if(optionalTournament.isEmpty()) {
            throw new TournamentNotFoundException("Torneo no encontrado con ID: " + idTorneo);
        }
        TournamentResponse tournamentResponse
                = tournamentResponseMapper.TournamentToTournamentResponse(optionalTournament.get());

        return tournamentResponse;
    }
    public List<TournamentResponse> list(){
        List<Tournaments> listTickets = tournamentRepository.findAll();
        List<TournamentResponse> listTournamentResponse
                = tournamentResponseMapper.ListTournamentToListTournamentResponse(listTickets);
        return listTournamentResponse;
    }

}
