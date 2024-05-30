package com.livethegame.ManageTournament;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livethegame.ManageTournament.common.TournamentResponseMapper;
import com.livethegame.ManageTournament.controller.ManageTournamentRestController;
import com.livethegame.ManageTournament.dto.TournamentRequest;
import com.livethegame.ManageTournament.dto.TournamentResponse;
import com.livethegame.ManageTournament.repository.CategoryRepository;
import com.livethegame.ManageTournament.repository.TournamentRepository;
import com.livethegame.ManageTournament.services.TournamentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Base64;

@WebMvcTest(ManageTournamentRestController.class)
@AutoConfigureMockMvc
class ManageTournamentApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentRepository tournamentRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private TournamentService tournamentService;
    @MockBean
    private TournamentResponseMapper tournamentResponseMapper;

    private static final String PASSWORD = "admin";
    private static final String Tournament = "admin";

    @Test
    public void testCreateTournament_Success() throws Exception {
        TournamentRequest request = new TournamentRequest();
        TournamentResponse response = new TournamentResponse();
        response.setId(1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/tournaments/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testCreateTournament_Business_CategoryNotFound() throws Exception {

    }

    @Test
    public void testCreateTournament_Business_TournamentTypeNotFound() throws Exception {

    }

    @Test
    public void testCreateTournament_Business_WithoutAuthorization() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Tournaments/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testCreateTournament_Business_testUnauthorizedAccess() throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodingParaUsuarioSinPermiso = encoder.encodeToString(("usuario" + ":" + "password").getBytes());
        mockMvc.perform(MockMvcRequestBuilders.get("/Tournaments/create")
                        .header("Authorization", "Basic " + encodingParaUsuarioSinPermiso)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
