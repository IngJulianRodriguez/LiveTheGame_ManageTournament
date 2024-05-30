package com.livethegame.ManageTournament.dto;

import com.livethegame.ManageTournament.entities.TournamentTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ApiModel()
public class TournamentResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;
    @ApiModelProperty(name = "Fecha de inicio", required = true,example = "", value = "")
    private LocalDate start_date;
    @ApiModelProperty(name = "Hora de inicio", required = true,example = "", value = "")
    private String start_time;
    @ApiModelProperty(name = "Estado del torneo", required = true,example = "", value = "")
    private boolean is_active;
    @ApiModelProperty(name = "Tipo", required = true,example = "", value = "")
    private TournamentTypes tournament_type;

    public TournamentResponse(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart_date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        return start_date.format(formatter);
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String is_active() {
        return is_active ? "Activo": "Inactivo";
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }


    public String getTournament_type() {
        return tournament_type.getName();
    }

    public void setTournament_type(TournamentTypes tournament_type) {
        this.tournament_type = tournament_type;
    }


}
