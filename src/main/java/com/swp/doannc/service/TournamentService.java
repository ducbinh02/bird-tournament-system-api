package com.swp.doannc.service;

import com.swp.doannc.dto.*;
import com.swp.doannc.model.Bird;
import com.swp.doannc.model.Round;
import com.swp.doannc.model.Tournament;

import java.util.List;

public interface TournamentService {

    CreateTournamentResponse createTournament(CreateTournamentRequest createTournamentRequest);

    List<Tournament> getAllTournament();

    List<Round> getAllRoundOfTournament(Long tournamentId);

    Round getRoundOfTournament(Long id);

    List<Bird> getBirdOfRound(Long id);

    AddBirdPointResponse addBirdPoint(AddBirdPointRequest addBirdPointRequest);

    JoinTournamentResponse joinTournament(JoinTournamentRequest joinTournamentRequest);
}
