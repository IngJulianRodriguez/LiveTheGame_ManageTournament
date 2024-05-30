package com.livethegame.ManageTournament.controller;

import com.livethegame.ManageTournament.dto.TournamentResponse;
import com.livethegame.ManageTournament.exception.*;
import com.livethegame.ManageTournament.services.MonitoringService;
import com.livethegame.ManageTournament.services.TournamentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Api Manage Tournament")
@RestController
@RequestMapping("/tournaments")
public class ManageTournamentRestController {

    @Autowired
    TournamentService tournamentService;
    @Autowired
    MonitoringService monitoringService;

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        Long idTournament;
        try {
            idTournament = Long.parseLong(id);
            TournamentResponse tournamentResponse = tournamentService.getTournamentById(idTournament);
            return ResponseEntity.ok(tournamentResponse);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "/get-by-id/{id} Id tipo inválido: " + id);
        } catch (CategoryNotFoundException
                 | TournamentNotFoundException
                 | ParamsNotFoundException
                 | UserNotFoundException e) {
            monitoringService.registerControlledExceptionLog("","/get-by-id/{id} "+id+" "+e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            monitoringService.registerNotControlledExceptionLog("","/get-by-id/{id} "+id+" "+e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
    @GetMapping("/list")
    public ResponseEntity<?> listAll(){
        try {
            List<TournamentResponse> listTournamentResponse = tournamentService.list();
            monitoringService.registerSuccessLog("","/list "+listTournamentResponse);
            return ResponseEntity.ok(listTournamentResponse);
        } catch (Exception e) {
            monitoringService.registerNotControlledExceptionLog("","/list "+e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
    @GetMapping("/test-manage")
    public ResponseEntity<?> testManageTournament(){
        return ResponseEntity.ok().build();
    }
}
